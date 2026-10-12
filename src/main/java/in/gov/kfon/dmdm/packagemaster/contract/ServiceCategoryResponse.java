package in.gov.kfon.dmdm.packagemaster.contract;

import in.gov.kfon.dmdm.packagemaster.constant.BundleType;
import in.gov.kfon.dmdm.packagemaster.constant.ServiceCategoryType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Service category with the service types it is mapped to. */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCategoryResponse {
  private UUID id;
  private Integer serviceCategoryId;
  private String name;
  private String label;
  private Integer count;
  private BundleType bundleType;
  private Boolean isAddon;
  private Boolean isBod;
  private Boolean active;
  private ServiceCategoryType serviceCategoryType;
  private List<PackageLookUp> serviceTypes;
  private LocalDateTime createdDate;
  private String description;
}
