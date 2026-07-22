package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.LookupMasterRequest;
import in.gov.kfon.dmdm.contract.LookupMasterResponse;
import java.util.List;

public interface LookupMasterService {

  LookupMasterResponse create(LookupMasterRequest request);

  List<LookupMasterResponse> fetchByType(String lookupType, String appCode, String tenantId);
}
