package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface DarkFiberService {

  List<CommonLookUp> fetchAllGroupDetails();

  CommonLookUp fetchGroupDetailsById(UUID id);

  List<CommonLookUp> fetchAllGroupMovements();

  CommonLookUp fetchGroupMovementById(UUID id);
}
