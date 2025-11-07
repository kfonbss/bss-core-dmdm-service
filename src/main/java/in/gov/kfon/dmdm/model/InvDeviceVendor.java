package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_device_vendor")
@Data
public class InvDeviceVendor extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "inv_device_vendor_id", nullable = false)
  private UUID invDeviceVendorId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "dtid")
  private Integer dtid;

  @Column(name = "dmid")
  private Integer dmid;

  @Column(name = "dcid")
  private Integer dcid;

  @Column(name = "dmoid")
  private Integer dmoid;

  @Column(name = "dve_name", length = 100)
  private String dveName;

  @Column(name = "dve_desc", length = 250)
  private String dveDesc;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
