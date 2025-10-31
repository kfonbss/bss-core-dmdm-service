package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_quoations_revision")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeQuotationsRevision extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "revision_id")
  private UUID revisionId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "id")
  private Integer id;

  @Column(name = "proposalid")
  private Integer proposalId;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "discount_apply")
  private Integer discountApply;

  @Column(name = "discount_percent")
  private Integer discountPercent;

  @Column(name = "proposal_doc")
  private String proposalDoc;

  @Column(name = "version")
  private Integer version;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "migrated")
  private Integer migrated;
}
