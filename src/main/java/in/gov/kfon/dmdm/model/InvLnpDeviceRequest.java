package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_lnp_device_request")
@Data
public class InvLnpDeviceRequest extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "inv_lnp_device_request_id", nullable = false)
  private UUID invLnpDeviceRequestId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "dtid")
  private Integer dtid;

  @Column(name = "req_dev_count")
  private Integer reqDevCount;

  @Column(name = "app_dev_count")
  private Integer appDevCount;

  @Column(name = "device_type")
  private Integer deviceType;

  @Column(name = "lnpid")
  private Integer lnpid;

  @Column(name = "mspdc_id")
  private Integer mspdcId;

  @Column(name = "request_from")
  private Integer requestFrom;

  @Column(name = "remarks", length = 250)
  private String remarks;

  @Column(name = "request_status")
  private Integer requestStatus;

  @Column(name = "approve_remarks", length = 250)
  private String approveRemarks;

  @Column(name = "accepted_count")
  private Integer acceptedCount;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
