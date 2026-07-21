package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rail_territory_name")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RailTerritoryName {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "rail_id", nullable = false, unique = true)
  private UUID railId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "territory_name")
  private String territoryName;

  @Column(name = "stcode")
  private Integer stcode;

  @Column(name = "status")
  private Integer status;

  @Column(name = "c_code", nullable = false)
  private String cCode;
}
