package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ce_dnote_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CeDnoteMaster extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "master_id", nullable = false)
  private UUID masterId;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "slno")
  private Long slNo;

  @Column(name = "subscriberid")
  private Long subscriberId;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "notenumber")
  private String noteNumber;

  @Column(name = "notemonth")
  private String noteMonth;

  @Column(name = "notedate")
  private LocalDate noteDate;

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
  private BigDecimal cGstValue;

  @Column(name = "sgst_value")
  private BigDecimal sGstValue;

  @Column(name = "igst_value")
  private BigDecimal iGstValue;

  @Column(name = "cgst_rate")
  private BigDecimal cGstRate;

  @Column(name = "sgst_rate")
  private BigDecimal sGstRate;

  @Column(name = "igst_rate")
  private BigDecimal iGstRate;

  @Column(name = "paid_amount")
  private BigDecimal paidAmount = BigDecimal.ZERO;

  @Column(name = "gstin")
  private String gstIn;

  @Column(name = "taxpayertype")
  private Short taxPayerType;

  @Column(name = "particulars")
  private String particulars;
}
