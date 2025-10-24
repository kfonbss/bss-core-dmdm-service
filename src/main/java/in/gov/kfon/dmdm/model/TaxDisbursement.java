package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "taxdisbursement")
public class TaxDisbursement extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String code;

  private String name;

  private String nameInLocal;

  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "taxdisbursementid")
  private Long taxDisbursementId;

  @Column(name = "usagetransactionid", nullable = false)
  private Long usageTransactionId;

  @Column(name = "taxtypeid", nullable = false)
  private Integer taxTypeId = 1;

  @Column(name = "taxamount")
  private Integer taxAmount = 0;
}
