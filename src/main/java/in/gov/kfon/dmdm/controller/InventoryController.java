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

  @GetMapping("device-details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> deviceDetailsFetchAll() {
    var data = inventoryService.deviceDetailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> deviceDetailsFetchById(@PathVariable UUID id) {
    var data = inventoryService.deviceDetailsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device/details-audits/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> deviceDetailsAuditsFetchAll() {
    var data = inventoryService.deviceDetailsAuditsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device/details-audit/{id}")
  public ResponseEntity<Response<CommonLookUp>> deviceDetailsAuditsFetchById(
      @PathVariable UUID id) {
    var data = inventoryService.deviceDetailsAuditsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/device-types/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDeviceTypes() {
    var data = inventoryService.fetchAllDeviceTypes();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all device types"));
  }

  @GetMapping("/device-type/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDeviceTypeById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceTypeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched device type"));
  }

  @GetMapping("/device-vendors/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDeviceVendors() {
    var data = inventoryService.fetchAllDeviceVendors();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all device vendors"));
  }

  @GetMapping("/device-vendor/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDeviceVendorById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceVendorById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched device vendor"));
  }

  @GetMapping("/device-transfers/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> deviceTransfersFetchAll() {
    var data = inventoryService.fetchAllDeviceTransferRequests();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/device-transfer/{id}")
  public ResponseEntity<Response<CommonLookUp>> deviceTransfersFetchById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceTransferRequestById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/device-movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> deviceMovementsFetchAll() {
    var data = inventoryService.fetchAllDeviceTransferMovements();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/device-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> deviceMovementsFetchById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceTransferMovementById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/po-details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPoDetails() {
    var data = inventoryService.fetchAllPoDetails();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all PO details"));
  }

  @GetMapping("/po-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPoDetailsById(@PathVariable UUID id) {
    var data = inventoryService.fetchPoDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched PO detail"));
  }

  @GetMapping("/po-documents/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPoDocuments() {
    var data = inventoryService.fetchAllPoDocuments();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all PO documents"));
  }

  @GetMapping("/po-document/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPoDocumentById(@PathVariable UUID id) {
    var data = inventoryService.fetchPoDocumentById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched PO document"));
  }

  @GetMapping("/lnp-device-requests/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllLnpDeviceRequests() {
    var data = inventoryService.fetchAllLnpDeviceRequests();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all LNP device requests"));
  }

  @GetMapping("/lnp-device-request/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchLnpDeviceRequestById(@PathVariable UUID id) {
    var data = inventoryService.fetchLnpDeviceRequestById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched LNP device request"));
  }

  @GetMapping("/lnp-device-request-movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllLnpDeviceRequestMovements() {
    var data = inventoryService.fetchAllLnpDeviceRequestMovements();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all LNP device request movements"));
  }

  @GetMapping("/lnp-device-request-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchLnpDeviceRequestMovementById(
      @PathVariable UUID id) {
    var data = inventoryService.fetchLnpDeviceRequestMovementById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched LNP device request movement"));
  }

  @GetMapping("dc-credit-notes/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> dcCreditNoteFetchAll() {
    var data = inventoryService.dcCreditNoteFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("dc-credit-note/{id}")
  public ResponseEntity<Response<CommonLookUp>> dcCreditNoteFetchById(@PathVariable UUID id) {
    var data = inventoryService.dcCreditNoteFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device/condition-statuses/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> deviceConditionStatusFetchAll() {
    var data = inventoryService.deviceConditionStatusFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device/condition-status/{id}")
  public ResponseEntity<Response<CommonLookUp>> deviceConditionStatusFetchById(
      @PathVariable UUID id) {
    var data = inventoryService.deviceConditionStatusFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device/details-movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> deviceDetailsMovementFetchAll() {
    var data = inventoryService.deviceDetailsMovementFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("device/details-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> deviceDetailsMovementFetchById(
      @PathVariable UUID id) {
    var data = inventoryService.deviceDetailsMovementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("kfon-dc/device-requests/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> kfonDcDeviceRequestsFetchAll() {
    var data = inventoryService.kfonDcDeviceRequestsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("kfon-dc/device-request/{id}")
  public ResponseEntity<Response<CommonLookUp>> kfonDcDeviceRequestsFetchById(
      @PathVariable UUID id) {
    var data = inventoryService.kfonDcDeviceRequestsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/return-faulty-requests/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllReturnFaultyRequests() {
    var data = inventoryService.fetchAllFaultyRequests();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all return faulty requests"));
  }

  @GetMapping("/return-faulty-request/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchReturnFaultyRequestById(
      @PathVariable UUID id) {
    var data = inventoryService.fetchFaultyRequestById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched return faulty request"));
  }
}
