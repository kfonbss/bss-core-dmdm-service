package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Data
@Entity
@Table(name = "partneronlinerecharge")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerOnlineRecharge extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "recharge_id", nullable = false, updatable = false)
  private UUID rechargeId;

  @Column(name = "ordernumber", length = 64)
  private String orderNumber;

  @Column(name = "status", length = 18)
  private String status;

  @Column(name = "amount")
  private Float amount;

  @Column(name = "partnerid", length = 45)
  private String partnerId;

  @Column(name = "order_time")
  private LocalDateTime orderTime;

  @Column(name = "txnid", length = 64)
  private String txnId;

  @Column(name = "banktxnid", length = 64)
  private String bankTxnId;

  @Column(name = "txnamout")
  private Float txnAmount;

  @Column(name = "txndate")
  private LocalDateTime txnDate;

  @Column(name = "currency", length = 5)
  private String currency;

  @Column(name = "respcode", length = 45)
  private String respCode;

  @Column(name = "respmsg", length = 256)
  private String respMsg;

  @Column(name = "gatewayname", length = 45)
  private String gatewayName;

  @Column(name = "bankname", length = 256)
  private String bankName;

  @Column(name = "paymentmode")
  private Integer paymentMode;

  @Column(name = "rechargesite")
  private Integer rechargeSite;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
