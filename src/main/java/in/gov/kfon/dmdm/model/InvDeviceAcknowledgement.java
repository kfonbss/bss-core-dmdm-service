package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_device_acknowledgement")
@Data
public class InvDeviceAcknowledgement {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ack_id")
  private UUID ackId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "id")
  private Integer id;

  @Column(name = "deviceid")
  private Integer deviceId;

  @Column(name = "lnp_reqid")
  private Integer lnpReqId;

  @Column(name = "device_status")
  private Integer deviceStatus;

  @Column(name = "lnpid")
  private Long lnpId;

  @Column(name = "reqid")
  private Integer reqId;

  @Column(name = "dc_reqid")
  private Integer dcReqId;

  @Column(name = "noc_id")
  private Integer nocId;

  @Column(name = "kfondc_id")
  private Integer kfonDcId;

  @Column(name = "mspdc_id")
  private Integer mspDcId;

  @Column(name = "created_by_id")
  private Long createdById;

  @Column(name = "created_by_name")
  private String createdByName;
}
