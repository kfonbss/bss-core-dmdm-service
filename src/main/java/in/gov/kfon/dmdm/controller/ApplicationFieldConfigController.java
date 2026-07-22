package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.ApplicationFieldConfigRequest;
import in.gov.kfon.dmdm.contract.ApplicationFieldConfigResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.ApplicationFieldConfigService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/onboarding/applications/{applicationId}/field-config")
@RequiredArgsConstructor
public class ApplicationFieldConfigController {

  private final ApplicationFieldConfigService service;

  @GetMapping
  public ResponseEntity<Response<List<ApplicationFieldConfigResponse>>> fetchByApplication(
      @PathVariable UUID applicationId) {
    var data = service.fetchByApplication(applicationId);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @PostMapping
  public ResponseEntity<Response<ApplicationFieldConfigResponse>> upsert(
      @PathVariable UUID applicationId, @RequestBody ApplicationFieldConfigRequest request) {
    var data = service.upsert(applicationId, request);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Field config saved"));
  }

  @PostMapping("/bulk")
  public ResponseEntity<Response<List<ApplicationFieldConfigResponse>>> bulkUpsert(
      @PathVariable UUID applicationId,
      @RequestBody List<ApplicationFieldConfigRequest> requests) {
    var data = service.bulkUpsert(applicationId, requests);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Bulk field config saved"));
  }
}