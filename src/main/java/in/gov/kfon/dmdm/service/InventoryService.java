package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface InventoryService {

  List<CommonLookUp> fetchAllDeviceMakes();

  CommonLookUp fetchDeviceMakeById(UUID id);

  List<CommonLookUp> fetchAllDeviceModels();

  CommonLookUp fetchDeviceModelById(UUID id);

  List<CommonLookUp> creditNotesFetchAll();

  CommonLookUp creditNotesFetchById(UUID id);

  List<CommonLookUp> dcCreditNotesFetchAll();

  CommonLookUp dcCreditNotesFetchById(UUID id);

  List<CommonLookUp> deviceAcknowledgementFetchAll();

  CommonLookUp deviceAcknowledgementFetchById(UUID id);

  List<CommonLookUp> deviceCatFetchAll();

  CommonLookUp deviceCatFetchById(UUID id);

  List<CommonLookUp> fetchAllDeviceReturns();

  CommonLookUp fetchDeviceReturnById(UUID id);

  List<CommonLookUp> fetchAllDeviceStatuses();

  CommonLookUp fetchDeviceStatusById(UUID id);

  List<CommonLookUp> deviceDetailsFetchAll();

  CommonLookUp deviceDetailsFetchById(UUID id);

  List<CommonLookUp> deviceDetailsAuditsFetchAll();

  CommonLookUp deviceDetailsAuditsFetchById(UUID id);

  List<CommonLookUp> fetchAllDeviceTypes();

  CommonLookUp fetchDeviceTypeById(UUID id);

  List<CommonLookUp> fetchAllDeviceVendors();

  CommonLookUp fetchDeviceVendorById(UUID id);

  List<CommonLookUp> fetchAllDeviceTransferRequests();

  CommonLookUp fetchDeviceTransferRequestById(UUID id);

  List<CommonLookUp> fetchAllDeviceTransferMovements();

  CommonLookUp fetchDeviceTransferMovementById(UUID id);

  List<CommonLookUp> fetchAllPoDetails();

  CommonLookUp fetchPoDetailsById(UUID id);

  List<CommonLookUp> fetchAllPoDocuments();

  CommonLookUp fetchPoDocumentById(UUID id);
}
