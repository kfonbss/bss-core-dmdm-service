package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.OltProviderRequest;
import in.gov.kfon.dmdm.contract.OltProviderResponse;
import java.util.List;
import java.util.UUID;

public interface OltProviderService {

  List<OltProviderResponse> fetchAll();

  OltProviderResponse fetchById(UUID id);

  OltProviderResponse create(OltProviderRequest request);

  OltProviderResponse update(UUID id, OltProviderRequest request);
}
