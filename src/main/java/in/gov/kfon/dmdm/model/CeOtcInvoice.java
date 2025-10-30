package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_otcinovoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeOtcInvoice extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "invoice_id")
  private UUID invoiceId;

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

  @Column(name = "mg_invoiceid")
  private Integer mgInvoiceId;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "invoiceno")
  private String invoiceNo;

  @Column(name = "invoicedate")
  private LocalDate invoiceDate;

  @Column(name = "grossamount")
  private BigDecimal grossAmount;

  @Column(name = "otcamount")
  private BigDecimal otcAmount;

  @Column(name = "servicetax")
  private BigDecimal serviceTax;

  @Column(name = "servicetaxrate")
  private BigDecimal serviceTaxRate;

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

  @Column(name = "gstin")
  private String gstIn;

  @Column(name = "particulars")
  private String particulars;
}
