package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lookup_master")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class LookupMaster extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @Column(name = "lookup_type", nullable = false)
  private String lookupType;

  @Column(name = "lookup_code", nullable = false)
  private String lookupCode;

  @Column(name = "lookup_value", nullable = false)
  private String lookupValue;

  @Column(name = "parent_code")
  private String parentCode;

  @Column(name = "display_order")
  private Integer displayOrder;

  @Column(name = "is_active")
  private Boolean isActive;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "application_id")
  private ClientApplication application;

  @Column(name = "tenant_id")
  private String tenantId;
}
