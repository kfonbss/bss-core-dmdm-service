package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface CorporateOnboardingService {
  List<CommonLookUp> fetchAll();

  CommonLookUp fetchById(UUID id);

  List<CommonLookUp> locationFetchAll();

  CommonLookUp locationFetchById(UUID id);

  List<CommonLookUp> connectionsFetchAll();

  CommonLookUp connectionFetchById(UUID id);

  List<CommonLookUp> movementsFetchAll();

  CommonLookUp movementFetchById(UUID id);

  List<CommonLookUp> cMovementsFetchAll();

  CommonLookUp cMovementFetchById(UUID id);

  List<CommonLookUp> customersFetchAll();

  CommonLookUp customerFetchById(UUID id);

  List<CommonLookUp> disbursementsFetchAll();

  CommonLookUp disbursementFetchById(UUID id);

  List<CommonLookUp> disbursementsHisFetchAll();

  CommonLookUp disbursementHisFetchById(UUID id);

  List<CommonLookUp> mastersFetchAll();

  CommonLookUp masterFetchById(UUID id);

  List<CommonLookUp> renewalsHistoryFetchAll();

  CommonLookUp renewalHistoryFetchById(UUID id);

  List<CommonLookUp> eoDetailsFetchAll();

  CommonLookUp eoDetailFetchById(UUID id);

  List<CommonLookUp> invoicesFetchAll();

  CommonLookUp invoiceFetchById(UUID id);

  List<CommonLookUp> invoiceMasterFetchAll();

  CommonLookUp invoiceMasterFetchById(UUID id);

  List<CommonLookUp> kycDetailsFetchAll();

  CommonLookUp kycDetailsFetchById(UUID id);

  List<CommonLookUp> locationMovementFetchAll();

  CommonLookUp locationMovementFetchById(UUID id);

  List<CommonLookUp> locationRenewalHistoryFetchAll();

  CommonLookUp locationRenewalHistoryFetchById(UUID id);

  List<CommonLookUp> locationsFetchAll();

  CommonLookUp locationsFetchById(UUID id);

  List<CommonLookUp> onlineApplicationFetchAll();

  CommonLookUp onlineApplicationFetchById(UUID id);

  List<CommonLookUp> otcInvoiceFetchAll();

  CommonLookUp otcInvoiceFetchById(UUID id);

  List<CommonLookUp> packageFetchAll();

  CommonLookUp packageFetchById(UUID id);

  List<CommonLookUp> parentCustomersFetchAll();

  CommonLookUp parentCustomersFetchById(UUID id);

  List<CommonLookUp> paymentHistoryFetchAll();

  CommonLookUp paymentHistoryFetchById(UUID id);

  List<CommonLookUp> paymentKycDetailsFetchAll();

  CommonLookUp paymentKycDetailsFetchById(UUID id);

  List<CommonLookUp> poMovementFetchAll();

  CommonLookUp poMovementFetchById(UUID id);

  List<CommonLookUp> quotationsFetchAll();

  CommonLookUp quotationsFetchById(UUID id);

  List<CommonLookUp> purchaseOrderFetchAll();

  CommonLookUp purchaseOrderFetchById(UUID id);

  List<CommonLookUp> quotationsMovementFetchAll();

  CommonLookUp quotationsMovementFetchById(UUID id);

  List<CommonLookUp> quotationsRevisionFetchAll();

  CommonLookUp quotationsRevisionFetchById(UUID id);

  List<CommonLookUp> renewalDetailsFetchAll();

  CommonLookUp renewalDetailsFetchById(UUID id);

  List<CommonLookUp> revisionConnectionBreakupFetchAll();

  CommonLookUp revisionConnectionBreakupFetchById(UUID id);

  List<CommonLookUp> servicesListFetchAll();

  CommonLookUp servicesListFetchById(UUID id);

  List<CommonLookUp> subCustomersFetchAll();

  CommonLookUp subCustomersFetchById(UUID id);
}
