package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_renewal_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeRenewalDetails extends Auditor {
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

  @Column(name = "id")
  private Integer id;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "cause")
  private String cause;

  @Column(name = "service_sdate")
  private LocalDate serviceStartDate;

  @Column(name = "service_edate")
  private LocalDate serviceEndDate;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "total_sdays")
  private Integer totalServiceDays;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "discount_percent")
  private Integer discountPercent;

  @Column(name = "original_renewalfee")
  private Double originalRenewalFee;

  @Column(name = "renewalfee_after_disount")
  private Double renewalFeeAfterDiscount;

  @Column(name = "cost_per_day")
  private Double costPerDay;
}
