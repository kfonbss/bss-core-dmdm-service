package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface CorporateOnboardingService {
  List<CommonLookUp> fetchAll();

  CommonLookUp fetchById(UUID id);

  List<CommonLookUp> locationFetchAll();

  CommonLookUp locationFetchById(UUID id);

  List<CommonLookUp> connectionsFetchAll();

  CommonLookUp connectionFetchById(UUID id);

  List<CommonLookUp> movementsFetchAll();

  CommonLookUp movementFetchById(UUID id);

  List<CommonLookUp> cMovementsFetchAll();

  CommonLookUp cMovementFetchById(UUID id);
}
