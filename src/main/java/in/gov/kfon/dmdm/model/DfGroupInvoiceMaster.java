package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_groupinovoice_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DfGroupInvoiceMaster extends Auditor {

  @Id
  @Column(name = "master_id", nullable = false, updatable = false)
  private UUID masterId;

  @Column(name = "slno")
  private Long slno;

  @Column(name = "subscriberid")
  private Long subscriberId;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "billing_type")
  private Integer billingType;

  @Column(name = "invoiceno", length = 64)
  private String invoiceNo;

  @Column(name = "invoicedate")
  private LocalDate invoiceDate;

  @Column(name = "grossamount", precision = 26, scale = 10)
  private BigDecimal grossAmount;

  @Column(name = "groupmount", precision = 26, scale = 10)
  private BigDecimal groupMount;

  @Column(name = "servicetax", precision = 15, scale = 10)
  private BigDecimal serviceTax;

  @Column(name = "servicetaxrate", precision = 10, scale = 2)
  private BigDecimal serviceTaxRate;

  @Column(name = "servicestartdate")
  private LocalDate serviceStartDate;

  @Column(name = "serviceenddate")
  private LocalDate serviceEndDate;

  @Column(name = "quarter_start_date")
  private LocalDate quarterStartDate;

  @Column(name = "quarter_end_date")
  private LocalDate quarterEndDate;

  @Column(name = "gst_value", precision = 26, scale = 10)
  private BigDecimal gstValue;

  @Column(name = "cgst_value", precision = 26, scale = 10)
  private BigDecimal cgstValue;

  @Column(name = "sgst_value", precision = 26, scale = 10)
  private BigDecimal sgstValue;

  @Column(name = "igst_value", precision = 26, scale = 10)
  private BigDecimal igstValue;

  @Column(name = "cgst_rate", precision = 15, scale = 6)
  private BigDecimal cgstRate;

  @Column(name = "sgst_rate", precision = 15, scale = 6)
  private BigDecimal sgstRate;

  @Column(name = "igst_rate", precision = 15, scale = 6)
  private BigDecimal igstRate;

  @Column(name = "gstin", length = 18)
  private String gstin;

  @Column(name = "taxpayertype")
  private Short taxPayerType;

  @Column(name = "particulars", length = 180)
  private String particulars;

  @Column(name = "einvoice_generated")
  private Short eInvoiceGenerated;

  @Column(name = "crnote_amount", precision = 26, scale = 10)
  private BigDecimal crNoteAmount;

  @Column(name = "crnote_gst", precision = 26, scale = 10)
  private BigDecimal crNoteGst;

  @Column(name = "crnote_total", precision = 26, scale = 10)
  private BigDecimal crNoteTotal;

  @Column(name = "paid_amount", length = 10)
  private String paidAmount;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
