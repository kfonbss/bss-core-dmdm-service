package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_dnote_renewal_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeDnoteRenewalHistory extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "history_id", nullable = false)
  private UUID historyId;

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

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "breakupid")
  private Integer breakupId;

  @Column(name = "serviceid")
  private Integer serviceId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "mg_invoiceid")
  private Integer mgInvoiceId;

  @Column(name = "service_sdate")
  private LocalDate serviceStartDate;

  @Column(name = "service_edate")
  private LocalDate serviceEndDate;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "total_sdays")
  private Integer totalSDays;

  @Column(name = "discount_percent")
  private Integer discountPercent;

  @Column(name = "disount_amount", precision = 26, scale = 10)
  private BigDecimal discountAmount;

  @Column(name = "original_renewalfee", precision = 26, scale = 10)
  private BigDecimal originalRenewalFee;

  @Column(name = "renewalfee_after_disount", precision = 26, scale = 10)
  private BigDecimal renewalFeeAfterDiscount;

  @Column(name = "cost_per_day", precision = 26, scale = 10)
  private BigDecimal costPerDay;

  @Column(name = "loc_amount", precision = 26, scale = 10)
  private BigDecimal locAmount;

  @Column(name = "loc_gst_amount", precision = 26, scale = 10)
  private BigDecimal locGstAmount;

  @Column(name = "loc_grand_amount", precision = 26, scale = 10)
  private BigDecimal locGrandAmount;
}
