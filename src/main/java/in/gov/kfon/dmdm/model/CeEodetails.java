package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ce_eodetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CeEodetails extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "eodetails_id", nullable = false)
  private UUID eodetailsId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "subid")
  private Integer subId;

  @Column(name = "contact_person_name")
  private String contactPersonName;

  @Column(name = "mobileno")
  private String mobileNo;

  @Column(name = "land_line_number")
  private String landLineNumber;

  @Column(name = "emailid")
  private String emailId;

  @Column(name = "customer_address")
  private String customerAddress;

  @Column(name = "installation_address")
  private String installationAddress;

  @Column(name = "commission_date")
  private LocalDate commissionDate;

  @Column(name = "commission_doc")
  private String commissionDoc;

  @Column(name = "created_by_platform")
  private String createdByPlatform;

  @Column(name = "end_office_name")
  private String endOfficeName;
}
