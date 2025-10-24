package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companydetail")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyDetail {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "companyid", nullable = false)
  private Long companyid;

  @Column(name = "partnercompanyname", length = 150)
  private String partnercompanyname;

  @Column(name = "status")
  private Boolean status;

  @Column(name = "companyregistrationno", length = 64)
  private String companyregistrationno;

  @Column(name = "servicetaxno", length = 64)
  private String servicetaxno;

  @Column(name = "incometaxno", length = 45)
  private String incometaxno;

  @Column(name = "vatno", length = 45)
  private String vatno;

  @Column(name = "state", length = 64)
  private String state;

  @Column(name = "pin")
  private Integer pin;

  @Column(name = "registrationdate")
  private LocalDate registrationdate;

  @Column(name = "agreementno", length = 100)
  private String agreementno;

  @Column(name = "agreementdate")
  private LocalDate agreementdate;

  @Column(name = "keycontactname", length = 45)
  private String keycontactname;

  @Column(name = "keycontactnumber")
  private Long keycontactnumber;

  @Column(name = "keycontactemail", length = 128)
  private String keycontactemail;

  @Column(name = "lastupdate")
  private LocalDateTime lastupdate;

  @Column(name = "supportcontactname", length = 128)
  private String supportcontactname;

  @Column(name = "supportcontactno", length = 15)
  private String supportcontactno;

  @Column(name = "supportcontactemail", length = 128)
  private String supportcontactemail;

  @Column(name = "managercontactname", length = 45)
  private String managercontactname;

  @Column(name = "managercontactno")
  private Long managercontactno;

  @Column(name = "managercontactemail", length = 128)
  private String managercontactemail;

  @Column(name = "allocated_bw", length = 45)
  private String allocatedBw;

  @Column(name = "consumed_bw", length = 45)
  private String consumedBw;

  @Column(name = "pgiopt")
  private Integer pgiopt;

  @Column(name = "statecode", length = 5)
  private String statecode;

  @Column(name = "acholdername", length = 100)
  private String acholdername;

  @Column(name = "actype", length = 5)
  private String actype;

  @Column(name = "bankname", length = 100)
  private String bankname;

  @Column(name = "branchname", length = 100)
  private String branchname;

  @Column(name = "acnumber", length = 50)
  private String acnumber;

  @Column(name = "IFSC", length = 30)
  private String ifsc;

  @Column(name = "ptype", length = 25)
  private String ptype;

  @Column(name = "address", length = 300)
  private String address;

  @Column(name = "approval_date")
  private LocalDateTime approvalDate;

  @Column(name = "approval_cl", length = 300)
  private String approvalCl;

  @Column(name = "approval_response", length = 300)
  private String approvalResponse;

  @Column(name = "agreementcopy", length = 256)
  private String agreementCopy;

  @Column(name = "bankpasscopy", length = 256)
  private String bankPassCopy;

  @Column(name = "incometaxproof", length = 256)
  private String incomeTaxProof;

  @Column(name = "servicetaxproof", length = 256)
  private String serviceTaxProof;

  @Column(name = "bank_acholder", length = 128)
  private String bankAHolder;

  @Column(name = "bank_actype", length = 45)
  private String bankAType;

  @Column(name = "bank_name", length = 128)
  private String bankName;

  @Column(name = "bank_branch", length = 128)
  private String bankBranch;

  @Column(name = "bank_acno", length = 64)
  private String bankAcNo;

  @Column(name = "bank_ifsc", length = 64)
  private String bankIfsc;

  @Column(name = "companynature", length = 64)
  private String companyNature;

  @Column(name = "STCode", length = 3)
  private String stCode;

  @Column(name = "address_line1", length = 120)
  private String addressLine1;

  @Column(name = "address_line2", length = 120)
  private String addressLine2;

  @Column(name = "city", length = 64)
  private String city;

  @Column(name = "pincode", length = 7)
  private String pinCode;

  @Column(name = "statename", length = 64)
  private String stateName;

  @Column(name = "District", length = 64)
  private String district;

  @Column(name = "gstin", length = 45)
  private String gstin;

  @Column(name = "service_description", length = 180)
  private String serviceDescription;

  @Column(name = "SAC", length = 45)
  private String sac;

  @Column(name = "gstindoc", length = 120)
  private String gstinDoc;

  @Column(name = "gst_verfied")
  private Boolean gstVerified;

  @Column(name = "taxpayertype")
  private Boolean taxpayerType;

  @Column(name = "gstdeclartionstatus")
  private Boolean gstDeclarationStatus;

  @Column(name = "subonrecharge")
  private Boolean subOnRecharge;

  @Column(name = "onlinepaymode", length = 100)
  private String onlinePayMode;

  @Column(name = "mspverified")
  private Short mspVerified;

  @Column(name = "otp", length = 20)
  private String otp;

  @Column(name = "otp_time")
  private LocalDateTime otpTime;

  @Column(name = "remarks", length = 100)
  private String remarks;

  @Column(name = "paymodedate")
  private LocalDateTime payModeDate;

  @Column(name = "mspverfieddate")
  private LocalDateTime mspVerifiedDate;

  @Column(name = "bankverfieddate")
  private LocalDateTime bankVerifiedDate;

  @Column(name = "lastrenewed_agreementdate")
  private LocalDate lastRenewedAgreementDate;

  @Column(name = "updated_by", length = 20)
  private String updatedBy;

  @Column(name = "lastrenewed_agreementcopy", length = 256)
  private String lastRenewedAgreementCopy;

  @Column(name = "loc_type")
  private Integer locType;

  @Column(name = "gst_status")
  private Short gstStatus;

  @Column(name = "catagory", length = 30)
  private String category;

  @Column(name = "vas_enabled", length = 45)
  private String vasEnabled;

  @Column(name = "cbldoc", length = 256)
  private String cblDoc;

  @Column(name = "railtelflag")
  private Boolean railTelFlag;

  @Column(name = "territory_name", length = 45)
  private String territoryName;

  @Column(name = "ptnrattid", length = 100)
  private String partnerAttId;

  @Column(name = "ptnrlang", length = 100)
  private String partnerLang;
}
