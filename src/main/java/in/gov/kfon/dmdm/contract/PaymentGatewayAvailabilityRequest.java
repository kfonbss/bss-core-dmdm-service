package in.gov.kfon.dmdm.contract;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create or update a state's payment gateway row. {@code gatewayId}, {@code stateCode} and {@code
 * userType} are used on create only; a null field is left unchanged on update. Clear the
 * maintenance window by sending {@code clearMaintenance = true}.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentGatewayAvailabilityRequest {
  private UUID gatewayId;
  private String stateCode;
  private String userType;
  private Boolean isActive;
  private String displayName;
  private Integer displayOrder;
  private String maintenanceMessage;
  private LocalDateTime maintenanceFrom;
  private LocalDateTime maintenanceTo;
  private Boolean clearMaintenance;
}
