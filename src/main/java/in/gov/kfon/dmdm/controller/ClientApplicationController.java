package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.ClientApplicationRequest;
import in.gov.kfon.dmdm.contract.ClientApplicationResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.ClientApplicationService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/onboarding/applications")
@RequiredArgsConstructor
public class ClientApplicationController {

  private final ClientApplicationService service;

  @GetMapping
  public ResponseEntity<Response<List<ClientApplicationResponse>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<ClientApplicationResponse>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @PostMapping
  public ResponseEntity<Response<ClientApplicationResponse>> create(
      @RequestBody ClientApplicationRequest request) {
    var data = service.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(Response.created(data, "Application created"));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Response<ClientApplicationResponse>> update(
      @PathVariable UUID id, @RequestBody ClientApplicationRequest request) {
    var data = service.update(id, request);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Application updated"));
  }
}