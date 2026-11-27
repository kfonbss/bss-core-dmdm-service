package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.contract.MaterialPurchaseRegister;
import in.gov.kfon.dmdm.model.PartnerDetail;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * Material Purchases from Partners (legacy {@code fincntl/ontinvoices}). Read-only.
 *
 * <p>{@code partnerdetail.partnerid} is not unique, so the partner is picked through a {@code
 * LATERAL ... LIMIT 1} (active row first) — a plain join would repeat an invoice once per duplicate
 * partner row and inflate the summary. It stays an inner join, as in the PHP page: an invoice with
 * no partner row is not listed.
 */
public interface MaterialPurchaseReportRepository extends Repository<PartnerDetail, UUID> {

  String FROM_CLAUSE =
      """
   FROM lnp_ont_invoicing loi
  INNER JOIN LATERAL (
        SELECT p.partnercompanyname, p.district,
               p.bank_acholder, p.bank_actype, p.bank_name,
               p.bank_branch, p.bank_acno, p.bank_ifsc
          FROM partnerdetail p
         WHERE p.partnerid = loi.partnerid
         ORDER BY p.is_active DESC NULLS LAST, p.modified_date DESC NULLS LAST
         LIMIT 1
        ) pd ON TRUE
""";

  /**
   * Half-open date window on {@code create_date}; every filter optional. {@code partnerdetail}
   * keeps the district as legacy text, so the master district is matched on its name, code or
   * numeric id.
   */
  String WHERE_CLAUSE =
      """
  WHERE 1 = 1
    AND (CAST(:activeFlag AS integer) IS NULL
         OR COALESCE(loi.is_active, 1) = CAST(:activeFlag AS integer))
    AND (CAST(:fromDate AS date) IS NULL OR loi.create_date >= CAST(:fromDate AS date))
    AND (CAST(:toExclusive AS date) IS NULL OR loi.create_date < CAST(:toExclusive AS date))
    AND (CAST(:month AS text) IS NULL OR TRIM(loi.invoicemonth) = CAST(:month AS text))
    AND (CAST(:districtId AS uuid) IS NULL OR UPPER(TRIM(pd.district)) IN (
          SELECT UPPER(TRIM(v))
            FROM district d,
                 LATERAL (VALUES (d.name), (d.code), (CAST(d.id AS text))) x(v)
           WHERE d.district_id = CAST(:districtId AS uuid)))
    AND (CAST(:search AS text) IS NULL OR (
             pd.partnercompanyname        ILIKE CAST(:search AS text)
          OR CAST(loi.partnerid AS text)  ILIKE CAST(:search AS text)
          OR loi.invoiceno                ILIKE CAST(:search AS text)
          OR pd.district                  ILIKE CAST(:search AS text)
          OR pd.bank_name                 ILIKE CAST(:search AS text)))
""";

  @Query(
      value =
          "SELECT CAST(loi.slno AS bigint)              AS \"slno\","
              + " CAST(loi.partnerid AS bigint)         AS \"partnerId\","
              + " pd.partnercompanyname                 AS \"partnerName\","
              + " pd.district                           AS \"district\","
              + " loi.invoiceno                         AS \"documentNo\","
              + " CAST(loi.create_date AS date)         AS \"documentDate\","
              + " COALESCE(loi.is_active, 1)            AS \"isActive\","
              + " COALESCE(loi.total_amount, 0)         AS \"taxableValue\","
              + " COALESCE(loi.sgst_amount, 0)          AS \"sgstAmount\","
              + " COALESCE(loi.cgst_amount, 0)          AS \"cgstAmount\","
              + " COALESCE(loi.gst_amount, 0)           AS \"gstAmount\","
              + " COALESCE(loi.gross_amount, 0)         AS \"grossAmount\","
              + " COALESCE(loi.tdspartner, 0)           AS \"tdsPartner\","
              + " COALESCE(loi.cgsttds_amount, 0)       AS \"cgstTdsAmount\","
              + " COALESCE(loi.sgsttds_amount, 0)       AS \"sgstTdsAmount\","
              + " loi.gstin                             AS \"gstin\","
              + " loi.pan                               AS \"pan\","
              + " loi.taxpayertype                      AS \"taxpayerType\","
              + " pd.bank_acholder                      AS \"bankAccountHolder\","
              + " pd.bank_actype                        AS \"bankAccountType\","
              + " pd.bank_name                          AS \"bankName\","
              + " pd.bank_branch                        AS \"bankBranch\","
              + " pd.bank_acno                          AS \"bankAccountNo\","
              + " pd.bank_ifsc                          AS \"bankIfsc\""
              + FROM_CLAUSE
              + WHERE_CLAUSE
              + " ORDER BY loi.slno DESC",
      countQuery = "SELECT COUNT(*)" + FROM_CLAUSE + WHERE_CLAUSE,
      nativeQuery = true)
  Page<MaterialPurchaseRegister.Row> findRegister(
      @Param("activeFlag") Integer activeFlag,
      @Param("fromDate") LocalDate fromDate,
      @Param("toExclusive") LocalDate toExclusive,
      @Param("month") String month,
      @Param("districtId") UUID districtId,
      @Param("search") String search,
      Pageable pageable);

  @Query(
      value =
          "SELECT COUNT(*)                                   AS \"invoiceCount\","
              + " COALESCE(SUM(loi.total_amount), 0)         AS \"taxableValue\","
              + " COALESCE(SUM(loi.gst_amount), 0)           AS \"gstAmount\","
              + " COALESCE(SUM(loi.cgst_amount), 0)          AS \"cgstAmount\","
              + " COALESCE(SUM(loi.sgst_amount), 0)          AS \"sgstAmount\","
              + " COALESCE(SUM(loi.gross_amount), 0)         AS \"grossAmount\","
              + " COALESCE(SUM(COALESCE(loi.tdspartner, 0)"
              + "            + COALESCE(loi.cgsttds_amount, 0)"
              + "            + COALESCE(loi.sgsttds_amount, 0)), 0) AS \"tdsWithheld\""
              + FROM_CLAUSE
              + WHERE_CLAUSE,
      nativeQuery = true)
  MaterialPurchaseRegister.Totals findTotals(
      @Param("activeFlag") Integer activeFlag,
      @Param("fromDate") LocalDate fromDate,
      @Param("toExclusive") LocalDate toExclusive,
      @Param("month") String month,
      @Param("districtId") UUID districtId,
      @Param("search") String search);
}
