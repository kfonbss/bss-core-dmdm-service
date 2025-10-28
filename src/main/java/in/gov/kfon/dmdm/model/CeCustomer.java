package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ce_customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CeCustomer extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "customer_id", nullable = false)
  private UUID customerId;

  @Column(name = "code")
  private String code;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "short_name")
  private String shortName;

  @Column(name = "contact_person")
  private String contactPerson;

  @Column(name = "mobile")
  private String mobile;

  @Column(name = "email")
  private String email;

  @Column(name = "address")
  private String address;

  @Column(name = "pincode")
  private String pincode;

  @Column(name = "description")
  private String description;

  @Column(name = "kyc_added")
  private Boolean kycAdded = false;

  @Column(name = "service_type")
  private Integer serviceType = 1;

  @Column(name = "pay_via_invoice")
  private Boolean payViaInvoice = false;

  @Column(name = "enquiry_id")
  private Integer enquiryId;

  @Column(name = "company_type")
  private String companyType;

  @Column(name = "billing_category")
  private String billingCategory;

  @Column(name = "parent_dept_id")
  private String parentDeptId;

  @Column(name = "enable_cdnote")
  private Boolean enableCdnote = false;

  @Column(name = "location_wise_dnote")
  private Boolean locationWiseDnote = false;
}
