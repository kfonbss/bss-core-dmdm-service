package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_renewal_details")
@Data
public class SeRenewalDetails extends Auditor {
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

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "cause")
  private String cause;

  @Column(name = "service_sdate")
  private LocalDate serviceStartDate;

  @Column(name = "service_edate")
  private LocalDate serviceEndDate;

  @Column(name = "finrefid")
  private Integer finRefId;

  @Column(name = "total_sdays")
  private Integer totalServiceDays;

  @Column(name = "bandwidth_cost")
  private Double bandwidthCost;

  @Column(name = "bandwidth_gst")
  private Double bandwidthGst;

  @Column(name = "establishment_cost")
  private Double establishmentCost;

  @Column(name = "establishment_gst")
  private Double establishmentGst;

  @Column(name = "otc_cost")
  private Double otcCost;

  @Column(name = "otc_gst")
  private Double otcGst;
}
