package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partnergstinvoice")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerGstInvoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "slno")
  private Long slno;

  @Column(name = "state")
  private String state;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "ptype")
  private String ptype;

  @Column(name = "pst_code")
  private String pstCode;

  @Column(name = "billtype")
  private Integer billType;

  @Column(name = "invoiceno")
  private String invoiceNo;

  @Column(name = "invoicemonth")
  private String invoiceMonth;

  @Column(name = "taxable_value")
  private BigDecimal taxableValue;

  @Column(name = "bss_gstin")
  private String bssGstin;

  @Column(name = "taxpayertype")
  private Integer taxPayerType;

  @Column(name = "cgst_value")
  private BigDecimal cgstValue;

  @Column(name = "sgst_value")
  private BigDecimal sgstValue;

  @Column(name = "gst_value")
  private BigDecimal gstValue;

  @Column(name = "invoice_value")
  private BigDecimal invoiceValue;

  @Column(name = "anp_invoiceno")
  private String anpInvoiceNo;

  @Column(name = "gst_invoiceno")
  private String gstInvoiceNo;

  @Column(name = "invoicedate")
  private LocalDate invoiceDate;

  @Column(name = "central_tax")
  private Float centralTax;

  @Column(name = "state_tax")
  private Float stateTax;

  @Column(length = 50)
  private String code;

  @Column(length = 250)
  private String name;

  @Column(name = "name_in_local", length = 250)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
