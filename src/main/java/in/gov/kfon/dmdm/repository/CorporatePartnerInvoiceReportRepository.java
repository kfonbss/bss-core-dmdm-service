package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.contract.CorporatePartnerInvoiceRegister;
import in.gov.kfon.dmdm.model.PartnerDetail;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * Corporate AGNP / LNP invoice registers (legacy {@code Cefincntl::corp_agnpinvoicegst_ajax} and
 * {@code Fincntl::corp_anpinvoicegst_ajax}). Read-only.
 *
 * <p>Both tables share one shape; each source subquery only renames its partner and share columns
 * ({@code ptnr_id}, {@code ptnr_share}) so the joins, filters and sums below are written once.
 *
 * <p>Joins, against the PHP:
 *
 * <ul>
 *   <li>{@code partnerdetail} — inner, as in the PHP (an invoice with no partner row is not
 *       listed), but through {@code LATERAL ... LIMIT 1}: {@code partnerid} is not unique, and a
 *       plain join would repeat the invoice and inflate the totals.
 *   <li>work order → purchase order → customer — <b>left</b> here, inner in the PHP. The PHP's
 *       inner join silently dropped an invoice whose work order was missing, while its count query
 *       (which skips these joins) still counted it; listing it with a blank customer keeps the
 *       totals honest.
 *   <li>{@code gst_verification_details} — left, the check made in the invoice month (latest).
 * </ul>
 *
 * <p>Filters follow the AGNP Retail Invoice report: document date range, partner district, bank
 * account type, approval status and a free-text search.
 */
public interface CorporatePartnerInvoiceReportRepository extends Repository<PartnerDetail, UUID> {

  String AGNP_SOURCE =
      " FROM (SELECT c.*, c.agpid AS ptnr_id, c.agpshare AS ptnr_share"
          + " FROM cor_fin_agpinvoicing c) cor";

  String LNP_SOURCE =
      " FROM (SELECT c.*, c.partnerid AS ptnr_id, c.anpshare AS ptnr_share"
          + " FROM cor_fin_lcoinvoicing c) cor";

  /**
   * Document date: the stored invoice date, else the invoice month's last day — the legacy {@code
   * date("t-m-Y", invoicemonth)} fallback. A malformed month yields null rather than an error.
   */
  String DOCUMENT_DATE =
      "COALESCE(cor.invoicedate, CASE WHEN TRIM(cor.invoicemonth) ~ '^[0-9]{4}-[0-9]{2}$'"
          + " THEN CAST(to_date(TRIM(cor.invoicemonth) || '-01', 'YYYY-MM-DD')"
          + " + INTERVAL '1 month' - INTERVAL '1 day' AS date) END)";

  String JOINS =
      """
  INNER JOIN LATERAL (
        SELECT p.partnercompanyname, p.district, p.bank_acholder, p.bank_actype,
               p.bank_acno, p.bank_ifsc, p.bank_name
          FROM partnerdetail p
         WHERE p.partnerid = cor.ptnr_id
         ORDER BY p.is_active DESC NULLS LAST, p.modified_date DESC NULLS LAST
         LIMIT 1
        ) pd ON TRUE
  LEFT JOIN LATERAL (
        SELECT cc.company_name
          FROM ce_workorder cw
          JOIN ce_purchase_order cpo ON cpo.slno = cw.po_id
          JOIN ce_customers cc ON cc.id = cpo.customerid
         WHERE cw.wo_no = cor.workorderid
         LIMIT 1
        ) cust ON TRUE
  LEFT JOIN LATERAL (
        SELECT g.taxpayertype_in_portal, g.gstin_status_inportal, g.created_date
          FROM gst_verification_details g
         WHERE g.partnerid = CAST(cor.ptnr_id AS text)
           AND to_char(g.created_date, 'YYYY-MM') = TRIM(cor.invoicemonth)
         ORDER BY g.created_date DESC
         LIMIT 1
        ) gv ON TRUE
""";

