package in.gov.kfon.dmdm.model;

import in.gov.kfon.dmdm.constant.PaymentGatewayUserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** A payment gateway offered in a state to subscribers (online recharge) or partners (top-up). */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payment_gateway_availability")
public class PaymentGatewayAvailability extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "gateway_id", nullable = false)
  private Gateway gateway;

  @Column(name = "state_code", nullable = false, length = 5)
  private String stateCode;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_type", nullable = false, length = 20)
  private PaymentGatewayUserType userType;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive = true;

  @Column(name = "display_name", length = 50)
  private String displayName;

  @Column(name = "display_order", nullable = false)
  private Integer displayOrder = 1;

  @Column(name = "maintenance_message")
  private String maintenanceMessage;

  @Column(name = "maintenance_from")
  private LocalDateTime maintenanceFrom;

  @Column(name = "maintenance_to")
  private LocalDateTime maintenanceTo;

  /** True when {@code now} falls inside the maintenance window. */
  public boolean isUnderMaintenance(LocalDateTime now) {
    return maintenanceFrom != null
        && maintenanceTo != null
        && !now.isBefore(maintenanceFrom)
        && now.isBefore(maintenanceTo);
  }
}
