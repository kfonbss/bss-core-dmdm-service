package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plan_type")
public class PlanType extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "plan_type_id", nullable = false, unique = true)
  private Integer planTypeId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 45)
  private String name;

  @Column(name = "name_in_local", length = 150)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;
}
