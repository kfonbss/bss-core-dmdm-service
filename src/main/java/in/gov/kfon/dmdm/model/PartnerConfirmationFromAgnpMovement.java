package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partner_confirmation_from_agnp_movement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerConfirmationFromAgnpMovement extends Auditor {

  @Id
  @Column(name = "movement_id", nullable = false)
  private UUID movementId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "pcf_id")
  private Long pcfId;

  @Column(name = "note", columnDefinition = "TEXT")
  private String note;

  @Column(name = "status", length = 45)
  private String status;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
