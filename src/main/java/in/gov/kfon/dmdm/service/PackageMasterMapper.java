package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.MasterTypeResponse;
import in.gov.kfon.dmdm.contract.PackagePlanTypeResponse;
import in.gov.kfon.dmdm.contract.ServiceCategoryMappingResponse;
import in.gov.kfon.dmdm.contract.ServiceCategoryResponse;
import in.gov.kfon.dmdm.contract.ServiceTypeResponse;
import in.gov.kfon.dmdm.contract.SpeedResponse;
import in.gov.kfon.dmdm.contract.SubPackageTypeResponse;
import in.gov.kfon.dmdm.model.CategoryType;
import in.gov.kfon.dmdm.model.FallbackSpeed;
import in.gov.kfon.dmdm.model.PackagePlanType;
import in.gov.kfon.dmdm.model.PackageType;
import in.gov.kfon.dmdm.model.PlanType;
import in.gov.kfon.dmdm.model.ServiceCategory;
import in.gov.kfon.dmdm.model.ServiceCategoryMapping;
import in.gov.kfon.dmdm.model.ServiceType;
import in.gov.kfon.dmdm.model.SpeedProfile;
import in.gov.kfon.dmdm.model.SubPackageType;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/** Entity -> response conversions for the package masters. */
final class PackageMasterMapper {

  static final String INTERNET_CODE = "INTERNET";

  private PackageMasterMapper() {}

  static ServiceTypeResponse toServiceType(ServiceType st) {
    return ServiceTypeResponse.builder()
        .id(st.getId())
        .typeId(st.getTypeId())
        .code(st.getCode())
        .name(st.getName())
        .nameInLocal(st.getNameInLocal())
        .isActive(st.getIsActive())
        .requiresRCode(!INTERNET_CODE.equalsIgnoreCase(st.getCode()))
        .build();
  }

  static SubPackageTypeResponse toSubPackageType(SubPackageType spt) {
    return SubPackageTypeResponse.builder()
        .id(spt.getId())
        .subPackageTypeId(spt.getSubPackageTypeId())
        .code(spt.getCode())
        .name(spt.getName())
        .nameInLocal(spt.getNameInLocal())
        .isActive(spt.getIsActive())
        .serviceType(spt.getServiceType())
        .serviceTypeId(
            spt.getServiceTypeMaster() != null ? spt.getServiceTypeMaster().getId() : null)
        .disbBefore(spt.getDisbBefore())
        .disbAfter(spt.getDisbAfter())
        .invoiceReport(spt.getInvoiceReport())
        .disburseReport(spt.getDisburseReport())
        .build();
  }

  static MasterTypeResponse toMasterType(PackageType t) {
    return masterType(
        t.getId(),
        t.getPackageTypeId(),
        t.getCode(),
        t.getName(),
        t.getNameInLocal(),
        t.getIsActive());
  }

  static MasterTypeResponse toMasterType(PlanType t) {
    return masterType(
        t.getId(),
        t.getPlanTypeId(),
        t.getCode(),
        t.getName(),
        t.getNameInLocal(),
        t.getIsActive());
  }

  static MasterTypeResponse toMasterType(CategoryType t) {
    return masterType(
        t.getId(),
        t.getCategoryTypeId(),
        t.getCode(),
        t.getName(),
        t.getNameInLocal(),
        t.getIsActive());
  }

  private static MasterTypeResponse masterType(
      java.util.UUID id,
      Integer intId,
      String code,
      String name,
      String nameInLocal,
      Boolean isActive) {
    return MasterTypeResponse.builder()
        .id(id)
        .intId(intId)
        .code(code)
        .name(name)
        .nameInLocal(nameInLocal)
        .isActive(isActive)
        .build();
  }

  static PackagePlanTypeResponse toPackagePlanType(PackagePlanType t) {
    CategoryType category = t.getCategoryType();
    return PackagePlanTypeResponse.builder()
        .id(t.getId())
        .intId(t.getPackagePlanTypeId())
        .code(t.getCode())
        .name(t.getName())
        .nameInLocal(t.getNameInLocal())
        .isActive(t.getIsActive())
        .categoryTypeId(category != null ? category.getId() : null)
        .categoryTypeCode(category != null ? category.getCode() : null)
        .build();
  }

