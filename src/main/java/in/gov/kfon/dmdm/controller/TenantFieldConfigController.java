package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.ApplicationFieldConfigResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.contract.TenantFieldConfigRequest;
import in.gov.kfon.dmdm.service.TenantFieldConfigService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/onboarding/tenants/{tenantId}/applications/{applicationId}/field-config")
@RequiredArgsConstructor
public class TenantFieldConfigController {

  private final TenantFieldConfigService service;

  @GetMapping
  public ResponseEntity<Response<List<ApplicationFieldConfigResponse>>> fetchByTenantAndApplication(
      @PathVariable String tenantId, @PathVariable UUID applicationId) {
    var data = service.fetchByTenantAndApplication(tenantId, applicationId);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @PostMapping
  public ResponseEntity<Response<ApplicationFieldConfigResponse>> upsert(
      @PathVariable String tenantId,
      @PathVariable UUID applicationId,
      @RequestBody TenantFieldConfigRequest request) {
    var data = service.upsert(tenantId, applicationId, request);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Tenant field config saved"));
  }

  @PostMapping("/bulk")
  public ResponseEntity<Response<List<ApplicationFieldConfigResponse>>> bulkUpsert(
      @PathVariable String tenantId,
      @PathVariable UUID applicationId,
      @RequestBody List<TenantFieldConfigRequest> requests) {
    var data = service.bulkUpsert(tenantId, applicationId, requests);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Bulk tenant field config saved"));
  }
}