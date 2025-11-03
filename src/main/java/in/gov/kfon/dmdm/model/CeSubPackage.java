package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_sub_package")
@Data
public class CeSubPackage extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "package_id")
  private UUID packageId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "sub_packageid")
  private Integer subPackageId;

  @Column(name = "packageid")
  private Integer packageIdRef;

  @Column(name = "sub_renewperiod")
  private Integer subRenewPeriod;

  @Column(name = "sub_renewalfee")
  private Double subRenewalFee;

  @Column(name = "service_cat")
  private Integer serviceCat;

  @Column(name = "description")
  private String description;
}
