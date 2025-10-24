package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.TaxService;
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
@RequestMapping("/api/tax")
@RequiredArgsConstructor
public class TaxController {
  private final TaxService service;

  @GetMapping("/samples/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/sample/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/collections/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> collectionFetchAll() {
    var data = service.collectionFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/collection/{id}")
  public ResponseEntity<Response<CommonLookUp>> collectionFetchById(@PathVariable UUID id) {
    var data = service.collectionFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/types/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> typesFetchAll() {
    var data = service.typesFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/type/{id}")
  public ResponseEntity<Response<CommonLookUp>> typeFetchById(@PathVariable UUID id) {
    var data = service.typeFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> detailsFetchAll() {
    var data = service.detailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> detailFetchById(@PathVariable UUID id) {
    var data = service.detailFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/payer-types/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> payersFetchAll() {
    var data = service.payersFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/payer-type/{id}")
  public ResponseEntity<Response<CommonLookUp>> payerFetchAll(@PathVariable UUID id) {
    var data = service.payerFetchAll(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }
}
