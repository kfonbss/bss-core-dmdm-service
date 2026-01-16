package in.gov.kfon.dmdm.model;

import in.gov.kfon.dmdm.constant.LocationType;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "block_details")
@AllArgsConstructor
@NoArgsConstructor
public class BlockDetail extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "details_id", nullable = false, updatable = false)
  private UUID uuid;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "village_name", length = 256)
  private String villageName;

  @Column(name = "block_id")
  private Integer blockId;

  @Column(name = "block_name", length = 256)
  private String blockName;

  @Column(name = "village_type", length = 50)
  private String villageType;

  @Column(name = "village_type_id")
  private Integer villageTypeId;

  @Column(name = "district", length = 100)
  private String district;

  @Column(name = "district_id")
  private Integer districtId;

  @Column(name = "loc_type")
  @Enumerated(EnumType.ORDINAL)
  private LocationType locType;

  @Column(name = "is_active")
  private boolean isActive = true;

  @ManyToOne
  @JoinColumn(name = "district_entity", referencedColumnName = "district_id")
  private District districtEntity;
}
