package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.FormFieldMasterResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.contract.TenantCustomFieldRequest;
import in.gov.kfon.dmdm.service.TenantCustomFieldService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/onboarding/tenants/{tenantId}/applications/{applicationId}/custom-fields")
@RequiredArgsConstructor
public class TenantCustomFieldController {

  private final TenantCustomFieldService service;

  @GetMapping
  public ResponseEntity<Response<List<FormFieldMasterResponse>>> fetchAll(
      @PathVariable String tenantId, @PathVariable UUID applicationId) {
    var data = service.fetchByTenantAndApplication(tenantId, applicationId);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @PostMapping
  public ResponseEntity<Response<FormFieldMasterResponse>> create(
      @PathVariable String tenantId,
      @PathVariable UUID applicationId,
      @RequestBody TenantCustomFieldRequest request) {
    var data = service.create(tenantId, applicationId, request);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(Response.created(data, "Custom field created"));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Response<FormFieldMasterResponse>> update(
      @PathVariable String tenantId,
      @PathVariable UUID applicationId,
      @PathVariable UUID id,
      @RequestBody TenantCustomFieldRequest request) {
    var data = service.update(id, request);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Custom field updated"));
  }
}