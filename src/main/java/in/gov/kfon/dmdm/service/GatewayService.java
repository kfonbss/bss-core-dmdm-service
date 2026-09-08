package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.GatewayAvailabilityResponse;
import java.util.List;

public interface GatewayService {
  List<CommonLookUp> fetchAll();

  GatewayAvailabilityResponse fetchAvailableGateways(String tenantId);
}
