package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_onlineapplication")
@Data
public class CeOnlineApplication extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "application_id")
  private UUID applicationId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "apno")
  private String apNo;

  @Column(name = "status")
  private String status;

  @Column(name = "partnerid")
  private String partnerId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "agpid")
  private String agpId;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "middlename")
  private String middleName;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "mobileno")
  private String mobileNo;

  @Column(name = "email")
  private String email;

  @Column(name = "dateofbirth")
  private LocalDate dateOfBirth;

  @Column(name = "address")
  private String address;

  @Column(name = "idproof")
  private String idProof;

  @Column(name = "addressproof")
  private String addressProof;

  @Column(name = "appform")
  private String appForm;

  @Column(name = "submit_remarks")
  private String submitRemarks;

  @Column(name = "verify_remarks")
  private String verifyRemarks;

  @Column(name = "reject_remarks")
  private String rejectRemarks;

  @Column(name = "disconnect_remarks")
  private String disconnectRemarks;

  @Column(name = "resubmit_remarks")
  private String resubmitRemarks;

  @Column(name = "street")
  private String street;

  @Column(name = "addressproof_no")
  private String addressProofNo;

  @Column(name = "idproof_no")
  private String idProofNo;

  @Column(name = "id_type")
  private String idType;

  @Column(name = "address_type")
  private String addressType;

  @Column(name = "proofstatus")
  private Integer proofStatus;

  @Column(name = "resubmit_date")
  private LocalDateTime resubmitDate;

  @Column(name = "aadharno")
  private Long aadharNo;

  @Column(name = "uname")
  private String uname;

  @Column(name = "doorno")
  private String doorNo;

  @Column(name = "stcode")
  private String stCode;

  @Column(name = "city")
  private String city;

  @Column(name = "district")
  private String district;

  @Column(name = "pincode")
  private String pincode;

  @Column(name = "villagename")
  private String villageName;

  @Column(name = "block")
  private String block;

  @Column(name = "caf_type")
  private String cafType;

  @Column(name = "employer_name")
  private String employerName;

  @Column(name = "cafid")
  private Long cafId;

  @Column(name = "gender")
  private String gender;

  @Column(name = "subdistrict")
  private String subDistrict;

  @Column(name = "photo")
  private String photo;

  @Column(name = "post_office_name")
  private String postOfficeName;

  @Column(name = "panchayat_type")
  private Integer panchayatType;

  @Column(name = "loc_type")
  private Integer locType;

  @Column(name = "doorno_insta")
  private String doorNoInsta;

  @Column(name = "streetlo_insta")
  private String streetLoInsta;

  @Column(name = "cityname_insta")
  private String cityNameInsta;

  @Column(name = "pincode_insta")
  private String pincodeInsta;

  @Column(name = "post_office_name_insta")
  private String postOfficeNameInsta;

  @Column(name = "district_insta")
  private String districtInsta;

  @Column(name = "loc_type_insta")
  private Integer locTypeInsta;

  @Column(name = "panchayat_type_insta")
  private Integer panchayatTypeInsta;

  @Column(name = "village_name_insta")
  private String villageNameInsta;

  @Column(name = "block_insta")
  private String blockInsta;

  @Column(name = "deviceid")
  private Integer deviceId;

  @Column(name = "device_provid")
  private Integer deviceProvid;

  @Column(name = "device_typeid")
  private Integer deviceTypeId;

  @Column(name = "device_make")
  private String deviceMake;

  @Column(name = "device_model")
  private String deviceModel;

  @Column(name = "device_address")
  private String deviceAddress;

  @Column(name = "olt_type")
  private Integer oltType;

  @Column(name = "paddress_as_aadhar")
  private Integer pAddressAsAadhar;

  @Column(name = "iaddress_as_paddress")
  private Integer iAddressAsPAddress;

  @Column(name = "kyc_type")
  private Boolean kycType;

  @Column(name = "lnp_vlanid")
  private String lnpVlanId;

  @Column(name = "ssid_2_4ghz")
  private String ssid24GHz;

  @Column(name = "preshared_2_4ghz")
  private String preShared24GHz;

  @Column(name = "ssid_5_0ghz")
  private String ssid5GHz;

  @Column(name = "preshared_5_0ghz")
  private String preShared5GHz;

  @Column(name = "corp_loc_id")
  private Integer corpLocId;

  @Column(name = "ration_card_type")
  private Boolean rationCardType;
}