  /**
   * Every filter optional. Dates bound the document date, inclusive. {@code partnerdetail.district}
   * is legacy free text (a name, code or the old numeric id), so {@code districtId} matches it
   * against that master row's name, code and numeric id, case-insensitive — as the Material
   * Purchase report does. Account type is a case-insensitive exact match; status compares the
   * approval code, a null status reading as {@code 0} (pending).
   */
  String WHERE_CLAUSE =
      " WHERE 1 = 1"
          + " AND (CAST(:fromDate AS date) IS NULL OR "
          + DOCUMENT_DATE
          + " >= CAST(:fromDate AS date))"
          + " AND (CAST(:toDate AS date) IS NULL OR "
          + DOCUMENT_DATE
          + " <= CAST(:toDate AS date))"
          + " AND (CAST(:districtId AS uuid) IS NULL OR UPPER(TRIM(pd.district)) IN ("
          + "        SELECT UPPER(TRIM(v))"
          + "          FROM district d,"
          + "               LATERAL (VALUES (d.name), (d.code), (CAST(d.id AS text))) x(v)"
          + "         WHERE d.district_id = CAST(:districtId AS uuid)))"
          + " AND (CAST(:accountType AS text) IS NULL"
          + "      OR UPPER(TRIM(pd.bank_actype)) = UPPER(CAST(:accountType AS text)))"
          + " AND (CAST(:status AS integer) IS NULL"
          + "      OR COALESCE(CAST(cor.status AS integer), 0) = CAST(:status AS integer))"
          + " AND (CAST(:search AS text) IS NULL OR ("
          + "         CAST(cor.ptnr_id AS text)   ILIKE CAST(:search AS text)"
          + "      OR pd.partnercompanyname       ILIKE CAST(:search AS text)"
          + "      OR cor.invoiceno               ILIKE CAST(:search AS text)"
          + "      OR cor.workorderid             ILIKE CAST(:search AS text)"
          + "      OR cust.company_name           ILIKE CAST(:search AS text)"
          + "      OR pd.district                 ILIKE CAST(:search AS text)))";

  String SELECT_COLUMNS =
      "SELECT CAST(cor.slno AS bigint)                     AS \"slno\","
          + " CAST(cor.ptnr_id AS bigint)                  AS \"partnerId\","
          + " pd.partnercompanyname                        AS \"partnerName\","
          + " pd.district                                  AS \"district\","
          + " cor.workorderid                              AS \"workOrderId\","
          + " cust.company_name                            AS \"customerName\","
          + " cor.invoiceno                                AS \"invoiceNo\","
          + " TRIM(cor.invoicemonth)                       AS \"invoiceMonth\","
          + " "
          + DOCUMENT_DATE
          + "                                              AS \"invoiceDate\","
          + " CAST(cor.status AS integer)                  AS \"approvalStatus\","
          + " COALESCE(CAST(cor.is_active AS integer), 1)  AS \"isActive\","
          + " COALESCE(cor.nettotal, 0)                    AS \"revenue\","
          + " COALESCE(cor.ptnr_share, 0)                  AS \"partnerShare\","
          + " COALESCE(cor.netshare, 0)                    AS \"netShare\","
          + " COALESCE(cor.sgst_amount, 0)                 AS \"sgstAmount\","
          + " COALESCE(cor.cgst_amount, 0)                 AS \"cgstAmount\","
          + " COALESCE(cor.igst_amount, 0)                 AS \"igstAmount\","
          + " COALESCE(cor.gst_amount, 0)                  AS \"gstAmount\","
          + " COALESCE(cor.grossshare, 0)                  AS \"invoiceValue\","
          + " COALESCE(cor.tdspartner, 0)                  AS \"tdsPartner\","
          + " COALESCE(cor.cgsttds_amount, 0)              AS \"cgstTdsAmount\","
          + " COALESCE(cor.sgsttds_amount, 0)              AS \"sgstTdsAmount\","
          + " COALESCE(cor.netpayable, 0)                  AS \"netPayable\","
          + " COALESCE(cor.paid_amount, 0)                 AS \"paidAmount\","
          + " cor.gstin                                    AS \"gstin\","
          + " cor.pan                                      AS \"pan\","
          + " CAST(cor.taxpayertype AS integer)            AS \"taxpayerType\","
          + " pd.bank_acholder                             AS \"bankAccountHolder\","
          + " pd.bank_actype                               AS \"bankAccountType\","
          + " pd.bank_acno                                 AS \"bankAccountNo\","
          + " pd.bank_ifsc                                 AS \"bankIfsc\","
          + " pd.bank_name                                 AS \"bankName\","
          + " gv.taxpayertype_in_portal                    AS \"portalTaxpayerType\","
          + " gv.gstin_status_inportal                     AS \"portalGstStatus\","
          + " CAST(gv.created_date AS date)                AS \"portalCheckDate\"";

