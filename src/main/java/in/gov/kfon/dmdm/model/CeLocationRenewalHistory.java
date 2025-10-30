package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_location_renewal_history")
@Data
public class CeLocationRenewalHistory extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "history_id")
  private UUID historyId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

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
  private LocalDate serviceSDate;

  @Column(name = "service_edate")
  private LocalDate serviceEDate;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "total_sdays")
  private Integer totalSDays;

  @Column(name = "discount_percent")
  private Integer discountPercent;

  @Column(name = "disount_amount")
  private BigDecimal discountAmount;

  @Column(name = "original_renewalfee")
  private BigDecimal originalRenewalFee;

  @Column(name = "renewalfee_after_disount")
  private BigDecimal renewalFeeAfterDiscount;

  @Column(name = "cost_per_day")
  private BigDecimal costPerDay;

  @Column(name = "loc_amount")
  private BigDecimal locAmount;

  @Column(name = "loc_gst_amount")
  private BigDecimal locGstAmount;

  @Column(name = "loc_grand_amount")
  private BigDecimal locGrandAmount;

  @Column(name = "otc_amount")
  private BigDecimal otcAmount;

  @Column(name = "otc_gst_amount")
  private BigDecimal otcGstAmount;
}
