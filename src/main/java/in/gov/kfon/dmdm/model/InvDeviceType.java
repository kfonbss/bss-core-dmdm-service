package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_device_type")
@Data
public class InvDeviceType extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "inv_device_type_id", nullable = false)
  private UUID invDeviceTypeId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "dt_name")
  private String dtName;

  @Column(name = "dt_desc")
  private String dtDesc;

  @Column(name = "device_type")
  private Integer deviceType;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
