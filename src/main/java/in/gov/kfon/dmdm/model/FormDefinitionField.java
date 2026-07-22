package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "form_definition_field")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FormDefinitionField extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "form_definition_id", nullable = false)
  private OnboardingFormDefinition formDefinition;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "section_id")
  private FormSection section;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "field_id")
  private FormFieldMaster field;

  // Used only when field is null (tenant custom field not in master catalog)
  @Column(name = "field_key")
  private String fieldKey;

  @Column(name = "custom_label")
  private String customLabel;

  @Column(name = "placeholder")
  private String placeholder;

  @Column(name = "default_value")
  private String defaultValue;

  @Column(name = "is_required")
  private Boolean isRequired;

  @Column(name = "is_visible")
  private Boolean isVisible;

  @Column(name = "is_readonly")
  private Boolean isReadonly;

  @Column(name = "display_order")
  private Integer displayOrder;

  @Column(name = "custom_validations", columnDefinition = "jsonb")
  private String customValidations;

  @Column(name = "lookup_type")
  private String lookupType;
}
