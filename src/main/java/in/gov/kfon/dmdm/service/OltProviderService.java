package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.OltProviderRequest;
import in.gov.kfon.dmdm.contract.OltProviderResponse;
import java.util.List;
import java.util.UUID;

public interface OltProviderService {

  /** OLT providers offered to the tenant; BNU-KA does not get KFON's LNP and KFON. */
  List<OltProviderResponse> fetchAll(String tenantId);

  OltProviderResponse fetchById(UUID id);

  OltProviderResponse create(OltProviderRequest request);

  OltProviderResponse update(UUID id, OltProviderRequest request);
}
