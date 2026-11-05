package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "district")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class District extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "district_id")
  private UUID districtId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "code")
  private String code;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "state_code", referencedColumnName = "code", nullable = false)
  private State state;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "shortname")
  private String shortName;

  /** District code used in the legacy billing_master location tables (Census DTCode). */
  @Column(name = "census_code")
  private String censusCode;

  /** Local Government Directory (LGD) district code. */
  @Column(name = "lgd_code")
  private String lgdCode;
}
