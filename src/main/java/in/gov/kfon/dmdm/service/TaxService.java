package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface TaxService {
  List<CommonLookUp> fetchAll();

  CommonLookUp fetchById(UUID id);

  List<CommonLookUp> collectionFetchAll();

  CommonLookUp collectionFetchById(UUID id);
}
