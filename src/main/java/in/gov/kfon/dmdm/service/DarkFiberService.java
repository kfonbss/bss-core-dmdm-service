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

  List<CommonLookUp> fetchAllPowerRatings();

  CommonLookUp fetchPowerRatingById(UUID id);

  List<CommonLookUp> fetchAllPurchaseOrders();

  CommonLookUp fetchPurchaseOrderById(UUID id);

  List<CommonLookUp> fetchAllRenewalDetails();

  CommonLookUp fetchRenewalDetailsById(UUID id);

  List<CommonLookUp> fetchAllSubFinance();

  CommonLookUp fetchSubFinanceById(UUID id);

  List<CommonLookUp> fetchAllSubscribers();

  CommonLookUp fetchSubscriberById(UUID id);

  List<CommonLookUp> fetchAllTransRenewalDetails();

  CommonLookUp fetchTransRenewalDetailById(UUID id);

  List<CommonLookUp> fetchAllTransDetails();

  CommonLookUp fetchTransDetailsById(UUID id);

  List<CommonLookUp> fetchAllTransDetailsMovements();

  CommonLookUp fetchTransDetailsMovementById(UUID id);

  List<CommonLookUp> fetchAllWorkorders();

  CommonLookUp fetchWorkorderById(UUID id);

  List<CommonLookUp> fetchAllBankDetails();

  CommonLookUp fetchBankDetailById(UUID id);

  List<CommonLookUp> fetchAllCustomerDetails();

  CommonLookUp fetchCustomerDetailsById(UUID id);

  List<CommonLookUp> fetchAllDemandNoteHistory();

  CommonLookUp fetchDemandNoteHistoryById(UUID id);

  List<CommonLookUp> fetchAllDemandNotes();

  CommonLookUp fetchDemandNoteById(UUID id);

  List<CommonLookUp> fetchAllDisbursements();

  CommonLookUp fetchDisbursementById(UUID id);

  List<CommonLookUp> fetchAllFeeders();

  CommonLookUp fetchFeederById(UUID id);

  List<CommonLookUp> fetchAllMasterData();

  CommonLookUp fetchMasterDataById(UUID id);
}
