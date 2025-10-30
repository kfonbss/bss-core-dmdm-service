package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_package")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CePackage extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "packagename")
  private String packageName;

  @Column(name = "renewperiod")
  private Integer renewPeriod;

  @Column(name = "serviceid")
  private Integer serviceId;

  @Column(name = "sub_serviceid")
  private Integer subServiceId;

  @Column(name = "renewalfee")
  private Double renewalFee;

  @Column(name = "service_type")
  private Integer serviceType;

  @Column(name = "speed_inmbps")
  private Integer speedInMbps;

  @Column(name = "m_profile")
  private String mProfile;

  @Column(name = "plan_type")
  private Integer planType;

  @Column(name = "maxvolume")
  private Double maxVolume;

  @Column(name = "fallbackspeed")
  private String fallbackSpeed;

  @Column(name = "otcfee")
  private Double otcFee;

  @Column(name = "fbspeedinkbps")
  private Long fbSpeedInKbps;
}
