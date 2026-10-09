package in.gov.kfon.dmdm.contract;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class ServiceCategoryMappingRequest {
  @NotNull private UUID serviceCategoryId;
  @NotEmpty private List<@Valid ServiceTypeMappingItem> serviceTypeMappings;
}
