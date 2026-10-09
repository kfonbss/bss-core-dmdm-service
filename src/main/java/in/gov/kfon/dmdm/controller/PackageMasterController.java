package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.constant.ServiceCategoryType;
import in.gov.kfon.dmdm.contract.GroupedServiceCategoryMappingResponse;
import in.gov.kfon.dmdm.contract.MasterTypeResponse;
import in.gov.kfon.dmdm.contract.PackageMastersBundle;
import in.gov.kfon.dmdm.contract.PackagePlanTypeResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.contract.ServiceCategoryLookUp;
import in.gov.kfon.dmdm.contract.ServiceCategoryMappingRequest;
import in.gov.kfon.dmdm.contract.ServiceCategoryMappingResponse;
import in.gov.kfon.dmdm.contract.ServiceCategoryRequest;
import in.gov.kfon.dmdm.contract.ServiceCategoryResponse;
import in.gov.kfon.dmdm.contract.ServiceTypeMappingItem;
import in.gov.kfon.dmdm.contract.ServiceTypeResponse;
import in.gov.kfon.dmdm.contract.SpeedResponse;
import in.gov.kfon.dmdm.contract.SubPackageTypeResponse;
import in.gov.kfon.dmdm.service.PackageMasterService;
import in.gov.kfon.dmdm.service.ServiceCategoryService;
import jakarta.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package masters, moved here from bss-package-management-services. Global — the same for every
 * tenant.
 */
@RestController
@RequestMapping("/api/package-masters")
@RequiredArgsConstructor
public class PackageMasterController {

  private final PackageMasterService packageMasterService;
  private final ServiceCategoryService serviceCategoryService;

  @GetMapping("/bundle")
  public ResponseEntity<Response<PackageMastersBundle>> fetchBundle() {
    return ok(packageMasterService.fetchBundle(), "Fetched package masters");
  }

  @GetMapping("/service-types")
  public ResponseEntity<Response<List<ServiceTypeResponse>>> fetchServiceTypes() {
    return ok(packageMasterService.fetchServiceTypes(), "Fetched service types");
  }

  @GetMapping("/service-types/{id}")
  public ResponseEntity<Response<ServiceTypeResponse>> fetchServiceType(@PathVariable UUID id) {
    return ok(packageMasterService.fetchServiceTypeById(id), "Fetched service type");
  }

  @GetMapping("/sub-package-types")
  public ResponseEntity<Response<List<SubPackageTypeResponse>>> fetchSubPackageTypes(
      @RequestParam(required = false) UUID serviceTypeId) {
    return ok(
        packageMasterService.fetchSubPackageTypes(serviceTypeId), "Fetched sub package types");
  }

  @GetMapping("/sub-package-types/{id}")
  public ResponseEntity<Response<SubPackageTypeResponse>> fetchSubPackageType(
      @PathVariable UUID id) {
    return ok(packageMasterService.fetchSubPackageTypeById(id), "Fetched sub package type");
  }

  @GetMapping("/package-types")
  public ResponseEntity<Response<List<MasterTypeResponse>>> fetchPackageTypes() {
    return ok(packageMasterService.fetchPackageTypes(), "Fetched package types");
  }

  @GetMapping("/plan-types")
  public ResponseEntity<Response<List<MasterTypeResponse>>> fetchPlanTypes() {
    return ok(packageMasterService.fetchPlanTypes(), "Fetched plan types");
  }

  @GetMapping("/category-types")
  public ResponseEntity<Response<List<MasterTypeResponse>>> fetchCategoryTypes() {
    return ok(packageMasterService.fetchCategoryTypes(), "Fetched category types");
  }

  @GetMapping("/package-plan-types")
  public ResponseEntity<Response<List<PackagePlanTypeResponse>>> fetchPackagePlanTypes() {
    return ok(packageMasterService.fetchPackagePlanTypes(), "Fetched package plan types");
  }

  @GetMapping("/speed-profiles")
  public ResponseEntity<Response<List<SpeedResponse>>> fetchSpeedProfiles() {
    return ok(packageMasterService.fetchSpeedProfiles(), "Fetched speed profiles");
  }

  @GetMapping("/fallback-speeds")
  public ResponseEntity<Response<List<SpeedResponse>>> fetchFallbackSpeeds() {
    return ok(packageMasterService.fetchFallbackSpeeds(), "Fetched fallback speeds");
  }

