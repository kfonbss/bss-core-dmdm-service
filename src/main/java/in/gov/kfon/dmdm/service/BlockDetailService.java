package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;

public interface BlockDetailService {

  List<CommonLookUp> fetchCorporationName(int districtId, int villageTypeId);

  List<CommonLookUp> fetchPanchayatName(int districtId, int villageTypeId);

  List<CommonLookUp> fetchBlockName(int districtId, int villageTypeId);
}
