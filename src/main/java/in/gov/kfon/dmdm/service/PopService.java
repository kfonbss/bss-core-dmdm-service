package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface PopService {

  List<CommonLookUp> fetchAllPopMasters();

  CommonLookUp fetchPopMasterById(UUID id);

  List<CommonLookUp> fetchAllPopMasterBackups();

  CommonLookUp fetchPopMasterBackupById(UUID id);
}
