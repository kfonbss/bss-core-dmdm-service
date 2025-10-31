package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_purchase_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CePurchaseOrder extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "order_id")
  private UUID orderId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "slno")
  private Integer slno;

  @Column(name = "customerid")
  private Integer customerId;

  @Column(name = "quotationid")
  private Integer quotationId;

  @Column(name = "po_no_cus")
  private String poNoCus;

  @Column(name = "po_doc")
  private String poDoc;

  @Column(name = "po_no")
  private String poNo;

  @Column(name = "mou_number")
  private String mouNumber;

  @Column(name = "mou_doc")
  private String mouDoc;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "po_start_date")
  private LocalDate poStartDate;

  @Column(name = "po_end_date")
  private LocalDate poEndDate;

  @Column(name = "noof_months")
  private Integer noOfMonths;

  @Column(name = "annual_charges")
  private BigDecimal annualCharges;

  @Column(name = "otc_charges")
  private BigDecimal otcCharges;

  @Column(name = "total_amount")
  private BigDecimal totalAmount;

  @Column(name = "billing_frequency")
  private String billingFrequency;

  @Column(name = "is_eo_customer")
  private Integer isEoCustomer;
}
