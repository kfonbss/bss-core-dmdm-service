package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_locations")
@Data
public class SeLocations extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "location_id")
  private UUID locationId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "slno")
  private Integer slno;

  @Column(name = "proid")
  private Integer proid;

  @Column(name = "custid")
  private Integer custid;

  @Column(name = "service_type")
  private Integer serviceType;

  @Column(name = "service_provider")
  private Integer serviceProvider;

  @Column(name = "partnerid")
  private Integer partnerId;

  @Column(name = "loc_code")
  private String locCode;

  @Column(name = "loc_address")
  private String locAddress;

  @Column(name = "bandwidth")
  private String bandwidth;

  @Column(name = "bandwidth_cost")
  private BigDecimal bandwidthCost;

  @Column(name = "establishment_cost")
  private BigDecimal establishmentCost;

  @Column(name = "otc_cost")
  private BigDecimal otcCost;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "expirydate")
  private LocalDate expiryDate;

  @Column(name = "balance")
  private BigDecimal balance;

  @Column(name = "commission_date")
  private LocalDate commissionDate;

  @Column(name = "commission_doc")
  private String commissionDoc;

  @Column(name = "circuit_details")
  private String circuitDetails;

  @Column(name = "d_status")
  private Integer dStatus;

  @Column(name = "d_status_date")
  private LocalDate dStatusDate;

  @Column(name = "rccount")
  private Integer rcCount;

  @Column(name = "last_recharge_date")
  private LocalDateTime lastRechargeDate;
}
