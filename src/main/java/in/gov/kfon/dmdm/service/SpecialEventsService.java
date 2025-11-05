package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface SpecialEventsService {
  List<CommonLookUp> customersFetchAll();

  CommonLookUp customersFetchById(UUID id);

  List<CommonLookUp> disbursementFetchAll();

  CommonLookUp disbursementFetchById(UUID id);

  List<CommonLookUp> invoiceFetchAll();

  CommonLookUp invoiceFetchById(UUID id);

  List<CommonLookUp> invoiceMasterFetchAll();

  CommonLookUp invoiceMasterFetchById(UUID id);

  List<CommonLookUp> kycDetailsFetchAll();

  CommonLookUp kycDetailsFetchById(UUID id);

  List<CommonLookUp> locationMovementsFetchAll();

  CommonLookUp locationMovementsFetchById(UUID id);

  List<CommonLookUp> locationsFetchAll();

  CommonLookUp locationsFetchById(UUID id);

  List<CommonLookUp> locFinanceFetchAll();

  CommonLookUp locFinanceFetchById(UUID id);

  List<CommonLookUp> paymentDetailsFetchAll();

  CommonLookUp paymentDetailsFetchById(UUID id);

  List<CommonLookUp> paymentHistoryFetchAll();

  CommonLookUp paymentHistoryFetchById(UUID id);

  List<CommonLookUp> poMovementFetchAll();

  CommonLookUp poMovementFetchById(UUID id);

  List<CommonLookUp> proposalMovementFetchAll();

  CommonLookUp proposalMovementFetchById(UUID id);
}
