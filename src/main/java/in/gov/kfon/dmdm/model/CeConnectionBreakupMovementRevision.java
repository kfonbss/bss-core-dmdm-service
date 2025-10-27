package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_connection_breakup_movement_revision")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeConnectionBreakupMovementRevision extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "revision_id", nullable = false)
  private UUID revisionId;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
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

  @Column(name = "created_by_platform")
  private String createdByPlatform;

  @Column(name = "migrated")
  private Integer migrated;
}
