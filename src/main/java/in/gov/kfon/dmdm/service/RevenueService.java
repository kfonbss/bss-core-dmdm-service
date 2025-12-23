package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface RevenueService {
  List<CommonLookUp> fetchRevenue();

  CommonLookUp fetchRevenueById(UUID id);
}
