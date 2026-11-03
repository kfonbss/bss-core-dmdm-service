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
@Table(name = "sub_district")
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubDistrict extends Auditor {
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "sub_district_id")
  private UUID subDistrictId;

  @Column(name = "id", insertable = false, updatable = false)
  private Long id;

  /** 5-digit Census sub-district code, e.g. "05674". Unique across India. */
  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "district_id", nullable = false)
  private District district;

  @Column(name = "is_active")
  private Boolean isActive;
}
