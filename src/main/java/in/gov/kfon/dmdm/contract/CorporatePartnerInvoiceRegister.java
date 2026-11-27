package in.gov.kfon.dmdm.contract;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Read-only projections over the legacy corporate partner invoices — {@code cor_fin_agpinvoicing}
 * (AGNP) and {@code cor_fin_lcoinvoicing} (LNP) — joined to {@code partnerdetail}, the work order's
 * customer and the month's GST portal check. Raw values only — labels and the totals row are built
 * by the finance service.
 */
public final class CorporatePartnerInvoiceRegister {

  private CorporatePartnerInvoiceRegister() {}

  /** Which corporate invoice table a request reads. */
  public enum Kind {
    /** {@code cor_fin_agpinvoicing}, partner = {@code agpid}, share = {@code agpshare}. */
    AGNP,
    /** {@code cor_fin_lcoinvoicing}, partner = {@code partnerid}, share = {@code anpshare}. */
    LNP
  }

  public interface Row {

    Long getSlno();

    Long getPartnerId();

    String getPartnerName();

    /** {@code partnerdetail.district} (legacy text). */
    String getDistrict();

    String getWorkOrderId();

    /** {@code ce_customers.company_name} through the work order's purchase order. */
    String getCustomerName();

    String getInvoiceNo();

    /** {@code yyyy-MM}. */
    String getInvoiceMonth();

    /** Stored invoice date, else the invoice month's last day — the document date. */
    LocalDate getInvoiceDate();

    /** {@code 1} approved, {@code 2} clarification requested, {@code 3} provided, else pending. */
    Integer getApprovalStatus();

    /** {@code 1} active, {@code 0} cancelled; a null column is read as active. */
    Integer getIsActive();

    /** {@code nettotal} — revenue the share was computed on. */
    BigDecimal getRevenue();

    /** {@code agpshare} (AGNP) / {@code anpshare} (LNP). */
    BigDecimal getPartnerShare();

    BigDecimal getNetShare();

    BigDecimal getSgstAmount();

    BigDecimal getCgstAmount();

    BigDecimal getIgstAmount();

    BigDecimal getGstAmount();

    /** {@code grossshare} — the invoice value. */
    BigDecimal getInvoiceValue();

    BigDecimal getTdsPartner();

    BigDecimal getCgstTdsAmount();

    BigDecimal getSgstTdsAmount();

    BigDecimal getNetPayable();

    BigDecimal getPaidAmount();

    String getGstin();

    String getPan();

    /** Invoice snapshot, {@code 0} / {@code 1} (stored as boolean by the migration). */
    Integer getTaxpayerType();

    String getBankAccountHolder();

    /** {@code partnerdetail.bank_actype} — CA / SB. */
    String getBankAccountType();

    String getBankAccountNo();

    String getBankIfsc();

    String getBankName();

    /** {@code gst_verification_details} of the invoice month — null when never checked. */
    Integer getPortalTaxpayerType();

    String getPortalGstStatus();

    LocalDate getPortalCheckDate();
  }

  public interface Totals {

    Long getInvoiceCount();

    BigDecimal getRevenue();

    BigDecimal getPartnerShare();

    BigDecimal getNetShare();

    BigDecimal getSgstAmount();

    BigDecimal getCgstAmount();

    BigDecimal getIgstAmount();

    BigDecimal getGstAmount();

    BigDecimal getInvoiceValue();

    BigDecimal getTdsPartner();

    BigDecimal getCgstTdsAmount();

    BigDecimal getSgstTdsAmount();

    BigDecimal getNetPayable();

    BigDecimal getPaidAmount();
  }
}
