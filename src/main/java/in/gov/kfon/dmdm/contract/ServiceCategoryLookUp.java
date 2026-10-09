package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Service category dropdown entry. */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCategoryLookUp {
  private UUID id;
  private Integer serviceCategoryId;
  private String name;
  private Boolean isActive;
  private Integer subPackageCount;
  private String description;
  private Boolean isBod;
}
