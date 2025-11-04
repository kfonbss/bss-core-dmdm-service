package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface SpecialEventsService {
  List<CommonLookUp> customersFetchAll();

  CommonLookUp customersFetchById(UUID id);

  List<CommonLookUp> disbursementFetchAll();

  CommonLookUp disbursementFetchById(UUID id);
}
