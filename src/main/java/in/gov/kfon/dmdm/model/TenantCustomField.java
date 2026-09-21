package in.gov.kfon.dmdm.model;

import in.gov.kfon.dmdm.constant.FieldType;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tenant_custom_field")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class TenantCustomField extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @Column(name = "tenant_id", nullable = false)
  private String tenantId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "application_id", nullable = false)
  private ClientApplication application;

  @Column(name = "field_key", nullable = false)
  private String fieldKey;

  @Column(name = "field_label", nullable = false)
  private String fieldLabel;

  @Enumerated(EnumType.STRING)
  @Column(name = "field_type", nullable = false)
  private FieldType fieldType;

  @Column(name = "section")
  private String section;

  @Column(name = "is_required")
  private Boolean isRequired;

  @Column(name = "display_order")
  private Integer displayOrder;

  @Column(name = "validations", columnDefinition = "jsonb")
  private String validations;

  @Column(name = "metadata", columnDefinition = "jsonb")
  private String metadata;

  @Column(name = "is_active")
  private Boolean isActive;
}
