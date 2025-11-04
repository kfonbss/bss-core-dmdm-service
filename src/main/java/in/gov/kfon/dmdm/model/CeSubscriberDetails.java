package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_subscriberdetails")
@Data
public class CeSubscriberDetails extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "details_id")
  private UUID detailsId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "id")
  private Integer id;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "balance")
  private BigDecimal balance;

  @Column(name = "expirydate")
  private Date expiryDate;

  @Column(name = "commission_date")
  private Date commissionDate;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "service_provider")
  private Integer serviceProvider;

  @Column(name = "loc_type")
  private Short locType;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "partnergroupid")
  private Integer partnerGroupId;

  @Column(name = "status")
  private BigDecimal status;

  @Column(name = "d_status")
  private Integer dStatus;

  @Column(name = "d_status_date")
  private Date dStatusDate;

  @Column(name = "cur_speed")
  private String curSpeed;

  @Column(name = "rccount")
  private Integer rcCount;

  @Column(name = "last_recharge_date")
  private Timestamp lastRechargeDate;

  @Column(name = "revenueshareid")
  private Integer revenueShareId;

  @Column(name = "service_oneyear_completed")
  private Boolean serviceOneYearCompleted;

  @Column(name = "dnote_expirydate")
  private Date dnoteExpiryDate;

  @Column(name = "dnote_validity_date")
  private Date dnoteValidityDate;

  @Column(name = "gen_invoice")
  private Integer genInvoice;

  @Column(name = "partially_paid")
  private Boolean partiallyPaid;

  @Column(name = "pppoe_enabled")
  private Boolean pppoeEnabled;

  @Column(name = "is_eo_discoverd")
  private Boolean isEoDiscovered;

  @Column(name = "eo_upstatus")
  private Boolean eoUpStatus;

  @Column(name = "reason_for_down")
  private String reasonForDown;
}
