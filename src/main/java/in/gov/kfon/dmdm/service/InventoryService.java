package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface InventoryService {

  List<CommonLookUp> fetchAllDeviceMakes();

  CommonLookUp fetchDeviceMakeById(UUID id);

  List<CommonLookUp> fetchAllDeviceModels();

  CommonLookUp fetchDeviceModelById(UUID id);
}
