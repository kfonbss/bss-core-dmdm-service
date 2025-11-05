package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "inv_device_make")
public class InvDeviceMake extends Auditor {

  @Id
  @Column(name = "inv_device_make_id", nullable = false)
  private UUID invDeviceMakeId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "dtid")
  private Integer dtid;

  @Column(name = "dm_name", length = 100)
  private String dmName;

  @Column(name = "dm_desc", length = 250)
  private String dmDesc;

  @Column(name = "maker_id")
  private Integer makerId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
