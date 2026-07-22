package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.FormSchemaResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.FormSchemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/onboarding/form-schema")
@RequiredArgsConstructor
public class FormSchemaController {

  private final FormSchemaService service;

  /**
   * Resolves the final merged form schema for a given application and optional tenant.
   *
   * <p>When tenantId is omitted, returns the base application-level schema. When tenantId is
   * provided, applies tenant overrides on top of the application schema.
   *
   * @param appCode application code (e.g. KFON, RAILWARE)
   * @param tenantId optional tenant identifier (e.g. state code)
   */
  @GetMapping
  public ResponseEntity<Response<FormSchemaResponse>> resolveSchema(
      @RequestParam String appCode,
      @RequestParam(required = false) String tenantId) {
    var data = service.resolveFormSchema(appCode, tenantId);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Form schema resolved"));
  }
}