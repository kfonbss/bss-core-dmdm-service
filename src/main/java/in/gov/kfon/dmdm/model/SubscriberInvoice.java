package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subscriberinovoice")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberInvoice extends Auditor {

  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "slno")
  private Long slno;

  @Column(name = "subscriberid")
  private Long subscriberId;

  @Column(name = "invoiceno")
  private String invoiceNo;

  @Column(name = "invoicedate")
  private LocalDate invoiceDate;

  @Column(name = "grossamount")
  private BigDecimal grossAmount;

  @Column(name = "particulars")
  private String particulars;

  @Column(name = "referenceid")
  private String referenceId;

  @Column(name = "package")
  private String packageName;

  @Column(name = "packagefee")
  private BigDecimal packageFee;

  @Column(name = "servicetax", precision = 10, scale = 2)
  private BigDecimal serviceTax;

  @Column(name = "servicetaxrate", precision = 10, scale = 2)
  private BigDecimal serviceTaxRate;

  @Column(name = "servicestartdate")
  private LocalDate serviceStartDate;

  @Column(name = "serviceenddate")
  private LocalDate serviceEndDate;

  @Column(name = "gst_value", precision = 26, scale = 15)
  private BigDecimal gstValue;

  @Column(name = "cgst_value", precision = 26, scale = 15)
  private BigDecimal cgstValue;

  @Column(name = "sgst_value", precision = 26, scale = 15)
  private BigDecimal sgstValue;

  @Column(name = "igst_value", precision = 26, scale = 15)
  private BigDecimal igstValue;

  @Column(name = "cgst_rate", precision = 10, scale = 2)
  private BigDecimal cgstRate;

  @Column(name = "sgst_rate", precision = 10, scale = 2)
  private BigDecimal sgstRate;

  @Column(name = "igst_rate", precision = 10, scale = 2)
  private BigDecimal igstRate;

  @Column(name = "gstin", length = 18)
  private String gstin;

  @Column(name = "tariff", precision = 10, scale = 2)
  private BigDecimal tariff;

  @Column(name = "discount_rate", precision = 10, scale = 2)
  private BigDecimal discountRate;

  @Column(name = "discount_value", precision = 10, scale = 2)
  private BigDecimal discountValue;

  @Column(name = "post_upload", precision = 10, scale = 2)
  private BigDecimal postUpload;

  @Column(name = "post_download", precision = 10, scale = 2)
  private BigDecimal postDownload;

  @Column(name = "term_count")
  private Integer termCount;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "taxpayertype")
  private Integer taxPayerType;

  @Column(name = "kfc_rate", precision = 10, scale = 2)
  private BigDecimal kfcRate;

  @Column(name = "kfc_value", precision = 10, scale = 2)
  private BigDecimal kfcValue;

  @Column(name = "acctsessiontime")
  private Long acctSessionTime;

  @Column(name = "gst_status")
  private Integer gstStatus;

  @Column(name = "rechargemode")
  private Integer rechargeMode;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "plantype")
  private Integer planType;

  @Column(name = "sub_caf_type")
  private Integer subCafType;

  @Column(name = "reccount")
  private Integer recCount;

  @Column(name = "churn_recovery_days")
  private Integer churnRecoveryDays;

  @Column(name = "is_churn_recovery")
  private Integer isChurnRecovery;

  @Column(name = "einvoice_generated")
  private Integer eInvoiceGenerated;

  @Column(name = "crnote_amount", precision = 26, scale = 10)
  private BigDecimal crNoteAmount;

  @Column(name = "crnote_gst", precision = 26, scale = 10)
  private BigDecimal crNoteGst;

  @Column(name = "crnote_total", precision = 26, scale = 10)
  private BigDecimal crNoteTotal;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;
}
