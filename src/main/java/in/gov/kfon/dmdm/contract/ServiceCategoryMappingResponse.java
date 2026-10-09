package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** One active service type mapped to a service category (a service_category_mapping row). */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCategoryMappingResponse {
  private UUID mappingRowId;
  private Integer mappingId;
  private UUID serviceCategoryId;
  private UUID serviceTypeId;
  private Integer serviceTypeIntId;
  private String serviceTypeName;
  private String serviceTypeCode;
  private Boolean discountable;
  private Boolean providerMapping;
  private Boolean isActive;
}
