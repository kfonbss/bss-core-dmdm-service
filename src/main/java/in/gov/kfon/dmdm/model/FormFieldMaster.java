package in.gov.kfon.dmdm.model;

import in.gov.kfon.dmdm.constant.FieldCategory;
import in.gov.kfon.dmdm.constant.FieldType;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "form_field_master")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FormFieldMaster extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @Column(name = "field_key", unique = true, nullable = false)
  private String fieldKey;

  @Column(name = "field_label", nullable = false)
  private String fieldLabel;

  @Enumerated(EnumType.STRING)
  @Column(name = "field_type", nullable = false)
  private FieldType fieldType;

  @Enumerated(EnumType.STRING)
  @Column(name = "field_category")
  private FieldCategory fieldCategory;

  @Column(name = "default_validations", columnDefinition = "jsonb")
  private String defaultValidations;

  @Column(name = "metadata", columnDefinition = "jsonb")
  private String metadata;

  @Column(name = "is_system")
  private Boolean isSystem;

  @Column(name = "is_active")
  private Boolean isActive;
}