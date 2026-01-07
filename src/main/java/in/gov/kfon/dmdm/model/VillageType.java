package in.gov.kfon.dmdm.model;

import in.gov.kfon.dmdm.constant.LocationType;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "village_types")
@AllArgsConstructor
@NoArgsConstructor
public class VillageType extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "uuid", nullable = false)
  private UUID uuid;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "village_type_id")
  private Integer villageTypeId;

  @Column(name = "village_type", length = 50)
  private String villageType;

  @Column(name = "loc_type")
  @Enumerated(EnumType.ORDINAL)
  private LocationType locType;

  @Column(name = "is_active")
  private boolean isActive;
}
