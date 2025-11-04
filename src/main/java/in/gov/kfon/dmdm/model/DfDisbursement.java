package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "df_disbursement")
@Data
public class DfDisbursement extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "disburseid")
  private Integer disburseId;

  @Column(name = "partnergroupid")
  private Integer partnerGroupId;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "cause")
  private String cause;

  @Column(name = "woid")
  private Integer woId;

  @Column(name = "revenue", precision = 26, scale = 10)
  private BigDecimal revenue;

  @Column(name = "disbursestatusid")
  private Integer disburseStatusId;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
