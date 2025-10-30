package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface PartnerService {

  List<CommonLookUp> fetchAllFinanceDetails();

  CommonLookUp fetchFinanceDetailsById(UUID id);

  List<CommonLookUp> fetchAllTaxpayerLogs();

  CommonLookUp fetchTaxpayerLogById(UUID id);

  List<CommonLookUp> fetchAllPartnerGroups();

  CommonLookUp fetchPartnerGroupById(UUID id);

  List<CommonLookUp> fetchAllPartnerGstDetails();

  CommonLookUp fetchPartnerGstDetailById(UUID id);
}
