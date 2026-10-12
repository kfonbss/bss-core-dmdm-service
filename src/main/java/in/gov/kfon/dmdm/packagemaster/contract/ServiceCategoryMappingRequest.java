package in.gov.kfon.dmdm.packagemaster.contract;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class ServiceCategoryMappingRequest {
  @NotNull private UUID serviceCategoryId;
  @NotNull @NotEmpty private List<ServiceTypeMappingItem> serviceTypeMappings;
}
