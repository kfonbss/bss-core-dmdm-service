package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.PaymentModeResponse;
import in.gov.kfon.dmdm.contract.PayoutChargeResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.PayoutMasterService;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payout")
@RequiredArgsConstructor
public class PayoutMasterController {

  private final PayoutMasterService payoutMasterService;

  @GetMapping("/payment-modes")
  public ResponseEntity<Response<List<PaymentModeResponse>>> fetchPaymentModes() {
    var data = payoutMasterService.fetchPaymentModes();
    return ResponseEntity.ok(Response.ok(data, "Payment modes fetched successfully"));
  }

  @GetMapping("/charges")
  public ResponseEntity<Response<List<PayoutChargeResponse>>> fetchCharges(
      @RequestParam(required = false) String mode) {
    var data = payoutMasterService.fetchCharges(mode);
    return ResponseEntity.ok(Response.ok(data, "Payout charges fetched successfully"));
  }

  @GetMapping("/charges/{mode}")
  public ResponseEntity<Response<PayoutChargeResponse>> fetchChargeForAmount(
      @PathVariable String mode, @RequestParam BigDecimal amount) {
    var data = payoutMasterService.fetchChargeForAmount(mode, amount);
    return ResponseEntity.ok(Response.ok(data, "Payout charge fetched successfully"));
  }
}