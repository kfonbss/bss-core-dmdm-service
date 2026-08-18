package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.OltProviderRequest;
import in.gov.kfon.dmdm.contract.OltProviderResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.OltProviderService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/olt-provider")
@RequiredArgsConstructor
public class OltProviderController {

  private final OltProviderService service;
  private static final String FETCHED = "Fetched";

  @GetMapping("/fetch-all")
  public ResponseEntity<Response<List<OltProviderResponse>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<OltProviderResponse>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @PostMapping
  public ResponseEntity<Response<OltProviderResponse>> create(
      @RequestBody OltProviderRequest request) {
    var data = service.create(request);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(Response.created(data, "OLT provider created"));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Response<OltProviderResponse>> update(
      @PathVariable UUID id, @RequestBody OltProviderRequest request) {
    var data = service.update(id, request);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "OLT provider updated"));
  }
}
