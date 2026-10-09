package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.constant.ServiceCategoryType;
import in.gov.kfon.dmdm.contract.GroupedServiceCategoryMappingResponse;
import in.gov.kfon.dmdm.contract.ServiceCategoryLookUp;
import in.gov.kfon.dmdm.contract.ServiceCategoryMappingRequest;
import in.gov.kfon.dmdm.contract.ServiceCategoryMappingResponse;
import in.gov.kfon.dmdm.contract.ServiceCategoryRequest;
import in.gov.kfon.dmdm.contract.ServiceCategoryResponse;
import in.gov.kfon.dmdm.contract.ServiceTypeMappingItem;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;

/**
 * Service categories (main services) and the service types each one is made of.
 *
 * <p>The mapping write methods only enforce master-data rules. Rules that need package or
 * subscriber data (not removing a service type that active subscribers' packages still use, and
 * re-syncing package.sub_package_count) stay with bss-package-management-services, which calls
 * these endpoints from its own mapping endpoints.
 */
public interface ServiceCategoryService {

  Page<ServiceCategoryResponse> search(
      ServiceCategoryType type, String search, List<UUID> serviceTypeIds, int page, int size);

  String exportCsv(ServiceCategoryType type, String search, List<UUID> serviceTypeIds);

  /** Active service categories. */
  List<ServiceCategoryLookUp> fetchLookUps();

  /** Active service categories of {@code type} whose mappings are complete. */
  List<ServiceCategoryLookUp> fetchLookUpsByType(ServiceCategoryType type);

  ServiceCategoryResponse fetchById(UUID id);

  /** Service categories mapped to exactly this set of service types. */
  List<ServiceCategoryResponse> fetchByServiceTypes(List<UUID> serviceTypeIds);

  ServiceCategoryResponse create(ServiceCategoryRequest request);

  ServiceCategoryResponse update(UUID id, ServiceCategoryRequest request);

  /** Active service type mappings of one service category. */
  List<ServiceCategoryMappingResponse> fetchMappings(UUID serviceCategoryId);

  List<ServiceCategoryMappingResponse> createMappings(ServiceCategoryMappingRequest request);

  /** Replaces the category's service types with {@code items}; dropped ones are deleted. */
  List<ServiceCategoryMappingResponse> updateMappings(
      UUID serviceCategoryId, List<ServiceTypeMappingItem> items);

  Page<GroupedServiceCategoryMappingResponse> fetchGroupedMappings(
      ServiceCategoryType type, int page, int size);
}
