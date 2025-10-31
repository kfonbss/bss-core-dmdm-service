package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partnerfinance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerFinance extends Auditor {

  @Id
  @Column(name = "id")
  private UUID id = UUID.randomUUID();

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "partnerfinanceid")
  private Long partnerFinanceId;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "cause")
  private String cause;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "subonlineref")
  private Long subOnlineRef;

  @Column(name = "subfinanceid")
  private Long subFinanceId;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