  String TOTAL_COLUMNS =
      "SELECT COUNT(*)                                     AS \"invoiceCount\","
          + " COALESCE(SUM(cor.nettotal), 0)               AS \"revenue\","
          + " COALESCE(SUM(cor.ptnr_share), 0)             AS \"partnerShare\","
          + " COALESCE(SUM(cor.netshare), 0)               AS \"netShare\","
          + " COALESCE(SUM(cor.sgst_amount), 0)            AS \"sgstAmount\","
          + " COALESCE(SUM(cor.cgst_amount), 0)            AS \"cgstAmount\","
          + " COALESCE(SUM(cor.igst_amount), 0)            AS \"igstAmount\","
          + " COALESCE(SUM(cor.gst_amount), 0)             AS \"gstAmount\","
          + " COALESCE(SUM(cor.grossshare), 0)             AS \"invoiceValue\","
          + " COALESCE(SUM(cor.tdspartner), 0)             AS \"tdsPartner\","
          + " COALESCE(SUM(cor.cgsttds_amount), 0)         AS \"cgstTdsAmount\","
          + " COALESCE(SUM(cor.sgsttds_amount), 0)         AS \"sgstTdsAmount\","
          + " COALESCE(SUM(cor.netpayable), 0)             AS \"netPayable\","
          + " COALESCE(SUM(cor.paid_amount), 0)            AS \"paidAmount\"";

  /** Newest document date first (as the retail report); ties in the legacy {@code slno} order. */
  String ORDER_BY = " ORDER BY " + DOCUMENT_DATE + " DESC NULLS LAST, cor.slno ASC";

  // ---- AGNP ---------------------------------------------------------------

  @Query(
      value = SELECT_COLUMNS + AGNP_SOURCE + JOINS + WHERE_CLAUSE + ORDER_BY,
      countQuery = "SELECT COUNT(*)" + AGNP_SOURCE + JOINS + WHERE_CLAUSE,
      nativeQuery = true)
  Page<CorporatePartnerInvoiceRegister.Row> findAgnpRegister(
      @Param("fromDate") LocalDate fromDate,
      @Param("toDate") LocalDate toDate,
      @Param("districtId") UUID districtId,
      @Param("accountType") String accountType,
      @Param("status") Integer status,
      @Param("search") String search,
      Pageable pageable);

  @Query(value = TOTAL_COLUMNS + AGNP_SOURCE + JOINS + WHERE_CLAUSE, nativeQuery = true)
  CorporatePartnerInvoiceRegister.Totals findAgnpTotals(
      @Param("fromDate") LocalDate fromDate,
      @Param("toDate") LocalDate toDate,
      @Param("districtId") UUID districtId,
      @Param("accountType") String accountType,
      @Param("status") Integer status,
      @Param("search") String search);

  // ---- LNP ----------------------------------------------------------------

  @Query(
      value = SELECT_COLUMNS + LNP_SOURCE + JOINS + WHERE_CLAUSE + ORDER_BY,
      countQuery = "SELECT COUNT(*)" + LNP_SOURCE + JOINS + WHERE_CLAUSE,
      nativeQuery = true)
  Page<CorporatePartnerInvoiceRegister.Row> findLnpRegister(
      @Param("fromDate") LocalDate fromDate,
      @Param("toDate") LocalDate toDate,
      @Param("districtId") UUID districtId,
      @Param("accountType") String accountType,
      @Param("status") Integer status,
      @Param("search") String search,
      Pageable pageable);

  @Query(value = TOTAL_COLUMNS + LNP_SOURCE + JOINS + WHERE_CLAUSE, nativeQuery = true)
  CorporatePartnerInvoiceRegister.Totals findLnpTotals(
      @Param("fromDate") LocalDate fromDate,
      @Param("toDate") LocalDate toDate,
      @Param("districtId") UUID districtId,
      @Param("accountType") String accountType,
      @Param("status") Integer status,
      @Param("search") String search);
}
