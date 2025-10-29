package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_inovoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeInovoice extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "inovoice_id", nullable = false)
  private UUID inovoiceId;

  @Column(name = "code", length = 45)
  private String code;

  @Column(name = "name", length = 255)
  private String name;

  @Column(name = "name_in_local", length = 255)
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

  @Column(name = "invoiceno", length = 64)
  private String invoiceNo;

  @Column(name = "invoicedate")
  private LocalDate invoiceDate;

  @Column(name = "grossamount", precision = 26, scale = 10)
  private BigDecimal grossAmount;

  @Column(name = "locamount", precision = 26, scale = 10)
  private BigDecimal locAmount;

  @Column(name = "servicetax", precision = 10, scale = 10)
  private BigDecimal serviceTax;

  @Column(name = "servicetaxrate", precision = 10, scale = 10)
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

  @Column(name = "cgst_rate", precision = 26, scale = 2)
  private BigDecimal cgstRate;

  @Column(name = "sgst_rate", precision = 26, scale = 2)
  private BigDecimal sgstRate;

  @Column(name = "igst_rate", precision = 26, scale = 2)
  private BigDecimal igstRate;

  @Column(name = "gstin", length = 18)
  private String gstIn;

  @Column(name = "particulars", length = 180)
  private String particulars;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "enable_opay")
  private Boolean enableOpay;

  @Column(name = "status_opay")
  private Boolean statusOpay;

  @Column(name = "taxpayertype")
  private Short taxPayerType;

  @Column(name = "loc_reccount")
  private Integer locRecCount;
}
