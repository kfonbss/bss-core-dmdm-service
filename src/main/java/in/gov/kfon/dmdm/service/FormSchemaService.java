package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.FormSchemaResponse;

public interface FormSchemaService {

  FormSchemaResponse resolveFormSchema(String appCode, String tenantId);
}
