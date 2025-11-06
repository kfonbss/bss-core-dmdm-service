package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_workorders")
@Data
public class SeWorkOrders extends Auditor {

  @Id
  @GeneratedValue
  @Column(name = "orders_id")
  private UUID ordersId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "poid")
  private Integer poId;

  @Column(name = "proposalid")
  private Integer proposalId;

  @Column(name = "wo_no")
  private String woNo;

  @Column(name = "approve_status")
  private Integer approveStatus;
}
