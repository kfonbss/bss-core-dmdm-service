package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partnerdisbursement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerDisbursement extends Auditor {

  @Id
  @Column(name = "id")
  private UUID id = UUID.randomUUID();

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "partnerdisbursementid")
  private Long partnerDisbursementId;

  @Column(name = "partnergroupid")
  private Integer partnerGroupId;

  @Column(name = "revenue")
  private BigDecimal revenue;

  @Column(name = "disbursestatusid")
  private Integer disburseStatusId = 3;

  @Column(name = "subscriberid")
  private Long subscriberId;

  @Column(name = "cause")
  private String cause;

  @Column(name = "subfinanceid")
  private Long subFinanceId;

  @Column(name = "onsubbssref")
  private String onSubBssRef;

  @Column(name = "lowestrevenue")
  private BigDecimal lowestRevenue;

  @Column(name = "agramount")
  private BigDecimal agrAmount;

  @Column(name = "oldsubfinanceid")
  private Long oldSubFinanceId;

  @Column(name = "rechargemode")
  private Integer rechargeMode = 0;

  @Column(name = "plantype")
  private Integer planType = 0;

  @Column(name = "revenueshareid")
  private Integer revenueShareId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "sub_packageid")
  private Integer subPackageId;

  @Column(name = "diburse_mode")
  private Integer disburseMode = 0;

  @Column(name = "cause_detail_id")
  private Integer causeDetailId = 0;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
