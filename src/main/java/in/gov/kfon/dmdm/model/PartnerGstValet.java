package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partner_gstvalet")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerGstValet extends Auditor {

  @Id
  @Column(name = "id")
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "slno")
  private Long slno;

  @Column(name = "partnerid")
  private Long partnerid;

  @Column(name = "partnername")
  private String partnername;

  @Column(name = "description")
  private String description;

  @Column(name = "BSS_invoiceno")
  private String BSSInvoiceNo;

  @Column(name = "gst_amt")
  private BigDecimal gstAmt;

  @Column(name = "approved_amt")
  private BigDecimal approvedAmt;

  @Column(name = "balance_amt")
  private BigDecimal balanceAmt;

  @Column(name = "submit_status")
  private String submitStatus;

  @Column(name = "approve_status")
  private String approveStatus;

  @Column(name = "submit_date")
  private LocalDateTime submitDate;

  @Column(name = "approve_date")
  private LocalDateTime approveDate;

  @Column(name = "ptype")
  private String ptype;

  @Column(name = "billtype")
  private String billtype;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "gst_invoiceno")
  private String gstInvoiceNo;

  @Column(name = "irn_no")
  private String irnNo;

  @Column(name = "gst_invoicedate")
  private LocalDate gstInvoiceDate;

  @Column(name = "gstin_proof")
  private String gstinProof;

  @Column(length = 50)
  private String code;

  @Column(length = 250)
  private String name;

  @Column(name = "name_in_local", length = 250)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
