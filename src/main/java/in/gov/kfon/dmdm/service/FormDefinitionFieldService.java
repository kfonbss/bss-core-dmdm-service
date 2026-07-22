package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.FormDefinitionFieldRequest;
import in.gov.kfon.dmdm.contract.FormDefinitionFieldResponse;
import java.util.List;
import java.util.UUID;

public interface FormDefinitionFieldService {

  FormDefinitionFieldResponse addField(UUID definitionId, FormDefinitionFieldRequest request);

  List<FormDefinitionFieldResponse> bulkAddFields(
      UUID definitionId, List<FormDefinitionFieldRequest> requests);

  FormDefinitionFieldResponse updateField(
      UUID definitionId, UUID fieldId, FormDefinitionFieldRequest request);

  void removeField(UUID definitionId, UUID fieldId);

  List<FormDefinitionFieldResponse> fetchByDefinition(UUID definitionId);
}
