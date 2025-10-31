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

  List<CommonLookUp> fetchAllGstInvoices();

  CommonLookUp fetchGstInvoiceById(UUID id);

  List<CommonLookUp> fetchAllOnlineRecharges();

  CommonLookUp fetchOnlineRechargeById(UUID id);

  List<CommonLookUp> fetchAllPartnerReceipts();

  CommonLookUp fetchPartnerReceiptById(UUID id);

  List<CommonLookUp> fetchAllPartnerAccountReports();

  CommonLookUp fetchPartnerAccountReportById(UUID id);

  List<CommonLookUp> fetchAllPartnerDisbursements();

  CommonLookUp fetchPartnerDisbursementById(UUID id);

  List<CommonLookUp> fetchAllPartnerFinances();

  CommonLookUp fetchPartnerFinanceById(UUID id);

  List<CommonLookUp> fetchAllPartnerConfirmationsFromAgnp();

  CommonLookUp fetchPartnerConfirmationFromAgnpById(UUID id);

  List<CommonLookUp> fetchAllPartnerConfirmationMovements();

  CommonLookUp fetchPartnerConfirmationMovementById(UUID id);

  List<CommonLookUp> fetchAllGstValets();

  CommonLookUp fetchGstValetById(UUID id);

  List<CommonLookUp> fetchAllRevenues();

  CommonLookUp fetchRevenueById(UUID id);
}
