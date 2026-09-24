package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "application_field_config",
    uniqueConstraints = {
      @UniqueConstraint(columnNames = {"application_id", "field_id"})
    })
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ApplicationFieldConfig extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "application_id", nullable = false)
  private ClientApplication application;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "field_id", nullable = false)
  private FormFieldMaster field;

  @Column(name = "is_included")
  private Boolean isIncluded;

  @Column(name = "is_required")
  private Boolean isRequired;

  @Column(name = "display_order")
  private Integer displayOrder;

  @Column(name = "section")
  private String section;

  @Column(name = "custom_label")
  private String customLabel;

  @Column(name = "custom_validations", columnDefinition = "jsonb")
  private String customValidations;
}
