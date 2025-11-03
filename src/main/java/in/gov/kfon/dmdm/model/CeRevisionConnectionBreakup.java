package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_revision_connection_breakup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeRevisionConnectionBreakup extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "breakup_id")
  private UUID breakupId;

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

  @Column(name = "serviceid")
  private Integer serviceId;

  @Column(name = "revi_quoationid")
  private Integer reviQuoationId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "otc_cost")
  private Double otcCost;

  @Column(name = "noof_connections")
  private Integer noOfConnections;

  @Column(name = "discount")
  private Integer discount;

  @Column(name = "description")
  private String description;

  @Column(name = "version")
  private Integer version;

  @Column(name = "migrated")
  private Integer migrated;
}
