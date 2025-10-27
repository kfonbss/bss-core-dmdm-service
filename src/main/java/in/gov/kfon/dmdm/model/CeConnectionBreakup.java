package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_connection_breakup")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeConnectionBreakup extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "breakup_id", nullable = false)
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "serviceid")
  private Integer serviceId;

  @Column(name = "quoationid")
  private Integer quoationId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "otc_cost")
  private Integer otcCost;

  @Column(name = "noof_connections")
  private Integer noOfConnections;

  @Column(name = "discount")
  private BigDecimal discount;

  @Column(name = "description")
  private String description;

  @Column(name = "alternate_name")
  private String alternateName;
}
