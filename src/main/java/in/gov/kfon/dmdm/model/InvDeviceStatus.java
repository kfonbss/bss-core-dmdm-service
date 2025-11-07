package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "inv_device_status")
public class InvDeviceStatus extends Auditor {

  @Id
  @Column(name = "inv_device_status_id")
  private UUID invDeviceStatusId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "status_id")
  private Integer statusId;

  @Column(name = "device_status_name")
  private String deviceStatusName;

  @Column(name = "global_user")
  private Integer globalUser;

  @Column(name = "kfondc_user")
  private Integer kfondcUser;

  @Column(name = "mspdc_user")
  private Integer mspdcUser;

  @Column(name = "partner_user")
  private Integer partnerUser;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
