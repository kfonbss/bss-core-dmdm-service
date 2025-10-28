package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ce_disbursement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeDisbursement extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "disburseid")
  private Integer disburseId;

  @Column(name = "partnergroupid")
  private Integer partnerGroupId;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "cause")
  private String cause;

  @Column(name = "revenue")
  private BigDecimal revenue;

  @Column(name = "disbursestatusid")
  private Integer disburseStatusId;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "revenueshareid")
  private Integer revenueShareId;
}
