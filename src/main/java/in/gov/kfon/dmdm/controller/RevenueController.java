package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.contract.RevenueShareResponse;
import in.gov.kfon.dmdm.service.RevenueService;
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
@RequestMapping("/api/revenue")
@RequiredArgsConstructor
public class RevenueController {
  private final RevenueService service;

  @GetMapping("/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchRevenue() {
    var data = service.fetchRevenue();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all Revenue Share"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchRevenueById(@PathVariable UUID id) {
    var data = service.fetchRevenueById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched Revenue Share"));
  }

  @GetMapping("/share/{id}")
  public ResponseEntity<Response<RevenueShareResponse>> fetchRevenueShareById(
      @PathVariable UUID id) {
    var data = service.fetchRevenueShareById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched Revenue Share Details"));
  }
}
