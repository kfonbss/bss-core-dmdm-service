package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_device_details")
@Data
public class InvDeviceDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "details_id")
  private UUID detailsId;

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

  @Column(name = "dtid")
  private Integer dtid;

  @Column(name = "dmid")
  private Integer dmid;

  @Column(name = "dcid")
  private Integer dcid;

  @Column(name = "dmoid")
  private Integer dmoid;

  @Column(name = "dvid")
  private Integer dvid;

  @Column(name = "asset_type")
  private Integer assetType;

  @Column(name = "device_slno")
  private String deviceSlno;

  @Column(name = "old_deviceslno")
  private String oldDeviceSlno;

  @Column(name = "slno_updatedate")
  private LocalDate slnoUpdateDate;

  @Column(name = "device_serial_number")
  private String deviceSerialNumber;

  @Column(name = "device_mack")
  private String deviceMack;

  @Column(name = "sfp_distance")
  private String sfpDistance;

  @Column(name = "invoice_date")
  private String invoiceDate;

  @Column(name = "warranty_sdate")
  private String warrantySDate;

  @Column(name = "warranty_edate")
  private String warrantyEDate;

  @Column(name = "po_no")
  private String poNo;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "device_status")
  private Integer deviceStatus;

  @Column(name = "noc_id")
  private Integer nocId;

  @Column(name = "kfon_dcid")
  private Integer kfonDcid;

  @Column(name = "msp_dcid")
  private Integer mspDcid;

  @Column(name = "lnpid")
  private Long lnpId;

  @Column(name = "subid")
  private Integer subId;

  @Column(name = "user_type")
  private Integer userType;

  @Column(name = "appid")
  private Integer appId;

  @Column(name = "ce_kycid")
  private Integer ceKycId;

  @Column(name = "reqid")
  private Integer reqId;

  @Column(name = "dc_reqid")
  private Integer dcReqId;

  @Column(name = "con_device_type")
  private Integer conDeviceType;

  @Column(name = "ip_address")
  private String ipAddress;

  @Column(name = "port_number")
  private String portNumber;

  @Column(name = "secondry_remarks")
  private String secondryRemarks;

  @Column(name = "device_mapped_to")
  private Integer deviceMappedTo;

  @Column(name = "pop_name")
  private String popName;

  @Column(name = "discovered_inacs")
  private Integer discoveredInAcs;

  @Column(name = "device_status_inacs")
  private Integer deviceStatusInAcs;

  @Column(name = "condition_statusid")
  private Integer conditionStatusId;

  @Column(name = "oem_request_id")
  private Integer oemRequestId;

  @Column(name = "repair_status")
  private Integer repairStatus;

  @Column(name = "created_userid")
  private Integer createdUserId;

  @Column(name = "created_username")
  private String createdUserName;
}
