package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.ResolvedFormResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.FormResolverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/form")
@RequiredArgsConstructor
public class FormResolverController {

  private final FormResolverService resolverService;

  /**
   * Resolves the final merged form schema for a given app + tenant + form type.
   *
   * <p>Example: GET /api/form/resolve/SUBSCRIBER_ONBOARDING?appCode=RAILWARE&tenantId=KERALA
   */
  @GetMapping("/resolve/{formType}")
  public ResponseEntity<Response<ResolvedFormResponse>> resolve(
      @PathVariable String formType,
      @RequestParam String appCode,
      @RequestParam(required = false) String tenantId) {
    var data = resolverService.resolve(appCode, tenantId, formType);
    return ResponseEntity.ok(Response.ok(data, "Resolved"));
  }
}
