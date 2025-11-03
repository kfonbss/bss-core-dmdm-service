package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_purchase_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DfPurchaseOrder extends Auditor {

  @Id
  @Column(name = "df_purchase_order_id", nullable = false, updatable = false)
  private UUID dfPurchaseOrderId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "slno")
  private Long slno;

  @Column(name = "po_no", length = 30)
  private String poNo;

  @Column(name = "po_no_cus", length = 30)
  private String poNoCus;

  @Column(name = "po_doc", length = 100)
  private String poDoc;

  @Column(name = "tfd_ref_num", length = 100)
  private String tfdRefNum;

  @Column(name = "tfd_ref_doc", length = 100)
  private String tfdRefDoc;

  @Column(name = "enq_ref")
  private Integer enqRef;

  @Column(name = "customerid")
  private Integer customerId;

  @Column(name = "approve_status")
  private Integer approveStatus = 0;

  @Column(name = "remarks", length = 255)
  private String remarks;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
