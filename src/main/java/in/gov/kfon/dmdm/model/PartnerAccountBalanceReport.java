package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partneraccount_balance_report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerAccountBalanceReport extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "rptid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long rptId;

  @Column(name = "state")
  private String state;

  @Column(name = "partnerid")
  private String partnerId;

  @Column(name = "companyname")
  private String companyName;

  @Column(name = "ptype")
  private String pType;

  @Column(name = "openbalance")
  private Double openBalance;

  @Column(name = "partnertopup")
  private Double partnerTopup;

  @Column(name = "received_share")
  private Double receivedShare;

  @Column(name = "sub_transfer")
  private Double subTransfer;

  @Column(name = "closebalance")
  private Double closeBalance;

  @Column(name = "rmonth")
  private String rMonth;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
