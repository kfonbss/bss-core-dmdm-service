package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.constant.ServiceCategoryType;
import in.gov.kfon.dmdm.contract.GroupedServiceCategoryMappingResponse;
import in.gov.kfon.dmdm.contract.ServiceCategoryLookUp;
import in.gov.kfon.dmdm.contract.ServiceCategoryMappingRequest;
import in.gov.kfon.dmdm.contract.ServiceCategoryMappingResponse;
import in.gov.kfon.dmdm.contract.ServiceCategoryRequest;
import in.gov.kfon.dmdm.contract.ServiceCategoryResponse;
import in.gov.kfon.dmdm.contract.ServiceTypeMappingItem;
import in.gov.kfon.dmdm.model.ServiceCategory;
import in.gov.kfon.dmdm.model.ServiceCategoryMapping;
import in.gov.kfon.dmdm.model.ServiceType;
import in.gov.kfon.dmdm.repository.ServiceCategoryMappingRepository;
import in.gov.kfon.dmdm.repository.ServiceCategoryRepository;
import in.gov.kfon.dmdm.repository.ServiceTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceCategoryServiceImpl implements ServiceCategoryService {

  private final ServiceCategoryRepository serviceCategoryRepository;
  private final ServiceCategoryMappingRepository mappingRepository;
  private final ServiceTypeRepository serviceTypeRepository;

  @Override
  public Page<ServiceCategoryResponse> search(
      ServiceCategoryType type, String search, List<UUID> serviceTypeIds, int page, int size) {
    Page<ServiceCategory> data = query(type, search, serviceTypeIds, PageRequest.of(page, size));
    Map<UUID, List<ServiceCategoryMapping>> mappings =
        activeMappingsByCategory(data.getContent().stream().map(ServiceCategory::getId).toList());
    return data.map(
        sc ->
            PackageMasterMapper.toServiceCategory(
                sc, mappings.getOrDefault(sc.getId(), List.of())));
  }

  @Override
  public String exportCsv(ServiceCategoryType type, String search, List<UUID> serviceTypeIds) {
    List<ServiceCategory> categories =
        query(type, search, serviceTypeIds, Pageable.unpaged()).getContent();
    Map<UUID, List<ServiceCategoryMapping>> mappings =
        activeMappingsByCategory(categories.stream().map(ServiceCategory::getId).toList());

    StringBuilder csv =
        new StringBuilder(
            "Sl No,Name,Label,Category Type,Sub Service Count,Bundle Type,Is Addon,Is BOD,Active,"
                + "Service Types,Created Date\n");
    int slNo = 1;
    for (ServiceCategory sc : categories) {
      ServiceCategoryResponse row =
          PackageMasterMapper.toServiceCategory(sc, mappings.getOrDefault(sc.getId(), List.of()));
      String serviceTypeNames =
          row.getServiceTypes().stream()
              .map(st -> st.getName())
              .filter(Objects::nonNull)
              .collect(Collectors.joining("; "));
      csv.append(slNo++)
          .append(',')
          .append(csvSafe(row.getName()))
          .append(',')
          .append(csvSafe(row.getLabel()))
          .append(',')
          .append(csvSafe(row.getServiceCategoryType()))
          .append(',')
          .append(csvSafe(row.getCount()))
          .append(',')
          .append(csvSafe(row.getBundleType()))
          .append(',')
          .append(Boolean.TRUE.equals(row.getIsAddon()) ? "Yes" : "No")
          .append(',')
          .append(Boolean.TRUE.equals(row.getIsBod()) ? "Yes" : "No")
          .append(',')
          .append(Boolean.TRUE.equals(row.getActive()) ? "Active" : "Inactive")
          .append(',')
          .append(csvSafe(serviceTypeNames))
          .append(',')
          .append(csvSafe(row.getCreatedDate()))
          .append('\n');
    }
    return csv.toString();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.SERVICE_CATEGORY_LOOKUPS, key = "'active'")
  public List<ServiceCategoryLookUp> fetchLookUps() {
    return toLookUps(serviceCategoryRepository.findByIsActiveTrue(), false);
  }

  @Override
  @Cacheable(cacheNames = CacheNames.SERVICE_CATEGORY_LOOKUPS, key = "'type:' + #type")
  public List<ServiceCategoryLookUp> fetchLookUpsByType(ServiceCategoryType type) {
    return toLookUps(
        serviceCategoryRepository.findByServiceCategoryTypeAndIsActiveTrue(type), true);
  }

  /**
   * @param completeOnly keep only categories whose active mapping count equals their configured
   *     sub-service count — a half-configured category can't be used on a package yet
   */
  private List<ServiceCategoryLookUp> toLookUps(
      List<ServiceCategory> categories, boolean completeOnly) {
    Map<UUID, List<ServiceCategoryMapping>> mappings =
        activeMappingsByCategory(categories.stream().map(ServiceCategory::getId).toList());
    return categories.stream()
        .filter(
            sc -> {
              if (!completeOnly) {
                return true;
              }
              Integer configured = sc.getCount();
              return configured != null
                  && configured != 0
                  && mappings.getOrDefault(sc.getId(), List.of()).size() == configured;
            })
        .map(
            sc ->
                ServiceCategoryLookUp.builder()
                    .id(sc.getId())
                    .serviceCategoryId(sc.getServiceCategoryId())
                    .name(sc.getName())
                    .isActive(sc.getIsActive())
                    .subPackageCount(sc.getCount())
                    .description(
                        PackageMasterMapper.describe(
                            sc, mappings.getOrDefault(sc.getId(), List.of())))
                    .isBod(Boolean.TRUE.equals(sc.getIsBod()))
                    .build())
        .toList();
  }

  @Override
  public ServiceCategoryResponse fetchById(UUID id) {
    return toResponse(getServiceCategory(id));
  }

  @Override
  public List<ServiceCategoryResponse> fetchByServiceTypes(List<UUID> serviceTypeIds) {
    if (serviceTypeIds == null || serviceTypeIds.isEmpty()) {
      throw new IllegalArgumentException("serviceTypeIds must not be empty");
    }
    Set<UUID> requested = new HashSet<>(serviceTypeIds);
    if (requested.size() != serviceTypeIds.size()) {
      throw new IllegalArgumentException("Duplicate serviceTypeId in request");
    }

    Set<UUID> candidateIds =
        mappingRepository.findByServiceType_IdInAndIsActiveTrue(requested).stream()
            .map(m -> m.getServiceCategory().getId())
            .collect(Collectors.toSet());
    // A category matches only if its full active set of service types is exactly the requested
    // set. Several categories can match (e.g. many map to INTERNET alone) — all are returned.
    Map<UUID, List<ServiceCategoryMapping>> mappings = activeMappingsByCategory(candidateIds);
    List<ServiceCategoryResponse> matches =
        serviceCategoryRepository.findAllById(candidateIds).stream()
            .filter(
                sc ->
                    serviceTypeIdsOf(mappings.getOrDefault(sc.getId(), List.of()))
                        .equals(requested))
            .map(
                sc ->
                    PackageMasterMapper.toServiceCategory(
                        sc, mappings.getOrDefault(sc.getId(), List.of())))
            .toList();
    if (matches.isEmpty()) {
      throw new EntityNotFoundException(
          "No service category is mapped to exactly this set of service types");
    }
    return matches;
  }

  @Override
  @Transactional
  @Caching(
      evict = {
        @CacheEvict(cacheNames = CacheNames.PACKAGE_MASTERS_BUNDLE, allEntries = true),
        @CacheEvict(cacheNames = CacheNames.SERVICE_CATEGORY_LOOKUPS, allEntries = true)
      })
  public ServiceCategoryResponse create(ServiceCategoryRequest request) {
    if (serviceCategoryRepository.existsByNameIgnoreCaseAndServiceCategoryType(
        request.getName(), request.getServiceCategoryType())) {
      throw new IllegalArgumentException("Service category already exists");
    }
    validateAddonBod(request);

    ServiceCategory entity =
        ServiceCategory.builder()
            .name(request.getName())
            .label(request.getLabel())
            .count(request.getCount())
            .isActive(request.getIsActive() == null || request.getIsActive())
            .bundleType(request.getBundleType())
            .isAddon(Boolean.TRUE.equals(request.getIsAddon()))
            .isBod(Boolean.TRUE.equals(request.getIsBod()))
            .serviceCategoryType(request.getServiceCategoryType())
            .build();
    entity.setCreatedDate(new Date());
    return toResponse(serviceCategoryRepository.saveAndFlush(entity));
  }

  @Override
  @Transactional
  @Caching(
      evict = {
        @CacheEvict(cacheNames = CacheNames.PACKAGE_MASTERS_BUNDLE, allEntries = true),
        @CacheEvict(cacheNames = CacheNames.SERVICE_CATEGORY_LOOKUPS, allEntries = true)
      })
  public ServiceCategoryResponse update(UUID id, ServiceCategoryRequest request) {
    ServiceCategory entity = getServiceCategory(id);
    validateAddonBod(request);
    if (!entity.getName().equalsIgnoreCase(request.getName())
        && serviceCategoryRepository.existsByNameIgnoreCaseAndServiceCategoryType(
            request.getName(), request.getServiceCategoryType())) {
      throw new IllegalArgumentException("Service category name already exists");
    }

    entity.setName(request.getName());
    entity.setLabel(request.getLabel());
    entity.setCount(request.getCount());
    entity.setBundleType(request.getBundleType());
    entity.setIsAddon(Boolean.TRUE.equals(request.getIsAddon()));
    entity.setIsBod(Boolean.TRUE.equals(request.getIsBod()));
    entity.setServiceCategoryType(request.getServiceCategoryType());
    if (request.getIsActive() != null) {
      entity.setIsActive(request.getIsActive());
    }
    entity.setModifiedDate(new Date());
    return toResponse(serviceCategoryRepository.save(entity));
  }

  @Override
  public List<ServiceCategoryMappingResponse> fetchMappings(UUID serviceCategoryId) {
    return mappingRepository.findByServiceCategory_IdAndIsActiveTrue(serviceCategoryId).stream()
        .map(PackageMasterMapper::toMapping)
        .toList();
  }

  @Override
  @Transactional
  @Caching(
      evict = {
        @CacheEvict(cacheNames = CacheNames.PACKAGE_MASTERS_BUNDLE, allEntries = true),
        @CacheEvict(cacheNames = CacheNames.SERVICE_CATEGORY_LOOKUPS, allEntries = true)
      })
  public List<ServiceCategoryMappingResponse> createMappings(
      ServiceCategoryMappingRequest request) {
    ServiceCategory category =
        serviceCategoryRepository
            .findById(request.getServiceCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid serviceCategoryId"));

    if (!mappingRepository.findByServiceCategory_IdAndIsActiveTrue(category.getId()).isEmpty()) {
      throw new IllegalArgumentException(
          "Service category '"
              + category.getName()
              + "' is already configured in the combination table. "
              + "Use the update endpoint to change sub-services.");
    }
    Map<UUID, ServiceTypeMappingItem> requested =
        validateMappingRequest(category, request.getServiceTypeMappings());

    List<ServiceCategoryMapping> toSave = new ArrayList<>();
    for (ServiceTypeMappingItem item : requested.values()) {
      toSave.add(newMapping(category, item));
    }
    return mappingRepository.saveAllAndFlush(toSave).stream()
        .map(PackageMasterMapper::toMapping)
        .toList();
  }

  @Override
  @Transactional
  @Caching(
      evict = {
        @CacheEvict(cacheNames = CacheNames.PACKAGE_MASTERS_BUNDLE, allEntries = true),
        @CacheEvict(cacheNames = CacheNames.SERVICE_CATEGORY_LOOKUPS, allEntries = true)
      })
  public List<ServiceCategoryMappingResponse> updateMappings(
      UUID serviceCategoryId, List<ServiceTypeMappingItem> items) {
    ServiceCategory category = getServiceCategory(serviceCategoryId);
    Map<UUID, ServiceTypeMappingItem> requested = validateMappingRequest(category, items);

    List<ServiceCategoryMapping> existing =
        mappingRepository.findByServiceCategory_IdAndIsActiveTrue(serviceCategoryId);
    Map<UUID, ServiceCategoryMapping> existingByServiceType =
        existing.stream()
            .filter(m -> m.getServiceType() != null)
            .collect(Collectors.toMap(m -> m.getServiceType().getId(), Function.identity()));

    List<ServiceCategoryMapping> toRemove =
        existing.stream()
            .filter(
                m ->
                    m.getServiceType() == null
                        || !requested.containsKey(m.getServiceType().getId()))
            .toList();
    if (!toRemove.isEmpty()) {
      mappingRepository.deleteAll(toRemove);
      mappingRepository.flush();
    }

    List<ServiceCategoryMapping> toSave = new ArrayList<>();
    for (ServiceTypeMappingItem item : requested.values()) {
      ServiceCategoryMapping mapping = existingByServiceType.get(item.getServiceTypeId());
      if (mapping == null) {
        toSave.add(newMapping(category, item));
      } else {
        mapping.setDiscountable(item.getDiscountable());
        mapping.setProviderMapping(item.getProviderMapping());
        mapping.setModifiedDate(new Date());
        toSave.add(mapping);
      }
    }
    return mappingRepository.saveAllAndFlush(toSave).stream()
        .map(PackageMasterMapper::toMapping)
        .toList();
  }

  @Override
  public Page<GroupedServiceCategoryMappingResponse> fetchGroupedMappings(
      ServiceCategoryType type, int page, int size) {
    Page<ServiceCategory> categories =
        mappingRepository.findServiceCategoriesWithActiveMappings(type, PageRequest.of(page, size));
    Map<UUID, List<ServiceCategoryMapping>> mappings =
        activeMappingsByCategory(
            categories.getContent().stream().map(ServiceCategory::getId).toList());
    return categories.map(
        sc ->
            GroupedServiceCategoryMappingResponse.builder()
                .serviceCategoryId(sc.getId())
                .serviceCategoryLegacyId(sc.getServiceCategoryId())
                .serviceName(sc.getName())
                .serviceLabel(sc.getLabel())
                .count(sc.getCount())
                .isActive(sc.getIsActive())
                .createdDate(PackageMasterMapper.toLocalDateTime(sc.getCreatedDate()))
                .serviceTypes(
                    mappings.getOrDefault(sc.getId(), List.of()).stream()
                        .map(PackageMasterMapper::toMapping)
                        .toList())
                .build());
  }

  /**
   * Checks the master-data rules shared by create and update and returns the items keyed by service
   * type id.
   */
  private Map<UUID, ServiceTypeMappingItem> validateMappingRequest(
      ServiceCategory category, List<ServiceTypeMappingItem> items) {
    Integer configuredCount = category.getCount();
    if (configuredCount == null || configuredCount == 0) {
      throw new IllegalArgumentException(
          "Service category '"
              + category.getName()
              + "' does not have a sub-service count configured. Set it before creating a mapping.");
    }
    if (items == null || items.size() != configuredCount) {
      throw new IllegalArgumentException(
          "Service category '"
              + category.getName()
              + "' requires exactly "
              + configuredCount
              + " service type(s). "
              + (items == null ? 0 : items.size())
              + " provided.");
    }
    if (items.stream().anyMatch(i -> i == null || i.getServiceTypeId() == null)) {
      throw new IllegalArgumentException("serviceTypeId is required for every mapping");
    }
    Map<UUID, ServiceTypeMappingItem> byServiceType =
        items.stream()
            .collect(
                Collectors.toMap(
                    ServiceTypeMappingItem::getServiceTypeId,
                    Function.identity(),
                    (a, b) -> {
                      throw new IllegalArgumentException(
                          "Duplicate serviceTypeId in the mapping request");
                    },
                    java.util.LinkedHashMap::new));

    Map<UUID, ServiceType> serviceTypes =
        serviceTypeRepository.findAllById(byServiceType.keySet()).stream()
            .filter(st -> Boolean.TRUE.equals(st.getIsActive()))
            .collect(Collectors.toMap(ServiceType::getId, Function.identity()));
    for (UUID serviceTypeId : byServiceType.keySet()) {
      ServiceType serviceType = serviceTypes.get(serviceTypeId);
      if (serviceType == null) {
        throw new IllegalArgumentException("Invalid serviceTypeId: " + serviceTypeId);
      }
      validateAddonServiceType(category, serviceType);
    }
    validateServiceTypeSetIsUnique(category.getId(), serviceTypes.values());
    return byServiceType;
  }

  /** An add-on service category can only be made of INTERNET. */
  private void validateAddonServiceType(ServiceCategory category, ServiceType serviceType) {
    if (Boolean.TRUE.equals(category.getIsAddon())
        && !PackageMasterMapper.INTERNET_CODE.equalsIgnoreCase(serviceType.getCode())) {
      throw new IllegalArgumentException(
          "Addon service category '"
              + category.getName()
              + "' can only be mapped to the INTERNET service type. '"
              + serviceType.getName()
              + "' is of type '"
              + serviceType.getCode()
              + "'.");
    }
  }

  /**
   * No two service categories may map to the exact same set of service types. INTERNET alone is
   * exempt: many categories legitimately map to just INTERNET (is_addon tells those apart).
   */
  private void validateServiceTypeSetIsUnique(
      UUID currentServiceCategoryId, Collection<ServiceType> requestedTypes) {
    if (requestedTypes.size() == 1
        && PackageMasterMapper.INTERNET_CODE.equalsIgnoreCase(
            requestedTypes.iterator().next().getCode())) {
      return;
    }
    Set<UUID> requested =
        requestedTypes.stream().map(ServiceType::getId).collect(Collectors.toSet());
    Map<ServiceCategory, Set<UUID>> serviceTypesByOtherCategory =
        mappingRepository.findByIsActiveTrue().stream()
            .filter(m -> !m.getServiceCategory().getId().equals(currentServiceCategoryId))
            .filter(m -> m.getServiceType() != null)
            .collect(
                Collectors.groupingBy(
                    ServiceCategoryMapping::getServiceCategory,
                    Collectors.mapping(m -> m.getServiceType().getId(), Collectors.toSet())));
    serviceTypesByOtherCategory.forEach(
        (other, types) -> {
          if (types.equals(requested)) {
            throw new IllegalArgumentException(
                "Service category '"
                    + other.getName()
                    + "' is already mapped to the exact same set of service types");
          }
        });
  }

  private void validateAddonBod(ServiceCategoryRequest request) {
    if (Boolean.TRUE.equals(request.getIsAddon()) && Boolean.TRUE.equals(request.getIsBod())) {
      throw new IllegalArgumentException("A service category cannot be both Add-On and BOD");
    }
  }

  private ServiceCategoryMapping newMapping(ServiceCategory category, ServiceTypeMappingItem item) {
    ServiceCategoryMapping mapping =
        ServiceCategoryMapping.builder()
            .serviceCategory(category)
            .serviceType(serviceTypeRepository.getReferenceById(item.getServiceTypeId()))
            .discountable(item.getDiscountable())
            .providerMapping(item.getProviderMapping())
            .isActive(true)
            .build();
    mapping.setCreatedDate(new Date());
    return mapping;
  }

  private Page<ServiceCategory> query(
      ServiceCategoryType type, String search, List<UUID> serviceTypeIds, Pageable pageable) {
    String searchParam = (search == null || search.isBlank()) ? null : search.trim();
    List<UUID> serviceTypeIdsParam = serviceTypeIds == null ? List.of() : serviceTypeIds;
    return serviceCategoryRepository.search(
        type, searchParam, !serviceTypeIdsParam.isEmpty(), serviceTypeIdsParam, pageable);
  }

  private Map<UUID, List<ServiceCategoryMapping>> activeMappingsByCategory(
      Collection<UUID> serviceCategoryIds) {
    if (serviceCategoryIds.isEmpty()) {
      return Map.of();
    }
    return mappingRepository.findByServiceCategory_IdInAndIsActiveTrue(serviceCategoryIds).stream()
        .collect(Collectors.groupingBy(m -> m.getServiceCategory().getId()));
  }

  private static Set<UUID> serviceTypeIdsOf(List<ServiceCategoryMapping> mappings) {
    return mappings.stream()
        .map(ServiceCategoryMapping::getServiceType)
        .filter(Objects::nonNull)
        .map(ServiceType::getId)
        .collect(Collectors.toSet());
  }

  private ServiceCategoryResponse toResponse(ServiceCategory sc) {
    return PackageMasterMapper.toServiceCategory(
        sc, mappingRepository.findByServiceCategory_IdAndIsActiveTrue(sc.getId()));
  }

  private ServiceCategory getServiceCategory(UUID id) {
    return serviceCategoryRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Service category not found: " + id));
  }

  private static String csvSafe(Object value) {
    if (value == null) {
      return "";
    }
    String str = value.toString();
    if (str.contains(",") || str.contains("\"") || str.contains("\n")) {
      return "\"" + str.replace("\"", "\"\"") + "\"";
    }
    return str;
  }
}
