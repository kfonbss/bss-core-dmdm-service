package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.NmsDetailRequest;
import in.gov.kfon.dmdm.contract.NmsDetailResponse;
import java.util.List;
import java.util.UUID;

public interface NmsDetailService {

  NmsDetailResponse create(NmsDetailRequest request);

  NmsDetailResponse update(UUID id, NmsDetailRequest request);

  NmsDetailResponse fetchById(UUID id);

  NmsDetailResponse fetchByStateCode(String stateCode);

  List<NmsDetailResponse> fetchAll();
}
