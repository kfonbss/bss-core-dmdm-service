package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.BlockDetailResponse;
import in.gov.kfon.dmdm.contract.CommonLookUp;

import java.util.List;
import java.util.UUID;

public interface BlockDetailService {

  List<CommonLookUp> fetchCorporationName(UUID districtId, int villageTypeId);

  List<CommonLookUp> fetchPanchayatName(UUID districtId, int villageTypeId);

  List<CommonLookUp> fetchBlockName(UUID districtId, int villageTypeId);

  BlockDetailResponse fetchById(UUID blockId);
}
