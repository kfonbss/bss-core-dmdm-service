package in.gov.kfon.dmdm.packagemaster.controller;

import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.packagemaster.constant.ServiceCategoryType;
import in.gov.kfon.dmdm.packagemaster.contract.GroupedServiceCategoryMappingResponse;
import in.gov.kfon.dmdm.packagemaster.contract.PackageLookUp;
import in.gov.kfon.dmdm.packagemaster.contract.PackageMastersBundle;
import in.gov.kfon.dmdm.packagemaster.contract.ServiceCategoryMappingRequest;
import in.gov.kfon.dmdm.packagemaster.contract.ServiceCategoryRequest;
import in.gov.kfon.dmdm.packagemaster.contract.ServiceCategoryResponse;
import in.gov.kfon.dmdm.packagemaster.contract.ServiceTypeMappingItem;
import in.gov.kfon.dmdm.packagemaster.service.PackageMasterService;
import in.gov.kfon.dmdm.packagemaster.service.ServiceCategoryService;
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
 * tenant. The /api/package/* paths, parameters and responses are the package service's own, so
 * clients only change the service they call.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PackageMasterController {

  private final PackageMasterService packageMasterService;
  private final ServiceCategoryService serviceCategoryService;

  /** Every master including inactive rows, for services that keep a local copy. */
  @GetMapping("/package-masters/bundle")
  public ResponseEntity<Response<PackageMastersBundle>> fetchBundle() {
    return ResponseEntity.ok(Response.ok(packageMasterService.fetchBundle(), "Fetched"));
  }

  @GetMapping("/package/fetch/service-types")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchServiceTypes() {
    return fetched(packageMasterService.fetchServiceTypes());
  }

  @GetMapping("/package/fetch/package-types")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchPackageTypes() {
    return fetched(packageMasterService.fetchPackageTypes());
  }

  @GetMapping("/package/fetch/sub-package-types")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchSubPackageTypes(
      @RequestParam(required = false) UUID serviceTypeId) {
    return fetched(packageMasterService.fetchSubPackageTypes(serviceTypeId));
  }

  @GetMapping("/package/fetch/plan-types")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchPlanTypes() {
    return fetched(packageMasterService.fetchPlanTypes());
  }

  @GetMapping("/package/fetch/category-types")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchCategoryTypes() {
    return fetched(packageMasterService.fetchCategoryTypes());
  }

  @GetMapping("/package/fetch/package-plan-types")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchPackagePlanTypes() {
    return fetched(packageMasterService.fetchPackagePlanTypes());
  }

  @GetMapping("/package/fetch/speed-profiles")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchSpeedProfiles() {
    return fetched(packageMasterService.fetchSpeedProfiles());
  }

  @GetMapping("/package/fetch/fallback-speeds")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchFallbackSpeeds() {
    return fetched(packageMasterService.fetchFallbackSpeeds());
  }

  @GetMapping("/package/service-category/fetch-all")
  public ResponseEntity<Response<Page<ServiceCategoryResponse>>> getServiceCategories(
      @RequestParam(required = false) ServiceCategoryType type,
      @RequestParam(required = false) String search,
      @RequestParam(required = false) List<UUID> serviceTypeIds,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    var data = serviceCategoryService.search(type, search, serviceTypeIds, page, size);
    return ResponseEntity.ok(Response.ok(data, "Service categories fetched successfully"));
  }

  @GetMapping("/package/service-category/download-csv")
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

  @GetMapping("/package/service-category/fetch-all/lookUp")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchAllServiceCategoryLookUps() {
    return fetched(serviceCategoryService.fetchLookUps());
  }

  @GetMapping("/package/service-category/fetch-all/lookUp/by-type")
  public ResponseEntity<Response<List<PackageLookUp>>> fetchServiceCategoryLookUpsByType(
      @RequestParam ServiceCategoryType type) {
    return fetched(serviceCategoryService.fetchLookUpsByType(type));
  }

  @PostMapping("/package/service-category/save")
  public ResponseEntity<Response<ServiceCategoryResponse>> saveServiceCategory(
      @Valid @RequestBody ServiceCategoryRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(Response.created(serviceCategoryService.create(request), "Service category created"));
  }

  @PutMapping("/package/service-category/update/{id}")
  public ResponseEntity<Response<ServiceCategoryResponse>> updateServiceCategory(
      @PathVariable UUID id, @Valid @RequestBody ServiceCategoryRequest request) {
    return ResponseEntity.ok(Response.ok(serviceCategoryService.update(id, request), "Updated"));
  }

  @GetMapping("/package/service-category/fetch/{id}")
  public ResponseEntity<Response<ServiceCategoryResponse>> fetchServiceCategoryById(
      @PathVariable UUID id) {
    return fetched(serviceCategoryService.fetchById(id));
  }

  @GetMapping("/package/service-category/by-service-types")
  public ResponseEntity<Response<List<ServiceCategoryResponse>>> getServiceCategoryByServiceTypes(
      @RequestParam List<UUID> serviceTypeIds) {
    return fetched(serviceCategoryService.fetchByServiceTypes(serviceTypeIds));
  }

  @PostMapping("/package/service-category/mapping/save")
  public ResponseEntity<Response<Void>> mapServiceCategory(
      @Valid @RequestBody ServiceCategoryMappingRequest request) {
    serviceCategoryService.createMappings(request);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(Response.created(null, "Mapping created"));
  }

  @PutMapping("/package/service-category/mapping/update/{serviceCategoryId}")
  public ResponseEntity<Response<Void>> updateServiceCategoryMappings(
      @PathVariable UUID serviceCategoryId,
      @RequestBody List<ServiceTypeMappingItem> serviceTypeMappings) {
    serviceCategoryService.updateMappings(serviceCategoryId, serviceTypeMappings);
    return ResponseEntity.ok(Response.ok(null, "Mappings updated successfully"));
  }

  @GetMapping("/package/service-category/mapping/fetch-all")
  public ResponseEntity<Response<Page<GroupedServiceCategoryMappingResponse>>> fetchAllMappings(
      @RequestParam(required = false) ServiceCategoryType type,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    var data = serviceCategoryService.fetchGroupedMappings(type, page, size);
    return ResponseEntity.ok(Response.ok(data, "Service mappings fetched successfully"));
  }

  private static <T> ResponseEntity<Response<T>> fetched(T data) {
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }
}
