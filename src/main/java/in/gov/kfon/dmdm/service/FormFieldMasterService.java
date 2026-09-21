package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.FormFieldMasterRequest;
import in.gov.kfon.dmdm.contract.FormFieldMasterResponse;
import java.util.List;
import java.util.UUID;

public interface FormFieldMasterService {

  List<FormFieldMasterResponse> fetchAll();

  FormFieldMasterResponse fetchById(UUID id);

  FormFieldMasterResponse create(FormFieldMasterRequest request);

  FormFieldMasterResponse update(UUID id, FormFieldMasterRequest request);
}
