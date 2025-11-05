package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_otccharges")
@Data
public class DfOtcCharges extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "charges_id", nullable = false, updatable = false)
  private UUID chargesId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "opgw_amount")
  private BigDecimal opgwAmount;

  @Column(name = "adds_intercity_amount")
  private BigDecimal addsIntercityAmount;

  @Column(name = "adds_intracity_amount")
  private BigDecimal addsIntracityAmount;

  @Column(name = "opgw_core_cost")
  private BigDecimal opgwCoreCost;

  @Column(name = "opgw_pair_cost")
  private BigDecimal opgwPairCost;

  @Column(name = "adss_core_cost")
  private BigDecimal adssCoreCost;

  @Column(name = "adss_pair_cost")
  private BigDecimal adssPairCost;

  @Column(name = "otc_amount")
  private BigDecimal otcAmount;

  @Column(name = "rack_amount")
  private BigDecimal rackAmount;

  @Column(name = "year")
  private String year;

  @Column(name = "fyear_s_date")
  private Date fyearSDate;

  @Column(name = "fyear_e_date")
  private Date fyearEDate;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
