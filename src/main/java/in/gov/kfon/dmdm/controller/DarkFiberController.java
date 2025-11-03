package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.DarkFiberService;
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
@RequestMapping("/api/darkfiber")
@RequiredArgsConstructor
public class DarkFiberController {

  private final DarkFiberService darkFiberService;

  @GetMapping("/group-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupDetails() {
    var data = darkFiberService.fetchAllGroupDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all group details"));
  }

  @GetMapping("/group-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupDetailsById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched group detail"));
  }

  @GetMapping("/group-movements")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupMovements() {
    var data = darkFiberService.fetchAllGroupMovements();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all group movements"));
  }

  @GetMapping("/group-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupMovementById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupMovementById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched group movement"));
  }

  @GetMapping("/group-invoices")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupInvoices() {
    var data = darkFiberService.fetchAllGroupInvoices();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all group invoices"));
  }

  @GetMapping("/group-invoice/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupInvoiceById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupInvoiceById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched invoice by ID"));
  }

  @GetMapping("/group-invoice-masters")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupInvoiceMasters() {
    var data = darkFiberService.fetchAllGroupInvoiceMasters();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all invoice masters"));
  }

  @GetMapping("/group-invoice-master/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupInvoiceMasterById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupInvoiceMasterById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched invoice master by ID"));
  }

  @GetMapping("/link-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllLinkDetails() {
    var data = darkFiberService.fetchAllLinkDetails();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all link details"));
  }

  @GetMapping("/link-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchLinkDetailById(@PathVariable UUID id) {
    var data = darkFiberService.fetchLinkDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched link detail by ID"));
  }

  @GetMapping("/link-renewal-histories")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllLinkRenewalHistories() {
    var data = darkFiberService.fetchAllLinkRenewalHistories();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all link renewal histories"));
  }

  @GetMapping("/link-renewal-history/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchLinkRenewalHistoryById(@PathVariable UUID id) {
    var data = darkFiberService.fetchLinkRenewalHistoryById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched link renewal history by ID"));
  }
}
