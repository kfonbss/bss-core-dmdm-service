package in.gov.kfon.dmdm.contract;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Every package master in one payload, including inactive rows, so the package service can resolve
 * any id it has stored.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PackageMastersBundle {
  private List<ServiceTypeResponse> serviceTypes;
  private List<SubPackageTypeResponse> subPackageTypes;
  private List<MasterTypeResponse> packageTypes;
  private List<MasterTypeResponse> planTypes;
  private List<MasterTypeResponse> categoryTypes;
  private List<PackagePlanTypeResponse> packagePlanTypes;
  private List<SpeedResponse> speedProfiles;
  private List<SpeedResponse> fallbackSpeeds;
  private List<ServiceCategoryResponse> serviceCategories;
  private List<ServiceCategoryMappingResponse> serviceCategoryMappings;
}
