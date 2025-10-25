package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "taxdistribution")
public class TaxDistribution extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String code;

  private String name;

  private String nameInLocal;

  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sno;

  @Column(name = "partnerid", nullable = false)
  private Long partnerId;

  @Column(name = "taxcollected", nullable = false)
  private Double taxCollected;

  @Column(name = "taxdisbursed", nullable = false)
  private Double taxDisbursed;

  @Column(name = "taxtorailtel", nullable = false)
  private Double taxToRailTel;
}
