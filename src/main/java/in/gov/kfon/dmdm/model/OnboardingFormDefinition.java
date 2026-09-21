package in.gov.kfon.dmdm.model;

import in.gov.kfon.dmdm.constant.FormStatus;
import in.gov.kfon.dmdm.constant.FormType;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "onboarding_form_definition")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class OnboardingFormDefinition extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "application_id", nullable = false)
  private ClientApplication application;

  @Column(name = "tenant_id")
  private String tenantId;

  @Enumerated(EnumType.STRING)
  @Column(name = "form_type", nullable = false)
  private FormType formType;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "version", nullable = false)
  private Integer version;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private FormStatus status;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "formDefinition", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @OrderBy("displayOrder ASC")
  private List<FormSection> sections;
}
