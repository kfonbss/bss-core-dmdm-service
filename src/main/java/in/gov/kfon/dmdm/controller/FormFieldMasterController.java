package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.FormFieldMasterRequest;
import in.gov.kfon.dmdm.contract.FormFieldMasterResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.FormFieldMasterService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/onboarding/field-master")
@RequiredArgsConstructor
public class FormFieldMasterController {

  private final FormFieldMasterService service;

  @GetMapping
  public ResponseEntity<Response<List<FormFieldMasterResponse>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<FormFieldMasterResponse>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @PostMapping
  public ResponseEntity<Response<FormFieldMasterResponse>> create(
      @RequestBody FormFieldMasterRequest request) {
    var data = service.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(Response.created(data, "Field created"));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Response<FormFieldMasterResponse>> update(
      @PathVariable UUID id, @RequestBody FormFieldMasterRequest request) {
    var data = service.update(id, request);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Field updated"));
  }
}