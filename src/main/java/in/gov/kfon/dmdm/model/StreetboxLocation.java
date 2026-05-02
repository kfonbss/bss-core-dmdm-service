package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "streetbox_location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StreetboxLocation {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "snum", insertable = false, updatable = false)
  private Integer snum;

  @Column(name = "equipment_name")
  private String equipmentName;

  @Column(name = "pop_name")
  private String popName;

  @Column(name = "district")
  private String district;

  @Column(name = "pop_type")
  private String popType;

  @Column(name = "latitude")
  private Double latitude;

  @Column(name = "longitude")
  private Double longitude;

  @Column(name = "type")
  private String type;

  @Column(name = "category")
  private String category;
}
