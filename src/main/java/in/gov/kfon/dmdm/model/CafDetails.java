package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "caf_details")
@Data
public class CafDetails extends Auditor{
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

    @Column(name = "caf_no")
    private String cafNo;

    @Column(name = "loc")
    private String loc;

    @Column(name = "caf_type")
    private String cafType;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "nameof_firm")
    private String nameOfFirm;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "father_husband_name")
    private String fatherHusbandName;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name = "panno")
    private String panNo;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "existing_customer")
    private String existingCustomer;

    @Column(name = "proof_of_identity")
    private String proofOfIdentity;

    @Column(name = "proof_of_identity_anyother")
    private String proofOfIdentityAnyOther;

    @Column(name = "proof_of_address")
    private String proofOfAddress;

    @Column(name = "proof_of_address_anyother")
    private String proofOfAddressAnyOther;

    @Column(name = "customer_photo")
    private String customerPhoto;

    @Column(name = "status")
    private String status;

    @Column(name = "instalation_address")
    private String installationAddress;

    @Column(name = "instalation_city")
    private String installationCity;

    @Column(name = "instalation_pincode")
    private String installationPincode;

    @Column(name = "instalation_landmark")
    private String installationLandmark;

    @Column(name = "instalation_mobile")
    private String installationMobile;

    @Column(name = "instalation_telephone")
    private String installationTelephone;

    @Column(name = "instalation_faxno")
    private String installationFaxNo;

    @Column(name = "instalation_emailid")
    private String installationEmailId;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "billing_city")
    private String billingCity;

    @Column(name = "billing_pincode")
    private String billingPincode;

    @Column(name = "billing_landmark")
    private String billingLandmark;

    @Column(name = "billing_mobile")
    private String billingMobile;

    @Column(name = "billing_telephone")
    private String billingTelephone;

    @Column(name = "billing_faxno")
    private String billingFaxNo;

    @Column(name = "billing_emailid")
    private String billingEmailId;

    @Column(name = "packageid")
    private Integer packageId;

    @Column(name = "connection_type")
    private String connectionType;

    @Column(name = "package_type")
    private String packageType;

    @Column(name = "port_sped")
    private String portSped;

    @Column(name = "port_sped_usage")
    private String portSpedUsage;

    @Column(name = "service1")
    private String service1;

    @Column(name = "service2")
    private String service2;

    @Column(name = "service3")
    private String service3;

    @Column(name = "service4")
    private String service4;

    @Column(name = "noof_static_ips")
    private String noOfStaticIps;

    @Column(name = "amount_paid_inr")
    private Double amountPaidInr;

    @Column(name = "amount_paid_wrds")
    private String amountPaidWrds;

    @Column(name = "mode_of_payments")
    private String modeOfPayments;

    @Column(name = "cash_reciept_no")
    private String cashReceiptNo;

    @Column(name = "dd_check_no")
    private String ddCheckNo;

    @Column(name = "dateofpaid")
    private LocalDate dateOfPaid;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "authorized_sign")
    private String authorizedSign;

    @Column(name = "dateofsign")
    private LocalDate dateOfSign;

    @Column(name = "partnerid")
    private String partnerId;

    @Column(name = "idproof")
    private String idProof;

    @Column(name = "addressproof")
    private String addressProof;

    @Column(name = "photoattaced")
    private String photoAttached;

    @Column(name = "fsecode")
    private String fseCode;

    @Column(name = "fsesignanddate")
    private String fseSignAndDate;

    @Column(name = "asmcode")
    private String asmCode;

    @Column(name = "crmcorsignanddate")
    private String crmCorSignAndDate;

    @Column(name = "paymentrealizationdate")
    private LocalDate paymentRealizationDate;

    @Column(name = "custommacid")
    private String customMacId;

    @Column(name = "accessprovider")
    private String accessProvider;

    @Column(name = "fsmacid")
    private String fsmAcId;

    @Column(name = "wiredprovider")
    private String wiredProvider;

    @Column(name = "bsmacid")
    private String bsmAcId;

    @Column(name = "wirelessprovider")
    private String wirelessProvider;

    @Column(name = "fsport")
    private String fsPort;

    @Column(name = "activationdate")
    private LocalDate activationDate;

    @Column(name = "bsport")
    private String bsPort;

    @Column(name = "officeuse")
    private String officeUse;

    @Column(name = "anpstampname")
    private String anpStampName;

    @Column(name = "signatureofanp")
    private String signatureOfAnp;

    @Column(name = "mspstamname")
    private String mspStampName;

    @Column(name = "signaturofmsp")
    private String signatureOfMsp;

    @Column(name = "mspcode")
    private String mspCode;

    @Column(name = "mspdate")
    private LocalDate mspDate;

    @Column(name = "railtelrepresentivename")
    private String railtelRepresentativeName;

    @Column(name = "railtelsignature")
    private String railtelSignature;

    @Column(name = "railtel_desgnation")
    private String railtelDesignation;

    @Column(name = "railtel_date")
    private LocalDate railtelDate;

    @Column(name = "feasbilitycheckdate")
    private LocalDate feasibilityCheckDate;

    @Column(name = "flag")
    private Boolean flag;

    @Column(name = "corp_loc_id")
    private Integer corpLocId;
}
