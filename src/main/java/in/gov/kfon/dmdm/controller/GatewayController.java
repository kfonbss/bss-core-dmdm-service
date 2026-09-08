package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.GatewayAvailabilityResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.GatewayService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gateway")
@RequiredArgsConstructor
public class GatewayController {
  private final GatewayService service;

  @GetMapping("/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @GetMapping("/availability")
  public ResponseEntity<Response<GatewayAvailabilityResponse>> fetchAvailability(
      @RequestHeader("X-Tenant-ID") String tenantId) {
    var data = service.fetchAvailableGateways(tenantId);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched gateway availability"));
  }
}
