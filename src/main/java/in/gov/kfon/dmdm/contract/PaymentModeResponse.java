package in.gov.kfon.dmdm.contract;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentModeResponse {
  private UUID id;
  private String modeCode;
  private String modeName;
  private Integer displayOrder;
  private Boolean isActive;
  private List<PayoutChargeResponse> charges;
}
