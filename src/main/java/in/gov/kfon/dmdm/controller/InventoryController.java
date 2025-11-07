package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.InventoryService;
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
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

  private final InventoryService inventoryService;
  private static final String FETCHED = "Fetched";

  @GetMapping("/device-makes/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDeviceMakes() {
    var data = inventoryService.fetchAllDeviceMakes();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all device makes"));
  }

  @GetMapping("/device-make/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDeviceMakeById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceMakeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched device make"));
  }

  @GetMapping("/device-models/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDeviceModels() {
    var data = inventoryService.fetchAllDeviceModels();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all device models"));
  }

  @GetMapping("/device-model/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDeviceModelById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceModelById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched device model"));
  }

  @GetMapping("credit-notes/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> creditNotesFetchAll() {
    var data = inventoryService.creditNotesFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("credit-note/{id}")
  public ResponseEntity<Response<CommonLookUp>> creditNotesFetchById(@PathVariable UUID id) {
    var data = inventoryService.creditNotesFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("dc/credit-notes/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> dcCreditNotesFetchAll() {
    var data = inventoryService.dcCreditNotesFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("dc/credit-note/{id}")
  public ResponseEntity<Response<CommonLookUp>> dcCreditNotesFetchById(@PathVariable UUID id) {
    var data = inventoryService.dcCreditNotesFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device-acknowledgements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> deviceAcknowledgementFetchAll() {
    var data = inventoryService.deviceAcknowledgementFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device-acknowledgement/{id}")
  public ResponseEntity<Response<CommonLookUp>> deviceAcknowledgementFetchById(
      @PathVariable UUID id) {
    var data = inventoryService.deviceAcknowledgementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device-cats/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> deviceCatFetchAll() {
    var data = inventoryService.deviceCatFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device-cat/{id}")
  public ResponseEntity<Response<CommonLookUp>> deviceCatFetchById(@PathVariable UUID id) {
    var data = inventoryService.deviceCatFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/returns/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDeviceReturns() {
    var data = inventoryService.fetchAllDeviceReturns();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all device return to OEM"));
  }

  @GetMapping("/return/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDeviceReturnById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceReturnById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched device return to OEM"));
  }

  @GetMapping("/statuses/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDeviceStatuses() {
    var data = inventoryService.fetchAllDeviceStatuses();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all device statuses"));
  }

  @GetMapping("/status/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDeviceStatusById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceStatusById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched device status"));
  }
}
