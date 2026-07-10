package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Region {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @Column(name = "region_id")
  private Integer regionId;

  @Column(name = "state_code")
  private String stateCode;

  @Column(name = "state_name")
  private String stateName;

  @Column(name = "name")
  private String name;

  @Column(name = "region")
  private String region;

  @Column(name = "status")
  private Integer status;
}
