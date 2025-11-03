package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface DarkFiberService {

  List<CommonLookUp> fetchAllGroupDetails();

  CommonLookUp fetchGroupDetailsById(UUID id);

  List<CommonLookUp> fetchAllGroupMovements();

  CommonLookUp fetchGroupMovementById(UUID id);

  List<CommonLookUp> fetchAllGroupInvoices();

  CommonLookUp fetchGroupInvoiceById(UUID id);

  List<CommonLookUp> fetchAllGroupInvoiceMasters();

  CommonLookUp fetchGroupInvoiceMasterById(UUID id);

  List<CommonLookUp> fetchAllLinkDetails();

  CommonLookUp fetchLinkDetailsById(UUID id);

  List<CommonLookUp> fetchAllLinkRenewalHistories();

  CommonLookUp fetchLinkRenewalHistoryById(UUID id);
}
