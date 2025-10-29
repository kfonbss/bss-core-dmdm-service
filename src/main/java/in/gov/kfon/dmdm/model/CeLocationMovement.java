package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_location_movement")
@Data
public class CeLocationMovement extends Auditor {
  @Id
  @Column(name = "movement_id")
  private UUID movementId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "created_by_platform")
  private String createdByPlatform;
}
