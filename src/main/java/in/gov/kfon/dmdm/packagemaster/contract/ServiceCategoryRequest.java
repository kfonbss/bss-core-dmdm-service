package in.gov.kfon.dmdm.packagemaster.contract;

import in.gov.kfon.dmdm.packagemaster.constant.BundleType;
import in.gov.kfon.dmdm.packagemaster.constant.ServiceCategoryType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServiceCategoryRequest {
  @NotBlank private String name;
  @NotBlank private String label;
  private Integer count;
  private Boolean isActive;
  private BundleType bundleType;
  private Boolean isAddon;
  private Boolean isBod;
  private ServiceCategoryType serviceCategoryType;
}
