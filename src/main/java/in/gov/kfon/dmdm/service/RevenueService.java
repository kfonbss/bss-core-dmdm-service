package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.RevenueShareResponse;
import java.util.List;
import java.util.UUID;

public interface RevenueService {
  List<CommonLookUp> fetchRevenue();

  CommonLookUp fetchRevenueById(UUID id);

  RevenueShareResponse fetchRevenueShareById(UUID id);

  List<CommonLookUp> fetchRevenueSharesByServiceOrProvider(Integer subgroup, UUID providerUuid);
}
