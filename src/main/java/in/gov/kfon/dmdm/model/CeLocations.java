package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_locations")
@Data
public class CeLocations extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "locations_id")
  private UUID locationsId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "quotationid")
  private Integer quotationId;

  @Column(name = "breakupid")
  private Integer breakupId;

  @Column(name = "poid")
  private Integer poId;

  @Column(name = "serviceid")
  private Integer serviceId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "loc_code")
  private String locCode;

  @Column(name = "loc_name")
  private String locName;

  @Column(name = "loc_pincode")
  private String locPincode;

  @Column(name = "loc_district")
  private String locDistrict;

  @Column(name = "post_office_name")
  private String postOfficeName;

  @Column(name = "loc_addr")
  private String locAddr;

  @Column(name = "lmc_doc")
  private String lmcDoc;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "expirydate")
  private LocalDate expiryDate;

  @Column(name = "balance")
  private BigDecimal balance;

  @Column(name = "service_provider")
  private Integer serviceProvider;

  @Column(name = "loc_type")
  private Short locType;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "partnergroupid")
  private Integer partnerGroupId;

  @Column(name = "popname")
  private String popName;

  @Column(name = "port_details")
  private String portDetails;

  @Column(name = "multicast_type")
  private String multicastType;

  @Column(name = "multicast_source")
  private String multicastSource;

  @Column(name = "rp_address")
  private String rpAddress;

  @Column(name = "multicast_group_address")
  private String multicastGroupAddress;

  @Column(name = "commission_date")
  private LocalDate commissionDate;

  @Column(name = "commission_doc")
  private String commissionDoc;

  @Column(name = "circuit_details")
  private String circuitDetails;

  @Column(name = "d_status")
  private Integer dStatus;

  @Column(name = "d_status_date")
  private LocalDate dStatusDate;

  @Column(name = "cur_speed")
  private String curSpeed;

  @Column(name = "rccount")
  private Integer rcCount;

  @Column(name = "last_recharge_date")
  private LocalDateTime lastRechargeDate;

  @Column(name = "ce_kyc_id")
  private Integer ceKycId;

  @Column(name = "purposeofill")
  private String purposeOfIll;

  @Column(name = "ipaddress")
  private String ipAddress;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "latitude")
  private String latitude;

  @Column(name = "longitude")
  private String longitude;

  @Column(name = "nearest_box_name")
  private String nearestBoxName;

  @Column(name = "nearest_box_distance")
  private String nearestBoxDistance;

  @Column(name = "nearest_box_pop")
  private String nearestBoxPop;

  @Column(name = "nearest_sub_id")
  private Integer nearestSubId;

  @Column(name = "nearest_sub_partnerid")
  private String nearestSubPartnerId;

  @Column(name = "nearest_sub_partnername")
  private String nearestSubPartnerName;

  @Column(name = "nearest_sub_partnermobile")
  private String nearestSubPartnerMobile;

  @Column(name = "nearest_sub_distance")
  private BigDecimal nearestSubDistance;

  @Column(name = "nearest_partner_id")
  private String nearestPartnerId;

  @Column(name = "nearest_partner_name")
  private String nearestPartnerName;

  @Column(name = "nearest_partner_mobile")
  private String nearestPartnerMobile;

  @Column(name = "nearest_partner_distance")
  private BigDecimal nearestPartnerDistance;

  @Column(name = "nearest_fe_id")
  private Integer nearestFeId;

  @Column(name = "nearest_box_latitude")
  private String nearestBoxLatitude;

  @Column(name = "nearest_box_longitude")
  private String nearestBoxLongitude;

  @Column(name = "newly_identified_eo")
  private Short newlyIdentifiedEo;

  @Column(name = "old_boqid")
  private String oldBoqId;

  @Column(name = "contactno")
  private String contactNo;

  @Column(name = "email")
  private String email;

  @Column(name = "aadharno")
  private String aadharNo;

  @Column(name = "ration_card_number")
  private String rationCardNumber;

  @Column(name = "billing_type")
  private Boolean billingType;

  @Column(name = "enable_individual_wo")
  private Boolean enableIndividualWo;

  @Column(name = "ir_reject_remarks")
  private String irRejectRemarks;

  @Column(name = "ir_rejected_date")
  private LocalDateTime irRejectedDate;

  @Column(name = "ir_resubmit_remarks")
  private String irResubmitRemarks;

  @Column(name = "ir_resubmit_date")
  private LocalDateTime irResubmitDate;

  @Column(name = "subcustomerid")
  private String subCustomerId;
}
