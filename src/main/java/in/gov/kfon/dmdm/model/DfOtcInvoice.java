package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_otcinovoice")
@Data
public class DfOtcInvoice extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "slno")
  private Integer slno;

  @Column(name = "subscriberid")
  private Long subscriberId;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "mg_invoiceid")
  private Integer mgInvoiceId;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "billing_type")
  private Integer billingType;

  @Column(name = "invoiceno")
  private String invoiceNo;

  @Column(name = "invoicedate")
  private Date invoiceDate;

  @Column(name = "grossamount")
  private BigDecimal grossAmount;

  @Column(name = "groupmount")
  private BigDecimal groupAmount;

  @Column(name = "servicetax")
  private BigDecimal serviceTax;

  @Column(name = "servicetaxrate")
  private BigDecimal serviceTaxRate;

  @Column(name = "servicestartdate")
  private Date serviceStartDate;

  @Column(name = "serviceenddate")
  private Date serviceEndDate;

  @Column(name = "quarter_start_date")
  private Date quarterStartDate;

  @Column(name = "quarter_end_date")
  private Date quarterEndDate;

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
  private String gstin;

  @Column(name = "particulars")
  private String particulars;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
