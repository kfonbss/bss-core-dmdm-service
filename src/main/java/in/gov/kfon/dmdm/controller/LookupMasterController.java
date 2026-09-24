package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.LookupMasterRequest;
import in.gov.kfon.dmdm.contract.LookupMasterResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.LookupMasterService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lookup")
@RequiredArgsConstructor
public class LookupMasterController {

  private final LookupMasterService service;

  @PostMapping
  public ResponseEntity<Response<LookupMasterResponse>> create(
      @RequestBody LookupMasterRequest request) {
    var data = service.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(Response.created(data, "Lookup created"));
  }

  /**
   * Fetches lookup values merged across global → app → tenant layers.
   *
   * <p>Example: GET /api/lookup/GATEWAY?appCode=RAILWARE&tenantId=KERALA
   */
  @GetMapping("/{lookupType}")
  public ResponseEntity<Response<List<LookupMasterResponse>>> fetchByType(
      @PathVariable String lookupType,
      @RequestParam(required = false) String appCode,
      @RequestParam(required = false) String tenantId) {
    var data = service.fetchByType(lookupType, appCode, tenantId);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }
}
