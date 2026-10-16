package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;

public interface RegionService {
  List<CommonLookUp> fetchAll();

  /** The regions row of a state / circle code, whatever its status; region is in nameInLocal. */
  CommonLookUp fetchByStateCode(String stateCode);
}
