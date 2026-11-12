package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.PaymentGatewayAvailabilityRequest;
import in.gov.kfon.dmdm.contract.PaymentGatewayAvailabilityResponse;
import java.util.List;
import java.util.UUID;

public interface PaymentGatewayAvailabilityService {

  /** Active gateways the tenant's state offers to {@code userType}, in display order. */
  List<PaymentGatewayAvailabilityResponse> fetchActive(String tenantId, String userType);

  /** Every row (active or not) of a state, for the admin screen. */
  List<PaymentGatewayAvailabilityResponse> fetchForState(String stateCode);

  PaymentGatewayAvailabilityResponse create(PaymentGatewayAvailabilityRequest request);

  PaymentGatewayAvailabilityResponse update(UUID id, PaymentGatewayAvailabilityRequest request);
}
