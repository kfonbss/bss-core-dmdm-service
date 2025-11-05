package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.PackageService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/package")
@RequiredArgsConstructor
public class PackageController {

  private final PackageService service;

  @GetMapping("/maps/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPackageMaps() {
    var data = service.fetchAllPackageMaps();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all package maps"));
  }

  @GetMapping("/map/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPackageMapById(@PathVariable UUID id) {
    var data = service.fetchPackageMapById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched package map"));
  }

  @GetMapping("/categories/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPackageCategories() {
    var data = service.fetchAllPackageCategories();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all package categories"));
  }

  @GetMapping("/category/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPackageCategoryById(@PathVariable UUID id) {
    var data = service.fetchPackageCategoryById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched package category"));
  }

  @GetMapping("/change-requests/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllChangeRequests() {
    var data = service.fetchAllChangeRequests();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all change requests"));
  }

  @GetMapping("/change-request/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchChangeRequestById(@PathVariable UUID id) {
    var data = service.fetchChangeRequestById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched change request"));
  }

  @GetMapping("/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPackages() {
    var data = service.fetchAllPackages();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all packages"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPackageById(@PathVariable UUID id) {
    var data = service.fetchPackagesById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched package"));
  }

  @GetMapping("/entities/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPackageEntities() {
    var data = service.fetchAllPackage();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all package entities"));
  }

  @GetMapping("/entity/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPackageEntityById(@PathVariable UUID id) {
    var data = service.fetchPackageById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched package entity"));
  }
}
