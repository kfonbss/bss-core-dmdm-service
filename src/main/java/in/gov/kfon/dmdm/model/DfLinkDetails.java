package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_link_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DfLinkDetails extends Auditor {

  @Id
  @Column(name = "details_id", nullable = false, updatable = false)
  private UUID detailsId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "woid")
  private Integer woid;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "linkid")
  private Integer linkId;

  @Column(name = "strands_count")
  private Integer strandsCount;

  @Column(name = "fiber_type", length = 45)
  private String fiberType;

  @Column(name = "unit_price", precision = 13, scale = 2)
  private BigDecimal unitPrice;

  @Column(name = "fiber_lenght", precision = 13, scale = 3)
  private BigDecimal fiberLength;

  @Column(name = "pop_id")
  private Integer popId;

  @Column(name = "feeder_id")
  private Integer feederId;

  @Column(name = "link_type")
  private Integer linkType;

  @Column(name = "no_of_rack_units")
  private Integer noOfRackUnits;

  @Column(name = "power_rating_id")
  private Integer powerRatingId;

  @Column(name = "power_rating_cost", precision = 13, scale = 2)
  private BigDecimal powerRatingCost;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "link_d_status")
  private Short linkDStatus;

  @Column(name = "link_d_status_date")
  private LocalDate linkDStatusDate;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
