package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "form_section")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FormSection extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "form_definition_id", nullable = false)
  private OnboardingFormDefinition formDefinition;

  @Column(name = "section_key", nullable = false)
  private String sectionKey;

  @Column(name = "section_label", nullable = false)
  private String sectionLabel;

  @Column(name = "display_order")
  private Integer displayOrder;

  @Column(name = "is_visible")
  private Boolean isVisible;

  @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @OrderBy("displayOrder ASC")
  private List<FormDefinitionField> fields;
}
