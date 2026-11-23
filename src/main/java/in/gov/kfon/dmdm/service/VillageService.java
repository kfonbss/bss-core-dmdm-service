package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface VillageService {
  List<CommonLookUp> fetchBySubDistrictId(UUID subDistrictId);

  CommonLookUp fetchById(UUID id);
}
