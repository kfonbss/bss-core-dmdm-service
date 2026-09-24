package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.ClientApplicationRequest;
import in.gov.kfon.dmdm.contract.ClientApplicationResponse;
import java.util.List;
import java.util.UUID;

public interface ClientApplicationService {

  List<ClientApplicationResponse> fetchAll();

  ClientApplicationResponse fetchById(UUID id);

  ClientApplicationResponse create(ClientApplicationRequest request);

  ClientApplicationResponse update(UUID id, ClientApplicationRequest request);
}
