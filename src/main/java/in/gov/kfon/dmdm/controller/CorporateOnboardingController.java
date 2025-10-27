package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.CorporateOnboardingService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/corporate")
@RequiredArgsConstructor
public class CorporateOnboardingController {
  private final CorporateOnboardingService service;

  @GetMapping("enquires/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("enquiry/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("location-lists/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> locationFetchAll() {
    var data = service.locationFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("location-list/{id}")
  public ResponseEntity<Response<CommonLookUp>> locationFetchById(@PathVariable UUID id) {
    var data = service.locationFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("connection/breakups/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> connectionsFetchAll() {
    var data = service.connectionsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("connection/breakup/{id}")
  public ResponseEntity<Response<CommonLookUp>> connectionFetchById(@PathVariable UUID id) {
    var data = service.connectionFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("connection/breakup-movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> movementsFetchAll() {
    var data = service.movementsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("connection/breakup-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> movementFetchById(@PathVariable UUID id) {
    var data = service.movementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("connection/breakup-movements/revisions/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> cMovementsFetchAll() {
    var data = service.cMovementsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("connection/breakup-movement/revision/{id}")
  public ResponseEntity<Response<CommonLookUp>> cMovementFetchById(@PathVariable UUID id) {
    var data = service.cMovementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }
}
