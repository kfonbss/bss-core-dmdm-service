package in.gov.kfon.dmdm.contract;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A state's payment gateway row. {@code underMaintenance} is computed at read time: when true the
 * gateway is shown as {@code maintenanceMessage} instead of a payment option.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentGatewayAvailabilityResponse {
  private UUID id;
  private UUID gatewayId;
  private String gatewayCode;
  private String gatewayName;
  private String stateCode;
  private String userType;
  private Boolean isActive;
  private String displayName;
  private Integer displayOrder;
  private String maintenanceMessage;
  private LocalDateTime maintenanceFrom;
  private LocalDateTime maintenanceTo;
  private boolean underMaintenance;
}
