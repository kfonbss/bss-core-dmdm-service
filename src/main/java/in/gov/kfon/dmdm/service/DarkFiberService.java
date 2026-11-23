package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.DfFeederListResponse;
import in.gov.kfon.dmdm.contract.DfMasterDataResponse;
import in.gov.kfon.dmdm.contract.DfOtcChargeResponse;
import in.gov.kfon.dmdm.contract.DfPowerRatingResponse;
import java.time.LocalDate;
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

  List<DfPowerRatingResponse> fetchAllPowerRatings();

  CommonLookUp fetchPowerRatingById(UUID id);

  DfPowerRatingResponse fetchPowerRatingDetailById(UUID id);

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

  /** The POP's active feeders, by the POP's legacy id (df_pop_list.id). */
  List<DfFeederListResponse> fetchFeedersByPop(Integer popId);

  /** Feeders by their legacy ids (df_feeder_list.id), inactive ones too. */
  List<DfFeederListResponse> fetchFeedersByIds(List<Integer> ids);

  /** Moves the feeder's consumed strand count by delta (never below 0), by its legacy id. */
  DfFeederListResponse adjustFeederStrandsConsumed(Integer id, Integer delta);

  List<DfMasterDataResponse> fetchAllMasterData();

  CommonLookUp fetchMasterDataById(UUID id);

  DfMasterDataResponse fetchMasterDataDetailById(UUID id);

  DfMasterDataResponse adjustStrandsConsumed(UUID id, Integer delta);

  List<DfOtcChargeResponse> fetchAllOtcCharges();

  DfOtcChargeResponse fetchOtcChargeById(UUID id);

  DfOtcChargeResponse fetchCurrentOtcCharge();

  DfOtcChargeResponse fetchOtcChargeForDate(LocalDate date);

  List<CommonLookUp> fetchAllOtcInvoices();

  CommonLookUp fetchOtcInvoiceById(UUID id);

  List<CommonLookUp> fetchAllPaymentHistories();

  CommonLookUp fetchPaymentHistoryById(UUID id);
}
