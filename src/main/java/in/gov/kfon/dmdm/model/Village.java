package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "village")
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Village extends Auditor {
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "village_id")
  private UUID villageId;

  @Column(name = "id", insertable = false, updatable = false)
  private Long id;

  /** 6-digit Census / LGD village code, e.g. "628229". Unique across India. */
  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sub_district_id", nullable = false)
  private SubDistrict subDistrict;

  @Column(name = "is_active")
  private Boolean isActive;
}
