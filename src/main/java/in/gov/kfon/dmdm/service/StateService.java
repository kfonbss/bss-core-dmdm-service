package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.StateResponse;

import java.util.List;
import java.util.UUID;

public interface StateService {
  List<CommonLookUp> fetchAll();

  CommonLookUp fetchById(UUID id);

  StateResponse fetchStateByCode(String code);
}
