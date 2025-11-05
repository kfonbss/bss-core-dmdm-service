package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_locfinance")
@Data
public class SeLocFinance {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "finance_id")
  private UUID financeId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "finid")
  private Integer finId;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "cause")
  private String cause;

  @Column(name = "finrefid")
  private Integer finRefId;
}
