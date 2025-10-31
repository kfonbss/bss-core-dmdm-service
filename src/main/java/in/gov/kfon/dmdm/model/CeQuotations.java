package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_quoations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeQuotations extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "quoations_id")
  private UUID quoationsId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "customerid")
  private Integer customerId;

  @Column(name = "quotation_name")
  private String quotationName;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "discount_apply")
  private Integer discountApply;

  @Column(name = "discount_percent")
  private Integer discountPercent;

  @Column(name = "proposal_doc")
  private String proposalDoc;

  @Column(name = "terms_and_cond")
  private String termsAndCond;

  @Column(name = "b_frequency")
  private String billingFrequency;

  @Column(name = "special_terms_cond")
  private String specialTermsCond;

  @Column(name = "version")
  private Integer version;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "is_eo_proposal")
  private Boolean isEoProposal;

  @Column(name = "migrated")
  private Integer migrated;
}
