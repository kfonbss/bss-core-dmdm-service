package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partnerdetail")
@Data
@NoArgsConstructor
public class PartnerDetail extends Auditor {

  @Id
  @Column(name = "id")
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "partnercompanyname")
  private String partnerCompanyName;

  @Column(name = "status", nullable = false)
  private Boolean status = false;

  @Column(name = "companyregistrationno")
  private String companyRegistrationNo;

  @Column(name = "servicetaxno")
  private String serviceTaxNo;

  @Column(name = "incometaxno")
  private String incomeTaxNo;

  @Column(name = "vatno")
  private String vatNo;

  @Column(name = "state")
  private String state;

  @Column(name = "pin")
  private Integer pin;

  @Column(name = "registrationdate")
  private LocalDate registrationDate;

  @Column(name = "agreementno")
  private String agreementNo;

  @Column(name = "agreementdate")
  private LocalDate agreementDate;

  @Column(name = "keycontactname")
  private String keyContactName;

  @Column(name = "keycontactnumber")
  private Long keyContactNumber;

  @Column(name = "keycontactemail")
  private String keyContactEmail;

  @Column(length = 50)
  private String code;

  @Column(length = 250)
  private String name;

  @Column(name = "name_in_local", length = 250)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
