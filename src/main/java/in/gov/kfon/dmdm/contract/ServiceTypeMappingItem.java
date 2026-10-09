package in.gov.kfon.dmdm.contract;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;

@Data
public class ServiceTypeMappingItem {
  @NotNull private UUID serviceTypeId;
  private Boolean discountable;
  private Boolean providerMapping;
}
