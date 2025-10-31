package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_po_movement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CePoMovement {
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

  @Column(name = "id")
  private Integer id;

  @Column(name = "poid")
  private Integer poid;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "created_by_platform")
  private String createdByPlatform;
}
