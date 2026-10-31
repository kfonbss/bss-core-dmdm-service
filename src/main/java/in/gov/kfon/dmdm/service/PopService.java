package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.DfPopListResponse;
import java.util.List;
import java.util.UUID;

public interface PopService {

  List<CommonLookUp> fetchAllPopMasters(String stateCode);

  CommonLookUp fetchPopMasterById(UUID id);

  List<CommonLookUp> fetchAllPopMasterBackups();

  CommonLookUp fetchPopMasterBackupById(UUID id);

  List<DfPopListResponse> fetchAllDfPopLists();

  CommonLookUp fetchDfPopById(UUID id);
}
