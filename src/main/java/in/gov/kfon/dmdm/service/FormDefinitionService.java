package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.FormDefinitionRequest;
import in.gov.kfon.dmdm.contract.FormDefinitionResponse;
import java.util.List;
import java.util.UUID;

public interface FormDefinitionService {

  FormDefinitionResponse create(FormDefinitionRequest request);

  FormDefinitionResponse fetchById(UUID id);

  List<FormDefinitionResponse> fetchAll(UUID applicationId, String tenantId, String formType);

  FormDefinitionResponse activate(UUID id);

  FormDefinitionResponse deprecate(UUID id);
}
