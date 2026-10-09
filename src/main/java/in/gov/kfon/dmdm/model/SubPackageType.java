package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Sub-package (bifurcation / R-code) type. billing-finance keys its disbursement causes on {@code
 * code} and its disbursement state machine on {@code disbBefore}/{@code disbAfter}.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sub_package_type")
public class SubPackageType extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "sub_package_type_id", nullable = false, unique = true)
  private Integer subPackageTypeId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 45)
  private String name;

  @Column(name = "name_in_local", length = 150)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  /** Legacy integer link to {@code service_type.type_id}. */
  @Column(name = "service_type")
  private Integer serviceType;

  @Column(name = "disb_before")
  private Integer disbBefore;

  @Column(name = "disb_after")
  private Integer disbAfter;

  @Column(name = "invoice_report")
  private Boolean invoiceReport;

  @Column(name = "disburse_report")
  private Boolean disburseReport;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "service_type_id")
  private ServiceType serviceTypeMaster;
}
