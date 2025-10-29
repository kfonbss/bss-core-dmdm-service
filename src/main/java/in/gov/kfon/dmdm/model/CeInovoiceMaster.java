package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_inovoice_master")
@Data
public class CeInovoiceMaster extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "master_id", nullable = false)
  private UUID masterId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "slno")
  private Long slno;

  @Column(name = "subscriberid")
  private Long subscriberId;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "invoiceno")
  private String invoiceNo;

  @Column(name = "invoicemonth")
  private String invoiceMonth;

  @Column(name = "invoicedate")
  private LocalDate invoiceDate;

  @Column(name = "grossamount")
  private BigDecimal grossAmount;

  @Column(name = "locamount")
  private BigDecimal locAmount;

  @Column(name = "servicetax")
  private BigDecimal serviceTax;

  @Column(name = "servicetaxrate")
  private BigDecimal serviceTaxRate;

  @Column(name = "servicestartdate")
  private LocalDate serviceStartDate;

  @Column(name = "serviceenddate")
  private LocalDate serviceEndDate;

  @Column(name = "quarter_start_date")
  private LocalDate quarterStartDate;

  @Column(name = "quarter_end_date")
  private LocalDate quarterEndDate;

  @Column(name = "gst_value")
  private BigDecimal gstValue;

  @Column(name = "cgst_value")
  private BigDecimal cgstValue;

  @Column(name = "sgst_value")
  private BigDecimal sgstValue;

  @Column(name = "igst_value")
  private BigDecimal igstValue;

  @Column(name = "cgst_rate")
  private BigDecimal cgstRate;

  @Column(name = "sgst_rate")
  private BigDecimal sgstRate;

  @Column(name = "igst_rate")
  private BigDecimal igstRate;

  @Column(name = "paid_amount")
  private BigDecimal paidAmount;

  @Column(name = "gstin")
  private String gstin;

  @Column(name = "taxpayertype")
  private Short taxPayerType;

  @Column(name = "particulars")
  private String particulars;

  @Column(name = "einvoice_generated")
  private Boolean eInvoiceGenerated;

  @Column(name = "crnote_amount")
  private BigDecimal crNoteAmount;

  @Column(name = "crnote_gst")
  private BigDecimal crNoteGst;

  @Column(name = "crnote_total")
  private BigDecimal crNoteTotal;

  @Column(name = "poid")
  private Integer poId;
}
