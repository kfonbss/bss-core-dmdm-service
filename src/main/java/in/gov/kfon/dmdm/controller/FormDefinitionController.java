package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.FormDefinitionFieldRequest;
import in.gov.kfon.dmdm.contract.FormDefinitionFieldResponse;
import in.gov.kfon.dmdm.contract.FormDefinitionRequest;
import in.gov.kfon.dmdm.contract.FormDefinitionResponse;
import in.gov.kfon.dmdm.contract.FormSectionRequest;
import in.gov.kfon.dmdm.contract.FormSectionResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.FormDefinitionFieldService;
import in.gov.kfon.dmdm.service.FormDefinitionService;
import in.gov.kfon.dmdm.service.FormSectionService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/form-definitions")
@RequiredArgsConstructor
public class FormDefinitionController {

  private final FormDefinitionService definitionService;
  private final FormSectionService sectionService;
  private final FormDefinitionFieldService fieldService;

  // ── Form Definition ──────────────────────────────────────────────────────

  @PostMapping
  public ResponseEntity<Response<FormDefinitionResponse>> create(
      @RequestBody FormDefinitionRequest request) {
    var data = definitionService.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(Response.created(data, "Form definition created"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<FormDefinitionResponse>> fetchById(@PathVariable UUID id) {
    var data = definitionService.fetchById(id);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }

  @GetMapping
  public ResponseEntity<Response<List<FormDefinitionResponse>>> fetchAll(
      @RequestParam(required = false) UUID applicationId,
      @RequestParam(required = false) String tenantId,
      @RequestParam(required = false) String formType) {
    var data = definitionService.fetchAll(applicationId, tenantId, formType);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }

  @PatchMapping("/{id}/activate")
  public ResponseEntity<Response<FormDefinitionResponse>> activate(@PathVariable UUID id) {
    var data = definitionService.activate(id);
    return ResponseEntity.ok(Response.ok(data, "Form definition activated"));
  }

  @PatchMapping("/{id}/deprecate")
  public ResponseEntity<Response<FormDefinitionResponse>> deprecate(@PathVariable UUID id) {
    var data = definitionService.deprecate(id);
    return ResponseEntity.ok(Response.ok(data, "Form definition deprecated"));
  }

  // ── Sections ─────────────────────────────────────────────────────────────

  @GetMapping("/{definitionId}/sections")
  public ResponseEntity<Response<List<FormSectionResponse>>> fetchSections(
      @PathVariable UUID definitionId) {
    var data = sectionService.fetchByDefinition(definitionId);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }

  @PostMapping("/{definitionId}/sections")
  public ResponseEntity<Response<FormSectionResponse>> createSection(
      @PathVariable UUID definitionId, @RequestBody FormSectionRequest request) {
    var data = sectionService.create(definitionId, request);
    return ResponseEntity.status(HttpStatus.CREATED).body(Response.created(data, "Section created"));
  }

  @PutMapping("/{definitionId}/sections/{sectionId}")
  public ResponseEntity<Response<FormSectionResponse>> updateSection(
      @PathVariable UUID definitionId,
      @PathVariable UUID sectionId,
      @RequestBody FormSectionRequest request) {
    var data = sectionService.update(definitionId, sectionId, request);
    return ResponseEntity.ok(Response.ok(data, "Section updated"));
  }

  @DeleteMapping("/{definitionId}/sections/{sectionId}")
  public ResponseEntity<Response<Void>> deleteSection(
      @PathVariable UUID definitionId, @PathVariable UUID sectionId) {
    sectionService.delete(definitionId, sectionId);
    return ResponseEntity.ok(Response.ok(null, "Section deleted"));
  }

  // ── Fields ────────────────────────────────────────────────────────────────

  @GetMapping("/{definitionId}/fields")
  public ResponseEntity<Response<List<FormDefinitionFieldResponse>>> fetchFields(
      @PathVariable UUID definitionId) {
    var data = fieldService.fetchByDefinition(definitionId);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }

  @PostMapping("/{definitionId}/fields")
  public ResponseEntity<Response<FormDefinitionFieldResponse>> addField(
      @PathVariable UUID definitionId, @RequestBody FormDefinitionFieldRequest request) {
    var data = fieldService.addField(definitionId, request);
    return ResponseEntity.status(HttpStatus.CREATED).body(Response.created(data, "Field added"));
  }

  @PostMapping("/{definitionId}/fields/bulk")
  public ResponseEntity<Response<List<FormDefinitionFieldResponse>>> bulkAddFields(
      @PathVariable UUID definitionId, @RequestBody List<FormDefinitionFieldRequest> requests) {
    var data = fieldService.bulkAddFields(definitionId, requests);
    return ResponseEntity.status(HttpStatus.CREATED).body(Response.created(data, "Fields added"));
  }

  @PutMapping("/{definitionId}/fields/{fieldId}")
  public ResponseEntity<Response<FormDefinitionFieldResponse>> updateField(
      @PathVariable UUID definitionId,
      @PathVariable UUID fieldId,
      @RequestBody FormDefinitionFieldRequest request) {
    var data = fieldService.updateField(definitionId, fieldId, request);
    return ResponseEntity.ok(Response.ok(data, "Field updated"));
  }

  @DeleteMapping("/{definitionId}/fields/{fieldId}")
  public ResponseEntity<Response<Void>> removeField(
      @PathVariable UUID definitionId, @PathVariable UUID fieldId) {
    fieldService.removeField(definitionId, fieldId);
    return ResponseEntity.ok(Response.ok(null, "Field removed"));
  }
}
