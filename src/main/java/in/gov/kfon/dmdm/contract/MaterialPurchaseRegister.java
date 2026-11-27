package in.gov.kfon.dmdm.contract;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Read-only projections over the legacy ONT purchase invoices ({@code lnp_ont_invoicing}) joined to
 * {@code partnerdetail}. Raw amounts only — net payable, masking and labels are derived by the
 * finance service.
 */
public final class MaterialPurchaseRegister {

  private MaterialPurchaseRegister() {}

  public interface Row {

    Long getSlno();

    Long getPartnerId();

    String getPartnerName();

    String getDistrict();

    String getDocumentNo();

    LocalDate getDocumentDate();

    /** {@code 1} active, {@code 0} cancelled; a null column is read as active. */
    Integer getIsActive();

    BigDecimal getTaxableValue();

    BigDecimal getSgstAmount();

    BigDecimal getCgstAmount();

    BigDecimal getGstAmount();

    BigDecimal getGrossAmount();

    BigDecimal getTdsPartner();

    BigDecimal getCgstTdsAmount();

    BigDecimal getSgstTdsAmount();

    String getGstin();

    String getPan();

    Integer getTaxpayerType();

    String getBankAccountHolder();

    String getBankAccountType();

    String getBankName();

    String getBankBranch();

    String getBankAccountNo();

    String getBankIfsc();
  }

  public interface Totals {

    Long getInvoiceCount();

    BigDecimal getTaxableValue();

    BigDecimal getGstAmount();

    BigDecimal getCgstAmount();

    BigDecimal getSgstAmount();

    BigDecimal getGrossAmount();

    /** {@code SUM(TDSPartner + cgsttds_amount + sgsttds_amount)}. */
    BigDecimal getTdsWithheld();
  }
}
