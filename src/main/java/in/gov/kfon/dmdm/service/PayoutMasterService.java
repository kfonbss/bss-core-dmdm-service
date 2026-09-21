package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.PaymentModeResponse;
import in.gov.kfon.dmdm.contract.PayoutChargeResponse;
import java.math.BigDecimal;
import java.util.List;

public interface PayoutMasterService {
  List<PaymentModeResponse> fetchPaymentModes();

  List<PayoutChargeResponse> fetchCharges(String mode);

  PayoutChargeResponse fetchChargeForAmount(String mode, BigDecimal amount);
}
