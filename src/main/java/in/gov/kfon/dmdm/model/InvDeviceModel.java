package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "inv_device_model")
public class InvDeviceModel extends Auditor {

  @Id
  @GeneratedValue
  @Column(name = "inv_device_model_id", nullable = false)
  private UUID invDeviceModelId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "dtid")
  private Integer dtid;

  @Column(name = "dmid")
  private Integer dmid;

  @Column(name = "dcid")
  private Integer dcid;

  @Column(name = "dmo_name", length = 100)
  private String dmoName;

  @Column(name = "dmo_desc", length = 250)
  private String dmoDesc;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
