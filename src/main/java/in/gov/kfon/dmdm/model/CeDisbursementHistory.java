package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_disbursement_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeDisbursementHistory extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "history_id", nullable = false)
  private UUID historyId;

  @Column(name = "name")
  private String name;

  @Column(name = "code")
  private String code;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "type")
  private Boolean type = true;

  @Column(name = "disbid")
  private Integer disbId;

  @Column(name = "partnergroupid")
  private Integer partnerGroupId;

  @Column(name = "subscriberid", nullable = false)
  private Integer subscriberId;

  @Column(name = "locid", nullable = false)
  private Integer locId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "cause")
  private String cause;

  @Column(name = "servicestartdate")
  private LocalDateTime serviceStartDate;

  @Column(name = "serviceenddate")
  private LocalDateTime serviceEndDate;

  @Column(name = "revenue")
  private Double revenue;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "revenueshareid")
  private Integer revenueShareId;

  @Column(name = "disbursestatusid")
  private Boolean disburseStatusId;
}
