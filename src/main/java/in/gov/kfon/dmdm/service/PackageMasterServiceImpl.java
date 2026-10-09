package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.MasterTypeResponse;
import in.gov.kfon.dmdm.contract.PackageMastersBundle;
import in.gov.kfon.dmdm.contract.PackagePlanTypeResponse;
import in.gov.kfon.dmdm.contract.ServiceTypeResponse;
import in.gov.kfon.dmdm.contract.SpeedResponse;
import in.gov.kfon.dmdm.contract.SubPackageTypeResponse;
import in.gov.kfon.dmdm.model.ServiceCategoryMapping;
import in.gov.kfon.dmdm.repository.CategoryTypeRepository;
import in.gov.kfon.dmdm.repository.FallbackSpeedRepository;
import in.gov.kfon.dmdm.repository.PackagePlanTypeRepository;
import in.gov.kfon.dmdm.repository.PackageTypeRepository;
import in.gov.kfon.dmdm.repository.PlanTypeRepository;
import in.gov.kfon.dmdm.repository.ServiceCategoryMappingRepository;
import in.gov.kfon.dmdm.repository.ServiceCategoryRepository;
import in.gov.kfon.dmdm.repository.ServiceTypeRepository;
import in.gov.kfon.dmdm.repository.SpeedProfileRepository;
import in.gov.kfon.dmdm.repository.SubPackageTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PackageMasterServiceImpl implements PackageMasterService {

  private final ServiceTypeRepository serviceTypeRepository;
  private final SubPackageTypeRepository subPackageTypeRepository;
  private final PackageTypeRepository packageTypeRepository;
  private final PlanTypeRepository planTypeRepository;
  private final CategoryTypeRepository categoryTypeRepository;
  private final PackagePlanTypeRepository packagePlanTypeRepository;
  private final SpeedProfileRepository speedProfileRepository;
  private final FallbackSpeedRepository fallbackSpeedRepository;
  private final ServiceCategoryRepository serviceCategoryRepository;
  private final ServiceCategoryMappingRepository serviceCategoryMappingRepository;

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTERS_BUNDLE, key = "'all'")
  public PackageMastersBundle fetchBundle() {
    List<ServiceCategoryMapping> mappings = serviceCategoryMappingRepository.findAll();
    Map<UUID, List<ServiceCategoryMapping>> activeMappingsByCategory =
        mappings.stream()
            .filter(m -> Boolean.TRUE.equals(m.getIsActive()))
            .collect(Collectors.groupingBy(m -> m.getServiceCategory().getId()));

    return PackageMastersBundle.builder()
        .serviceTypes(
            serviceTypeRepository.findAll().stream()
                .sorted(
                    Comparator.comparing(
                        st -> st.getTypeId(), Comparator.nullsLast(Comparator.naturalOrder())))
                .map(PackageMasterMapper::toServiceType)
                .toList())
        .subPackageTypes(
            subPackageTypeRepository.findAllByOrderBySubPackageTypeIdAsc().stream()
                .map(PackageMasterMapper::toSubPackageType)
                .toList())
        .packageTypes(fetchPackageTypes())
        .planTypes(fetchPlanTypes())
        .categoryTypes(fetchCategoryTypes())
        .packagePlanTypes(fetchPackagePlanTypes())
        .speedProfiles(
            speedProfileRepository.findAllByOrderBySpeedMbAsc().stream()
                .map(PackageMasterMapper::toSpeed)
                .toList())
        .fallbackSpeeds(
            fallbackSpeedRepository.findAllByOrderBySpeedMbAsc().stream()
                .map(PackageMasterMapper::toSpeed)
                .toList())
        .serviceCategories(
            serviceCategoryRepository.findAll().stream()
                .map(
                    sc ->
                        PackageMasterMapper.toServiceCategory(
                            sc, activeMappingsByCategory.getOrDefault(sc.getId(), List.of())))
                .toList())
        .serviceCategoryMappings(mappings.stream().map(PackageMasterMapper::toMapping).toList())
        .build();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_SERVICE_TYPES, key = "'active'")
  public List<ServiceTypeResponse> fetchServiceTypes() {
    return serviceTypeRepository.findAllByIsActiveTrueOrderByTypeIdAsc().stream()
        .map(PackageMasterMapper::toServiceType)
        .toList();
  }

  @Override
  public ServiceTypeResponse fetchServiceTypeById(UUID id) {
    return serviceTypeRepository
        .findById(id)
        .map(PackageMasterMapper::toServiceType)
        .orElseThrow(() -> new EntityNotFoundException("Service type not found: " + id));
  }

  @Override
  @Cacheable(
      cacheNames = CacheNames.PACKAGE_MASTER_SUB_PACKAGE_TYPES,
      key = "#serviceTypeId == null ? 'all' : #serviceTypeId.toString()")
  public List<SubPackageTypeResponse> fetchSubPackageTypes(UUID serviceTypeId) {
    if (serviceTypeId == null) {
      return subPackageTypeRepository.findAllByOrderBySubPackageTypeIdAsc().stream()
          .map(PackageMasterMapper::toSubPackageType)
          .toList();
    }
    serviceTypeRepository
        .findByIdAndIsActiveTrue(serviceTypeId)
        .orElseThrow(() -> new IllegalArgumentException("Invalid serviceTypeId"));
    return subPackageTypeRepository
        .findByServiceTypeMaster_IdOrderBySubPackageTypeIdAsc(serviceTypeId)
        .stream()
        .map(PackageMasterMapper::toSubPackageType)
        .toList();
  }

  @Override
  public SubPackageTypeResponse fetchSubPackageTypeById(UUID id) {
    return subPackageTypeRepository
        .findById(id)
        .map(PackageMasterMapper::toSubPackageType)
        .orElseThrow(() -> new EntityNotFoundException("Sub-package type not found: " + id));
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_PACKAGE_TYPES, key = "'all'")
  public List<MasterTypeResponse> fetchPackageTypes() {
    return packageTypeRepository.findAllByOrderByPackageTypeIdAsc().stream()
        .map(PackageMasterMapper::toMasterType)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_PLAN_TYPES, key = "'all'")
  public List<MasterTypeResponse> fetchPlanTypes() {
    return planTypeRepository.findAllByOrderByPlanTypeIdAsc().stream()
        .map(PackageMasterMapper::toMasterType)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_CATEGORY_TYPES, key = "'all'")
  public List<MasterTypeResponse> fetchCategoryTypes() {
    return categoryTypeRepository.findAllByOrderByCategoryTypeIdAsc().stream()
        .map(PackageMasterMapper::toMasterType)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_PACKAGE_PLAN_TYPES, key = "'all'")
  public List<PackagePlanTypeResponse> fetchPackagePlanTypes() {
    return packagePlanTypeRepository.findAllByOrderByPackagePlanTypeIdAsc().stream()
        .map(PackageMasterMapper::toPackagePlanType)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_SPEED_PROFILES, key = "'active'")
  public List<SpeedResponse> fetchSpeedProfiles() {
    return speedProfileRepository.findByIsActiveTrueOrderBySpeedMbAsc().stream()
        .map(PackageMasterMapper::toSpeed)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_FALLBACK_SPEEDS, key = "'active'")
  public List<SpeedResponse> fetchFallbackSpeeds() {
    return fallbackSpeedRepository.findByIsActiveTrueOrderBySpeedMbAsc().stream()
        .map(PackageMasterMapper::toSpeed)
        .toList();
  }
}
