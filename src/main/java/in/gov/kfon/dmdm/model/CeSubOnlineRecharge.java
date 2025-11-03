package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_subonlinerecharge")
@Data
public class CeSubOnlineRecharge extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "recharge_id")
  private UUID rechargeId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "id")
  private Long id;

  @Column(name = "ordernumber")
  private String orderNumber;

  @Column(name = "status")
  private String status;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "order_time")
  private Timestamp orderTime;

  @Column(name = "subscriberid")
  private Long subscriberId;

  @Column(name = "txnid")
  private String txnId;

  @Column(name = "banktxnid")
  private String bankTxnId;

  @Column(name = "txnamout")
  private BigDecimal txnAmount;

  @Column(name = "txndate")
  private Timestamp txnDate;

  @Column(name = "currency")
  private String currency;

  @Column(name = "respcode")
  private String respCode;

  @Column(name = "respmsg")
  private String respMsg;

  @Column(name = "gatewayname")
  private String gatewayName;

  @Column(name = "bankname")
  private String bankName;

  @Column(name = "paymentmode")
  private String paymentMode;

  @Column(name = "ErrorStatus")
  private String errorStatus;

  @Column(name = "ErrorDescription")
  private String errorDescription;

  @Column(name = "lnpshare")
  private BigDecimal lnpShare;

  @Column(name = "kfonshare")
  private BigDecimal kfonShare;

  @Column(name = "flag")
  private Boolean flag;

  @Column(name = "partially_paid")
  private Boolean partiallyPaid;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "rechargesite")
  private Short rechargeSite;

  @Column(name = "paymnetgateway")
  private Integer paymentGateway;

  @Column(name = "invoiceid")
  private Integer invoiceId;
}
