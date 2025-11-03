package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_link_renewal_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DfLinkRenewalHistory extends Auditor {

  @Id
  @Column(name = "history_id", nullable = false, updatable = false)
  private UUID historyId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "mg_invoiceid")
  private Integer mgInvoiceId;

  @Column(name = "linkid")
  private Integer linkId;

  @Column(name = "grouplinkid")
  private Integer groupLinkId;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "ss_date")
  private LocalDate ssDate;

  @Column(name = "se_date")
  private LocalDate seDate;

  @Column(name = "total_sdays")
  private Integer totalSDays;

  @Column(name = "unit_price", precision = 25, scale = 10)
  private BigDecimal unitPrice;

  @Column(name = "link_gst", precision = 25, scale = 10)
  private BigDecimal linkGst;

  @Column(name = "link_amount", precision = 25, scale = 10)
  private BigDecimal linkAmount;

  @Column(name = "link_grand_amount", precision = 25, scale = 10)
  private BigDecimal linkGrandAmount;

  @Column(name = "fiber_lenght", precision = 13, scale = 3)
  private BigDecimal fiberLength;

  @Column(name = "trands_count")
  private Integer strandsCount;

  @Column(name = "link_type")
  private Integer linkType;

  @Column(name = "feeder_id")
  private Integer feederId;

  @Column(name = "pop_id")
  private Integer popId;

  @Column(name = "no_of_rack_units")
  private Integer noOfRackUnits;

  @Column(name = "power_rating_id")
  private Integer powerRatingId;

  @Column(name = "rating_cost_per_30_days", precision = 25, scale = 10)
  private BigDecimal ratingCostPer30Days;

  @Column(name = "total_rating_cost", precision = 25, scale = 10)
  private BigDecimal totalRatingCost;

  @Column(name = "total_rating_gstcost", precision = 25, scale = 10)
  private BigDecimal totalRatingGstCost;

  @Column(name = "total_power_rating_cost", precision = 25, scale = 10)
  private BigDecimal totalPowerRatingCost;

  @Column(name = "group_type")
  private Integer groupType;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
