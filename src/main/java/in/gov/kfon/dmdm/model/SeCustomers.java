package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_customers")
@Data
public class SeCustomers extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "customer_id")
  private UUID customerId;

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
  private Integer kycAdded;
}
