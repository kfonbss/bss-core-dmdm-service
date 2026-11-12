package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.PaymentGatewayAvailabilityRequest;
import in.gov.kfon.dmdm.contract.PaymentGatewayAvailabilityResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.PaymentGatewayAvailabilityService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Payment gateways per state, for subscribers (online recharge) and partners (wallet top-up). */
@RestController
@RequestMapping("/api/payment-gateways")
@RequiredArgsConstructor
public class PaymentGatewayAvailabilityController {

  private final PaymentGatewayAvailabilityService service;

  /** Active gateways the caller's tenant state offers to {@code userType} (SUBSCRIBER/PARTNER). */
  @GetMapping
  public ResponseEntity<Response<List<PaymentGatewayAvailabilityResponse>>> fetchActive(
      @RequestHeader("X-Tenant-ID") String tenantId, @RequestParam String userType) {
    var data = service.fetchActive(tenantId, userType);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  /** Every row of a state for the admin screen; the caller's tenant state when none is given. */
  @GetMapping("/availability")
  public ResponseEntity<Response<List<PaymentGatewayAvailabilityResponse>>> fetchForState(
      @RequestHeader(value = "X-Tenant-ID", required = false) String tenantId,
      @RequestParam(required = false) String stateCode) {
    var data = service.fetchForState(stateCode != null ? stateCode : tenantId);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  @PostMapping("/availability")
  public ResponseEntity<Response<PaymentGatewayAvailabilityResponse>> create(
      @RequestBody PaymentGatewayAvailabilityRequest request) {
    var data = service.create(request);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(Response.created(data, "Payment gateway added"));
  }

  @PutMapping("/availability/{id}")
  public ResponseEntity<Response<PaymentGatewayAvailabilityResponse>> update(
      @PathVariable UUID id, @RequestBody PaymentGatewayAvailabilityRequest request) {
    var data = service.update(id, request);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Payment gateway updated"));
  }
}
