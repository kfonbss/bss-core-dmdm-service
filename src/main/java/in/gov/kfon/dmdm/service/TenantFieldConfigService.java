package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.TenantFieldConfigRequest;
import in.gov.kfon.dmdm.contract.ApplicationFieldConfigResponse;
import java.util.List;
import java.util.UUID;

public interface TenantFieldConfigService {

  List<ApplicationFieldConfigResponse> fetchByTenantAndApplication(
      String tenantId, UUID applicationId);

  ApplicationFieldConfigResponse upsert(
      String tenantId, UUID applicationId, TenantFieldConfigRequest request);

  List<ApplicationFieldConfigResponse> bulkUpsert(
      String tenantId, UUID applicationId, List<TenantFieldConfigRequest> requests);
}
