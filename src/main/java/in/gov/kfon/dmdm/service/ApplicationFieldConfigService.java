package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.ApplicationFieldConfigRequest;
import in.gov.kfon.dmdm.contract.ApplicationFieldConfigResponse;
import java.util.List;
import java.util.UUID;

public interface ApplicationFieldConfigService {

  List<ApplicationFieldConfigResponse> fetchByApplication(UUID applicationId);

  ApplicationFieldConfigResponse upsert(UUID applicationId, ApplicationFieldConfigRequest request);

  List<ApplicationFieldConfigResponse> bulkUpsert(
      UUID applicationId, List<ApplicationFieldConfigRequest> requests);
}
