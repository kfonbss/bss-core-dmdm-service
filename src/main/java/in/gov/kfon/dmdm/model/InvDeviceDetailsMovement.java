package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.*;
import lombok.*;

@Entity
@Table(name = "inv_device_details_movement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvDeviceDetailsMovement extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "movement_id")
  private UUID movementId;

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

  @Column(name = "reqid")
  private Integer reqId;

  @Column(name = "dc_reqid")
  private Integer dcReqId;

  @Column(name = "lnp_reqid")
  private Integer lnpReqId;

  @Column(name = "cnid")
  private Integer cnId;

  @Column(name = "device_status")
  private Integer deviceStatus;

  @Column(name = "noc_id")
  private Integer nocId;

  @Column(name = "kfon_dcid")
  private Integer kfonDcid;

  @Column(name = "msp_dcid")
  private Integer mspDcid;

  @Column(name = "subid")
  private Integer subId;

  @Column(name = "user_type")
  private Integer userType;

  @Column(name = "appid")
  private Long appId;

  @Column(name = "ce_kycid")
  private Integer ceKycId;

  @Column(name = "lnpid")
  private Long lnpId;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "device_mapped_to")
  private Integer deviceMappedTo;

  @Column(name = "pop_name")
  private String popName;

  @Column(name = "condition_statusid")
  private Integer conditionStatusId;

  @Column(name = "return_faulty_id")
  private Integer returnFaultyId;

  @Column(name = "oem_request_id")
  private Integer oemRequestId;

  @Column(name = "repair_status")
  private Integer repairStatus;

  @Column(name = "return_remarks")
  private String returnRemarks;

  @Column(name = "con_device_type")
  private Integer conDeviceType;

  @Column(name = "ip_address")
  private String ipAddress;

  @Column(name = "port_number")
  private String portNumber;

  @Column(name = "secondry_remarks")
  private String secondryRemarks;

  @Column(name = "created_by_id")
  private Long createdById;

  @Column(name = "created_by_name")
  private String createdByName;
}
