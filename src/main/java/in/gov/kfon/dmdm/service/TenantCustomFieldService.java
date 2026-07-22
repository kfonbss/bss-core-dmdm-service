package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.TenantCustomFieldRequest;
import in.gov.kfon.dmdm.contract.FormFieldMasterResponse;
import java.util.List;
import java.util.UUID;

public interface TenantCustomFieldService {

  List<FormFieldMasterResponse> fetchByTenantAndApplication(String tenantId, UUID applicationId);

  FormFieldMasterResponse create(String tenantId, UUID applicationId, TenantCustomFieldRequest request);

  FormFieldMasterResponse update(UUID id, TenantCustomFieldRequest request);
}
