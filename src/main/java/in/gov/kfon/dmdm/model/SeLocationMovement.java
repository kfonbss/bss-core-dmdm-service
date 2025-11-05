package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_location_movement")
@Data
public class SeLocationMovement extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "movement_id")
  private UUID movementId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "id")
  private Integer id;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "remarks")
  private String remarks;
}
