package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partneragreementdetail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerAgreementDetail extends Auditor {

  @Id
  @Column(name = "details_id", nullable = false, updatable = false)
  private UUID detailsId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "version")
  private Integer version;

  @Column(name = "renewed_agreementdate")
  private LocalDate renewedAgreementDate;

  @Column(name = "renewed_agreementcopy")
  private String renewedAgreementCopy;

  @Column(length = 50)
  private String code;

  @Column(length = 250)
  private String name;

  @Column(name = "name_in_local", length = 250)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
