package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface ServiceTypeService {

  List<CommonLookUp> fetchAllServiceTypes();

  CommonLookUp fetchServiceTypeById(UUID id);
}
