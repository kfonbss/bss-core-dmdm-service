package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_quoations_movement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeQuotationsMovement extends Auditor {
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

  @Column(name = "quoationid")
  private Integer quoationId;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "discount_percent")
  private Integer discountPercent;

  @Column(name = "version")
  private Integer version;

  @Column(name = "proposal_doc")
  private String proposalDoc;

  @Column(name = "created_by_name")
  private String createdByName;
}
