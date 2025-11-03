package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_subfinance")
@Data
public class CeSubFinance extends Auditor {
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

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "cause")
  private String cause;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "rstatus")
  private Boolean rstatus;

  @Column(name = "subonlineref")
  private Long subOnlineRef;

  @Column(name = "subid")
  private Long subId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "finrefid")
  private Integer finRefId;
}
