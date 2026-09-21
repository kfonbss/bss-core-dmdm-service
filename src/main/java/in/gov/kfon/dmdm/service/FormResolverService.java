package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.ResolvedFormResponse;

public interface FormResolverService {

  ResolvedFormResponse resolve(String appCode, String tenantId, String formType);
}
