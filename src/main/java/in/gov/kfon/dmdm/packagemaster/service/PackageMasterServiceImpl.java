package in.gov.kfon.dmdm.packagemaster.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.packagemaster.contract.PackageLookUp;
import in.gov.kfon.dmdm.packagemaster.contract.PackageMastersBundle;
import in.gov.kfon.dmdm.packagemaster.model.ServiceCategoryMapping;
import in.gov.kfon.dmdm.packagemaster.repository.CategoryTypeRepository;
import in.gov.kfon.dmdm.packagemaster.repository.FallbackSpeedRepository;
import in.gov.kfon.dmdm.packagemaster.repository.PackagePlanTypeRepository;
import in.gov.kfon.dmdm.packagemaster.repository.PackageTypeRepository;
import in.gov.kfon.dmdm.packagemaster.repository.PlanTypeRepository;
import in.gov.kfon.dmdm.packagemaster.repository.ServiceCategoryMappingRepository;
import in.gov.kfon.dmdm.packagemaster.repository.ServiceCategoryRepository;
import in.gov.kfon.dmdm.packagemaster.repository.ServiceTypeRepository;
import in.gov.kfon.dmdm.packagemaster.repository.SpeedProfileRepository;
import in.gov.kfon.dmdm.packagemaster.repository.SubPackageTypeRepository;
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
        .packageTypes(
            packageTypeRepository.findAllByOrderByPackageTypeIdAsc().stream()
                .map(PackageMasterMapper::toMasterType)
                .toList())
        .planTypes(
            planTypeRepository.findAllByOrderByPlanTypeIdAsc().stream()
                .map(PackageMasterMapper::toMasterType)
                .toList())
        .categoryTypes(
            categoryTypeRepository.findAllByOrderByCategoryTypeIdAsc().stream()
                .map(PackageMasterMapper::toMasterType)
                .toList())
        .packagePlanTypes(
            packagePlanTypeRepository.findAllByOrderByPackagePlanTypeIdAsc().stream()
                .map(PackageMasterMapper::toPackagePlanType)
                .toList())
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
  public List<PackageLookUp> fetchServiceTypes() {
    return serviceTypeRepository.findAllByIsActiveTrueOrderByTypeIdAsc().stream()
        .map(PackageMasterMapper::toLookUp)
        .toList();
  }

  @Override
  @Cacheable(
      cacheNames = CacheNames.PACKAGE_MASTER_SUB_PACKAGE_TYPES,
      key = "#serviceTypeId == null ? 'all' : #serviceTypeId.toString()")
  public List<PackageLookUp> fetchSubPackageTypes(UUID serviceTypeId) {
    if (serviceTypeId == null) {
      return subPackageTypeRepository.findAllByOrderBySubPackageTypeIdAsc().stream()
          .map(PackageMasterMapper::toLookUp)
          .toList();
    }
    serviceTypeRepository
        .findByIdAndIsActiveTrue(serviceTypeId)
        .orElseThrow(() -> new IllegalArgumentException("Invalid serviceTypeId"));
    return subPackageTypeRepository
        .findByServiceTypeMaster_IdOrderBySubPackageTypeIdAsc(serviceTypeId)
        .stream()
        .map(PackageMasterMapper::toLookUp)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_PACKAGE_TYPES, key = "'all'")
  public List<PackageLookUp> fetchPackageTypes() {
    return packageTypeRepository.findAllByOrderByPackageTypeIdAsc().stream()
        .map(PackageMasterMapper::toLookUp)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_PLAN_TYPES, key = "'all'")
  public List<PackageLookUp> fetchPlanTypes() {
    return planTypeRepository.findAllByOrderByPlanTypeIdAsc().stream()
        .map(PackageMasterMapper::toLookUp)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_CATEGORY_TYPES, key = "'all'")
  public List<PackageLookUp> fetchCategoryTypes() {
    return categoryTypeRepository.findAllByOrderByCategoryTypeIdAsc().stream()
        .map(PackageMasterMapper::toLookUp)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_PACKAGE_PLAN_TYPES, key = "'all'")
  public List<PackageLookUp> fetchPackagePlanTypes() {
    return packagePlanTypeRepository.findAllByOrderByPackagePlanTypeIdAsc().stream()
        .map(PackageMasterMapper::toLookUp)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_SPEED_PROFILES, key = "'active'")
  public List<PackageLookUp> fetchSpeedProfiles() {
    return speedProfileRepository.findByIsActiveTrueOrderBySpeedMbAsc().stream()
        .map(PackageMasterMapper::toLookUp)
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PACKAGE_MASTER_FALLBACK_SPEEDS, key = "'active'")
  public List<PackageLookUp> fetchFallbackSpeeds() {
    return fallbackSpeedRepository.findByIsActiveTrueOrderBySpeedMbAsc().stream()
        .map(PackageMasterMapper::toLookUp)
        .toList();
  }
}
