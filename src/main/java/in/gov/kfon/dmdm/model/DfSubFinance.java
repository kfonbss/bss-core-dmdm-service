package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "df_subfinance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DfSubFinance extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "df_subfinance_id", nullable = false)
  private UUID dfSubFinanceId;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "subscriberid", nullable = false)
  private Integer subscriberId;

  @Column(name = "amount", precision = 10, scale = 2, nullable = false)
  private BigDecimal amount;

  @Column(name = "cause", length = 45, nullable = false)
  private String cause;

  @Column(name = "woid")
  private Integer woId;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "finrefid")
  private Integer finRefId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
