package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "df_renewal_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DfRenewalDetails extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "df_renewal_details_id", nullable = false)
  private UUID dfRenewalDetailsId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "woid", nullable = false)
  private Integer woId;

  @Column(name = "cause", length = 100)
  private String cause;

  @Column(name = "service_sdate")
  private Date serviceStartDate;

  @Column(name = "service_edate")
  private Date serviceEndDate;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "total_sdays")
  private Integer totalServiceDays;

  @Column(name = "amount", precision = 26, scale = 10)
  private BigDecimal amount;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
