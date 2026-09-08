package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "state_district")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StateDistrict {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "district_id", nullable = false, unique = true)
  private UUID districtId;

  @Column(name = "id")
  private Long id;

  @Column(name = "statename")
  private String stateName;

  @Column(name = "stcode")
  private String stCode;

  @Column(name = "dtname")
  private String districtName;

  @Column(name = "statecode")
  private String stateCode;

  @Column(name = "districtcode")
  private String districtCode;
}
