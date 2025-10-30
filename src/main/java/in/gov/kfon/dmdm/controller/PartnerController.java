package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.PartnerService;
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
@RequestMapping("/api/partner")
@RequiredArgsConstructor
public class PartnerController {

  private final PartnerService service;

  @GetMapping("/finances")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerFinances() {
    var data = service.fetchAllFinanceDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner financial details"));
  }

  @GetMapping("/finance/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerFinanceById(@PathVariable UUID id) {
    var data = service.fetchFinanceDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner finance detail"));
  }

  @GetMapping("/taxpayer-logs")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerTaxpayerLogs() {
    var data = service.fetchAllTaxpayerLogs();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner taxpayer logs"));
  }

  @GetMapping("/taxpayer-log/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerTaxpayerLogById(@PathVariable UUID id) {
    var data = service.fetchTaxpayerLogById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner taxpayer log"));
  }

  @GetMapping("/groups")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerGroups() {
    var data = service.fetchAllPartnerGroups();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner groups"));
  }

  @GetMapping("/group/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerGroupById(@PathVariable UUID id) {
    var data = service.fetchPartnerGroupById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner group by id"));
  }

  @GetMapping("/gst-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerGstDetails() {
    var data = service.fetchAllPartnerGstDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner GST details"));
  }

  @GetMapping("/gst-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerGstDetailById(@PathVariable UUID id) {
    var data = service.fetchPartnerGstDetailById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner GST detail by id"));
  }

  @GetMapping("/gst-invoices")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGstInvoices() {
    var data = service.fetchAllGstInvoices();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner GST invoices"));
  }

  @GetMapping("/gst-invoice/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGstInvoiceById(@PathVariable UUID id) {
    var data = service.fetchGstInvoiceById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner GST invoice by id"));
  }

  @GetMapping("/online-recharges")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllOnlineRecharges() {
    var data = service.fetchAllOnlineRecharges();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner online recharges"));
  }

  @GetMapping("/online-recharge/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchOnlineRechargeById(@PathVariable UUID id) {
    var data = service.fetchOnlineRechargeById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner online recharge by id"));
  }
}
