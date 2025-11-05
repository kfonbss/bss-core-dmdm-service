package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.SpecialEventsServiceImpl;
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
@RequestMapping("/api/special-events")
@RequiredArgsConstructor
public class SpecialEventsController {

  private final SpecialEventsServiceImpl service;
  private static final String FETCHED = "Fetched";

  @GetMapping("customers/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> customersFetchAll() {
    var data = service.customersFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("customer/{id}")
  public ResponseEntity<Response<CommonLookUp>> customersFetchById(@PathVariable UUID id) {
    var data = service.customersFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("disbursements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> disbursementFetchAll() {
    var data = service.disbursementFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("disbursement/{id}")
  public ResponseEntity<Response<CommonLookUp>> disbursementFetchById(@PathVariable UUID id) {
    var data = service.disbursementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("invoices/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> invoiceFetchAll() {
    var data = service.invoiceFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("invoice/{id}")
  public ResponseEntity<Response<CommonLookUp>> invoiceFetchById(@PathVariable UUID id) {
    var data = service.invoiceFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("invoice-masters/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> invoiceMasterFetchAll() {
    var data = service.invoiceMasterFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("invoice-master/{id}")
  public ResponseEntity<Response<CommonLookUp>> invoiceMasterFetchById(@PathVariable UUID id) {
    var data = service.invoiceMasterFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("kyc-details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> kycDetailsFetchAll() {
    var data = service.kycDetailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("kyc-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> kycDetailsFetchById(@PathVariable UUID id) {
    var data = service.kycDetailsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location-movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> locationMovementsFetchAll() {
    var data = service.locationMovementsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> locationMovementsFetchById(@PathVariable UUID id) {
    var data = service.locationMovementsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("locations/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> locationsFetchAll() {
    var data = service.locationsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location/{id}")
  public ResponseEntity<Response<CommonLookUp>> locationsFetchById(@PathVariable UUID id) {
    var data = service.locationsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("loc-finances/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> locFinanceFetchAll() {
    var data = service.locFinanceFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("loc-finance/{id}")
  public ResponseEntity<Response<CommonLookUp>> locFinanceFetchById(@PathVariable UUID id) {
    var data = service.locFinanceFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }
}