  static SpeedResponse toSpeed(SpeedProfile sp) {
    return SpeedResponse.builder()
        .id(sp.getId())
        .code(sp.getSpeedProfileId())
        .name(sp.getName())
        .speedMb(sp.getSpeedMb())
        .isActive(sp.getIsActive())
        .build();
  }

  static SpeedResponse toSpeed(FallbackSpeed fs) {
    return SpeedResponse.builder()
        .id(fs.getId())
        .code(fs.getFallbackSpeedId())
        .name(fs.getName())
        .speedMb(fs.getSpeedMb())
        .isActive(fs.getIsActive())
        .build();
  }

  static ServiceCategoryMappingResponse toMapping(ServiceCategoryMapping m) {
    ServiceType st = m.getServiceType();
    return ServiceCategoryMappingResponse.builder()
        .mappingRowId(m.getId())
        .mappingId(m.getMappingId())
        .serviceCategoryId(m.getServiceCategory().getId())
        .serviceTypeId(st != null ? st.getId() : null)
        .serviceTypeIntId(st != null ? st.getTypeId() : null)
        .serviceTypeName(st != null ? st.getName() : null)
        .serviceTypeCode(st != null ? st.getCode() : null)
        .discountable(m.getDiscountable())
        .providerMapping(m.getProviderMapping())
        .isActive(m.getIsActive())
        .build();
  }

  /**
   * @param activeMappings this category's active mappings; drive both {@code serviceTypes} and the
   *     generated description
   */
  static ServiceCategoryResponse toServiceCategory(
      ServiceCategory sc, List<ServiceCategoryMapping> activeMappings) {
    return ServiceCategoryResponse.builder()
        .id(sc.getId())
        .serviceCategoryId(sc.getServiceCategoryId())
        .name(sc.getName())
        .label(sc.getLabel())
        .count(sc.getCount())
        .bundleType(sc.getBundleType())
        .isAddon(sc.getIsAddon())
        .isBod(sc.getIsBod())
        .active(sc.getIsActive())
        .serviceCategoryType(sc.getServiceCategoryType())
        .serviceTypes(
            activeMappings.stream()
                .map(ServiceCategoryMapping::getServiceType)
                .filter(Objects::nonNull)
                .map(PackageMasterMapper::toServiceType)
                .toList())
        .createdDate(toLocalDateTime(sc.getCreatedDate()))
        .description(describe(sc, activeMappings))
        .build();
  }

  /** Human-readable summary of a service category, e.g. "This is an Internet and OTT service". */
  static String describe(ServiceCategory sc, List<ServiceCategoryMapping> activeMappings) {
    if (Boolean.TRUE.equals(sc.getIsBod())) {
      return "This is a Bandwidth on Demand (BOD) service";
    }

    List<String> serviceTypeNames =
        activeMappings.stream()
            .map(ServiceCategoryMapping::getServiceType)
            .filter(Objects::nonNull)
            .map(ServiceType::getName)
            .distinct()
            .sorted()
            .toList();

    if (serviceTypeNames.isEmpty()) {
      return sc.getLabel() != null ? sc.getLabel() : sc.getName();
    }

    String joined =
        serviceTypeNames.size() == 1
            ? serviceTypeNames.get(0)
            : String.join(", ", serviceTypeNames.subList(0, serviceTypeNames.size() - 1))
                + " and "
                + serviceTypeNames.get(serviceTypeNames.size() - 1);

    if (Boolean.TRUE.equals(sc.getIsAddon())) {
      return "This is an add-on " + joined + " service";
    }
    String article = joined.matches("(?i)[AEIOU].*") ? "an" : "a";
    return "This is " + article + " " + joined + " service";
  }

  static LocalDateTime toLocalDateTime(Date date) {
    return date == null ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }
}
