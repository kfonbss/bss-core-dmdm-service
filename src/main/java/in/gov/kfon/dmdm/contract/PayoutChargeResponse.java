package in.gov.kfon.dmdm.contract;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayoutChargeResponse {
  private UUID id;
  private String mode;
  private BigDecimal startRange;
  private BigDecimal endRange;
  private BigDecimal rate;
  private Boolean isActive;
}
