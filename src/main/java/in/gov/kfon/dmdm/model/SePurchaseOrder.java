package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_purchase_order")
@Data
public class SePurchaseOrder extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "slno")
  private Integer slno;

  @Column(name = "customerid")
  private Integer customerId;

  @Column(name = "propid")
  private Integer propId;

  @Column(name = "po_doc")
  private String poDoc;

  @Column(name = "po_no")
  private String poNo;

  @Column(name = "paymnet_mode")
  private Integer paymnetMode;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "remarks")
  private String remarks;
}
