package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_group_details")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DfGroupDetails extends Auditor {

  @Id
  @Column(name = "details_id", nullable = false, updatable = false)
  private UUID detailsId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "group_name", length = 250)
  private String groupName;

  @Column(name = "woid")
  private Integer woid;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "balance", precision = 10, scale = 2)
  private BigDecimal balance;

  @Column(name = "start_pop", length = 100)
  private String startPop;

  @Column(name = "end_pop", length = 100)
  private String endPop;

  @Column(name = "ss_date")
  private LocalDate ssDate;

  @Column(name = "expiry_date")
  private LocalDate expiryDate;

  @Column(name = "last_recharge_date")
  private LocalDateTime lastRechargeDate;

  @Column(name = "commission_doc", length = 100)
  private String commissionDoc;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "d_status")
  private Integer dStatus;

  @Column(name = "d_status_date")
  private LocalDate dStatusDate;

  @Column(name = "rechargecount")
  private Integer rechargeCount;

  @Column(name = "group_type")
  private Integer groupType;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