  @GetMapping("/service-categories")
  public ResponseEntity<Response<Page<ServiceCategoryResponse>>> searchServiceCategories(
      @RequestParam(required = false) ServiceCategoryType type,
      @RequestParam(required = false) String search,
      @RequestParam(required = false) List<UUID> serviceTypeIds,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    return ok(
        serviceCategoryService.search(type, search, serviceTypeIds, page, size),
        "Fetched service categories");
  }

  @GetMapping("/service-categories/download-csv")
  public ResponseEntity<byte[]> downloadServiceCategoriesCsv(
      @RequestParam(required = false) ServiceCategoryType type,
      @RequestParam(required = false) String search,
      @RequestParam(required = false) List<UUID> serviceTypeIds) {
    byte[] body =
        serviceCategoryService
            .exportCsv(type, search, serviceTypeIds)
            .getBytes(StandardCharsets.UTF_8);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=service_categories.csv")
        .contentType(MediaType.parseMediaType("text/csv"))
        .body(body);
  }

  @GetMapping("/service-categories/lookup")
  public ResponseEntity<Response<List<ServiceCategoryLookUp>>> fetchServiceCategoryLookUps(
      @RequestParam(required = false) ServiceCategoryType type) {
    var data =
        type == null
            ? serviceCategoryService.fetchLookUps()
            : serviceCategoryService.fetchLookUpsByType(type);
    return ok(data, "Fetched service category lookups");
  }

  @GetMapping("/service-categories/by-service-types")
  public ResponseEntity<Response<List<ServiceCategoryResponse>>> fetchByServiceTypes(
      @RequestParam List<UUID> serviceTypeIds) {
    return ok(
        serviceCategoryService.fetchByServiceTypes(serviceTypeIds), "Fetched service categories");
  }

  @GetMapping("/service-categories/{id}")
  public ResponseEntity<Response<ServiceCategoryResponse>> fetchServiceCategory(
      @PathVariable UUID id) {
    return ok(serviceCategoryService.fetchById(id), "Fetched service category");
  }

  @PostMapping("/service-categories")
  public ResponseEntity<Response<ServiceCategoryResponse>> createServiceCategory(
      @Valid @RequestBody ServiceCategoryRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(Response.created(serviceCategoryService.create(request), "Service category created"));
  }

  @PutMapping("/service-categories/{id}")
  public ResponseEntity<Response<ServiceCategoryResponse>> updateServiceCategory(
      @PathVariable UUID id, @Valid @RequestBody ServiceCategoryRequest request) {
    return ok(serviceCategoryService.update(id, request), "Service category updated");
  }

  @GetMapping("/service-categories/{id}/service-types")
  public ResponseEntity<Response<List<ServiceCategoryMappingResponse>>> fetchMappings(
      @PathVariable UUID id) {
    return ok(serviceCategoryService.fetchMappings(id), "Fetched service types of category");
  }

  @GetMapping("/service-category-mappings")
  public ResponseEntity<Response<Page<GroupedServiceCategoryMappingResponse>>> fetchGroupedMappings(
      @RequestParam(required = false) ServiceCategoryType type,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    return ok(
        serviceCategoryService.fetchGroupedMappings(type, page, size),
        "Fetched service category mappings");
  }

  @PostMapping("/service-category-mappings")
  public ResponseEntity<Response<List<ServiceCategoryMappingResponse>>> createMappings(
      @Valid @RequestBody ServiceCategoryMappingRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            Response.created(
                serviceCategoryService.createMappings(request), "Service category mapped"));
  }

  @PutMapping("/service-category-mappings/{serviceCategoryId}")
  public ResponseEntity<Response<List<ServiceCategoryMappingResponse>>> updateMappings(
      @PathVariable UUID serviceCategoryId,
      @RequestBody List<ServiceTypeMappingItem> serviceTypeMappings) {
    return ok(
        serviceCategoryService.updateMappings(serviceCategoryId, serviceTypeMappings),
        "Service category mapping updated");
  }

  private static <T> ResponseEntity<Response<T>> ok(T data, String message) {
    return ResponseEntity.ok(Response.ok(data, message));
  }
}
