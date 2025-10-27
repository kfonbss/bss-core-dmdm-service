package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "package")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Package extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "packageid")
  private Long packageId;

  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @Column(name = "renewperiod", nullable = false)
  private Integer renewPeriod;

  @Column(name = "free_service")
  private Integer freeService;

  @Column(name = "initial_free_service")
  private Integer initialFreeService;

  @Column(name = "subscriberprofileid", nullable = false)
  private Integer subscriberProfileId;

  @Column(name = "portspeedid", nullable = false)
  private Integer portSpeedId;

  @Column(name = "serviceid", nullable = false)
  private Integer serviceId;

  @Column(name = "billingtypeid", nullable = false)
  private Integer billingTypeId;

  @Column(name = "onetimecharge", precision = 10, scale = 2)
  private Double oneTimeCharge = 0.0;

  @Column(precision = 10, scale = 2)
  private Double discount = 0.0;

  @Column(name = "renewalfee")
  private Double renewalFee = 0.0;

  @Column(name = "lastupdate")
  private LocalDateTime lastUpdate = LocalDateTime.now();

  @Column(name = "renewaltaxtypeid")
  private Integer renewAltTaxTypeId = 1;

  @Column(name = "trailpackage")
  private Integer trailPackage = 0;

  @Column(name = "active")
  private Integer active = 0;

  @Column(name = "enddate")
  private LocalDateTime endDate;

  @Column(name = "bandid")
  private Integer bandId;

  @Column(name = "maxvolume")
  private Double maxVolume;

  @Column(name = "fallbackspeed", length = 10)
  private String fallbackSpeed;

  @Column(length = 256)
  private String description;

  @Column(name = "speedinkbps")
  private Long speedInKbps;

  @Column(length = 45)
  private String mProfile;

  @Column(length = 45)
  private String jProfile;

  @Column(length = 45)
  private String category = "REGULAR";

  @Column(name = "plan_type", length = 45)
  private String planType = "ALL";

  @Column(name = "parent_package")
  private Integer parentPackage = 0;

  @Column(name = "bod_min")
  private Long bodMin = 0L;

  @Column(name = "bod_max")
  private Long bodMax = 0L;

  @Column(name = "fbspeedinkbps")
  private Long fbSpeedInKbps;

  @Column(length = 45)
  private String qos;

  @Column(name = "revenueshareid")
  private Integer revenueShareId;

  @Column(length = 50)
  private String code;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
