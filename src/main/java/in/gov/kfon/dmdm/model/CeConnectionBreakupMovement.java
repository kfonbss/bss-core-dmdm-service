package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_connection_breakup_movement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeConnectionBreakupMovement extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "movement_id", nullable = false)
  private UUID movementId;

  @Column(name = "code", length = 45)
  private String code;

  @Column(name = "name", length = 255)
  private String name;

  @Column(name = "name_in_local", length = 255)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "breakupid")
  private Integer breakupId;

  @Column(name = "quoationid")
  private Integer quoationId;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "discount")
  private Integer discount;

  @Column(name = "created_by_platform", length = 128)
  private String createdByPlatform;
}
