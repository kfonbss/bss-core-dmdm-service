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
}
