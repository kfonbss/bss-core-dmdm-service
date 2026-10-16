package in.gov.kfon.dmdm.packagemaster.contract;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A service category with all of its active service type mappings. */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupedServiceCategoryMappingResponse {
  private UUID serviceCategoryId;
  private Integer serviceCategoryLegacyId;
  private String serviceName;
  private String serviceLabel;
  private Integer count;
  private Boolean isActive;
  private LocalDateTime createdDate;
  private List<ServiceTypeMappingItem> serviceTypes;

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class ServiceTypeMappingItem {
    private UUID mappingRowId;
    private Integer mappingId;
    private UUID serviceTypeId;
    private String serviceTypeName;
    private String serviceTypeCode;
    private Boolean discountable;
    private Boolean providerMapping;
    private Boolean isActive;
  }
}
