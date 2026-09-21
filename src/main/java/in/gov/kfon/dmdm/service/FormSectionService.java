package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.FormSectionRequest;
import in.gov.kfon.dmdm.contract.FormSectionResponse;
import java.util.List;
import java.util.UUID;

public interface FormSectionService {

  FormSectionResponse create(UUID definitionId, FormSectionRequest request);

  FormSectionResponse update(UUID definitionId, UUID sectionId, FormSectionRequest request);

  void delete(UUID definitionId, UUID sectionId);

  List<FormSectionResponse> fetchByDefinition(UUID definitionId);
}
