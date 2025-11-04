package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_disbursement")
@Data
public class SeDisbursement extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "disburseid")
  private Integer disburseId;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "cause")
  private String cause;

  @Column(name = "revenue")
  private Double revenue;

  @Column(name = "disbursestatusid")
  private Integer disburseStatusId;

  @Column(name = "finrefid")
  private Integer finRefId;
}
