package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subscription")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription extends Auditor {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "subscriberid")
  private Long subscriberid;

  @Column(name = "status")
  private Integer status = 0;

  @Column(name = "expiry")
  private LocalDateTime expiry;

  @Column(name = "packageid")
  private Integer packageid = 1;

  @Column(name = "firstuse")
  private Integer firstuse = 1;

  @Column(name = "partnergroupid")
  private Integer partnergroupid;

  @Column(name = "vlantableid")
  private Integer vlantableid;

  @Column(name = "alloted_vol")
  private Long allotedVol;

  @Column(name = "consumed_vol")
  private Long consumedVol;

  @Column(name = "cur_speed", length = 18)
  private String curSpeed;

  @Column(name = "bod_profile", length = 45)
  private String bodProfile = "";

  @Column(name = "offerid")
  private Integer offerid;

  @Column(name = "reset_request")
  private Integer resetRequest = 0;

  @Column(name = "reset_request_date")
  private LocalDateTime resetRequestDate;

  @Column(name = "remarks", length = 200)
  private String remarks;

  @Column(name = "last_topup_date")
  private LocalDateTime lastTopupDate;

  @Column(name = "last_topup_amount")
  private BigDecimal lastTopupAmount = BigDecimal.valueOf(0.00);

  @Column(name = "disabled")
  private Integer disabled = 0;

  @Column(name = "plan_mig")
  private Integer planMig = 0;

  @Column(name = "payment_mode")
  private Integer paymentMode = 1;

  @Column(name = "reactive_date")
  private LocalDateTime reactiveDate;

  @Column(name = "addon_data")
  private BigDecimal addonData = BigDecimal.valueOf(0.00);

  @Column(name = "addon_consumed")
  private BigDecimal addonConsumed = BigDecimal.valueOf(0.00);

  @Column(name = "volume_afterfallback")
  private BigDecimal volumeAfterFallback = BigDecimal.valueOf(0.00);

  @Column(name = "usage_flag")
  private Integer usageFlag = 0;

  @Column(name = "last_recharge")
  private LocalDateTime lastRecharge;

  @Column(name = "addon_data_start")
  private LocalDateTime addonDataStart;

  @Column(name = "fallback_data_start")
  private LocalDateTime fallbackDataStart;

  @Column(name = "acctlastupdatetime")
  private LocalDateTime acctLastUpdateTime;

  @Column(name = "rad_account")
  private Integer radAccount = 0;

  @Column(name = "fallback_coa")
  private Integer fallbackCoa = 0;

  @Column(name = "profile_type", length = 45)
  private String profileType = "Juniper";

  @Column(name = "send_alert_id")
  private Long sendAlertId = 0L;

  @Column(name = "send_alert_date")
  private LocalDateTime sendAlertDate;

  @Column(name = "term_count")
  private Integer termCount = 0;

  @Column(name = "term_validity")
  private LocalDateTime termValidity;

  @Column(name = "fup_alert")
  private Integer fupAlert = 0;

  @Column(name = "recharge_lock")
  private Integer rechargeLock = 0;

  @Column(name = "extension_remarks", length = 180)
  private String extensionRemarks;

  @Column(name = "iptv_package")
  private Integer iptvPackage;

  @Column(name = "iptv_bss_expiry")
  private LocalDateTime iptvBssExpiry;

  @Column(name = "onetimecharges", length = 45)
  private String onetimeCharges;

  @Column(name = "newrad", length = 20)
  private String newRad;

  @Column(name = "free_validity")
  private Integer freeValidity;

  @Column(name = "frc_date")
  private LocalDateTime frcDate;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;
}
