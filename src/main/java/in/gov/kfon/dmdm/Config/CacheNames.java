package in.gov.kfon.dmdm.Config;

/** Central registry of Redis cache names used across the dmdm service. */
public final class CacheNames {

  private CacheNames() {}

  // POP Master caches
  public static final String ALL_POP_MASTERS = "pop:allPopMasters";
  public static final String POP_MASTER_BY_ID = "pop:byId";
  public static final String ALL_POP_MASTER_BACKUPS = "pop:allBackups";
  public static final String POP_MASTER_BACKUP_BY_ID = "pop:backupById";
  public static final String ALL_DF_POP_LISTS = "pop:allDfPops";
  public static final String DF_POP_BY_ID = "pop:dfPopById";

  // Pincode and Post Office caches
  public static final String ALL_PINCODES = "pincode:allPincodes";
  public static final String PINCODE_BY_ID = "pincode:byId";
  public static final String ALL_PINCODE_DETAILS = "pincode:allDetails";
  public static final String PINCODE_DETAILS_BY_ID = "pincode:detailsById";
  public static final String POST_OFFICE_BY_PINCODE = "pincode:postOfficeByPincode";
  public static final String POST_OFFICE_DETAILS_BY_PINCODE = "pincode:postOfficeDetailsByPincode";
  public static final String PINCODE_DETAILS_BY_DISTRICT = "pincode:detailsByDistrict";
  public static final String PINCODE_DETAIL_BY_PINCODE = "pincode:detailByPincode";
  public static final String DISTRICT_DETAILS_BY_PINCODE = "pincode:districtDetailsByPincode";

  // State caches
  public static final String ALL_STATES = "state:all";
  public static final String STATE_BY_ID = "state:byId";
  public static final String STATES_BY_CODES = "state:byCodes";

  // District caches
  public static final String ALL_DISTRICTS = "district:all";
  public static final String DISTRICT_BY_ID = "district:byId";

  // Block detail caches
  public static final String BLOCK_CORPORATION_BY_DISTRICT = "block:corporationByDistrict";
  public static final String BLOCK_PANCHAYAT_BY_DISTRICT = "block:panchayatByDistrict";
  public static final String BLOCK_NAME_BY_DISTRICT = "block:blockNameByDistrict";
  public static final String BLOCK_BY_ID = "block:byId";

  // Package caches
  public static final String ALL_PACKAGE_MAPS = "package:allMaps";
  public static final String PACKAGE_MAP_BY_ID = "package:mapById";
  public static final String ALL_PACKAGE_CATEGORIES = "package:allCategories";
  public static final String PACKAGE_CATEGORY_BY_ID = "package:categoryById";
  public static final String ALL_PACKAGES = "package:allPackages";
  public static final String PACKAGES_BY_ID = "package:packagesById";
  public static final String ALL_PACKAGE = "package:all";
  public static final String PACKAGE_BY_ID = "package:byId";

  // Service type caches
  public static final String ALL_SERVICE_TYPES = "serviceType:all";
  public static final String SERVICE_TYPE_BY_ID = "serviceType:byId";
  public static final String ALL_SERVICES = "service:all";
  public static final String SERVICE_BY_ID = "service:byId";

  // ANP Users caches
  public static final String ALL_ANP_USERS = "anpUsers:all";

  // Role caches
  public static final String ALL_ROLE_TYPES = "role:allTypes";
  public static final String ROLE_TYPE_BY_ID = "role:typeById";
  public static final String ALL_ROLES = "role:all";
  public static final String ROLE_BY_ID = "role:byId";
  public static final String ALL_ROLES_MODULES = "role:allModules";
  public static final String ROLES_MODULE_BY_ID = "role:moduleById";

  // Modules caches
  public static final String ALL_MODULES = "modules:all";
  public static final String MODULE_BY_ID = "modules:byId";

  // Bank Details caches
  public static final String ALL_BANK_DETAILS = "bank:all";
  public static final String BANK_DETAILS_BY_ID = "bank:byId";
  public static final String BANK_DETAILS_BY_IFSC = "bank:byIfsc";

  // Tax caches
  public static final String ALL_SAMPLE_TAX = "tax:allSampleTax";
  public static final String SAMPLE_TAX_BY_ID = "tax:sampleTaxById";
  public static final String ALL_TAX_COLLECTIONS = "tax:allCollections";
  public static final String TAX_COLLECTION_BY_ID = "tax:collectionById";
  public static final String ALL_TAX_TYPES = "tax:allTypes";
  public static final String TAX_TYPES_BY_TYPE_ID = "tax:typesByTypeId";
  public static final String TAX_TYPE_BY_ID = "tax:typeById";
  public static final String ALL_TAX_DETAILS = "tax:allDetails";
  public static final String TAX_DETAIL_BY_ID = "tax:detailById";
  public static final String ACTIVE_TAX_DETAIL = "tax:activeDetail";
  public static final String ALL_TAX_PAYERS = "tax:allPayers";
  public static final String TAX_PAYER_BY_ID = "tax:payerById";
  public static final String ALL_TAX_DISBURSEMENTS = "tax:allDisbursements";
  public static final String TAX_DISBURSEMENT_BY_ID = "tax:disbursementById";
  public static final String ALL_TAX_DISTRIBUTIONS = "tax:allDistributions";
  public static final String TAX_DISTRIBUTION_BY_ID = "tax:distributionById";

  // Revenue caches
  public static final String ALL_REVENUE = "revenue:all";
  public static final String REVENUE_BY_ID = "revenue:byId";
  public static final String REVENUE_SHARE_BY_ID = "revenue:shareById";

  // Village Type caches
  public static final String VILLAGE_TYPE_BY_LOCATION = "villageType:byLocationType";

  // Company Detail caches
  public static final String ALL_COMPANY_DETAILS = "company:all";
  public static final String COMPANY_DETAIL_BY_ID = "company:byId";

  // Streetbox caches
  public static final String ALL_STREETBOXES = "streetbox:all";

  // CAF Details caches
  public static final String ALL_CAF_DETAILS = "caf:all";
  public static final String CAF_DETAIL_BY_ID = "caf:byId";

  // Inventory - master/reference data caches (1 hour)
  public static final String ALL_DEVICE_MAKES = "inv:allDeviceMakes";
  public static final String DEVICE_MAKE_BY_ID = "inv:deviceMakeById";
  public static final String ALL_DEVICE_MODELS = "inv:allDeviceModels";
  public static final String DEVICE_MODEL_BY_ID = "inv:deviceModelById";
  public static final String ALL_DEVICE_TYPES = "inv:allDeviceTypes";
  public static final String DEVICE_TYPE_BY_ID = "inv:deviceTypeById";
  public static final String ALL_DEVICE_VENDORS = "inv:allDeviceVendors";
  public static final String DEVICE_VENDOR_BY_ID = "inv:deviceVendorById";
  public static final String ALL_DEVICE_CATS = "inv:allDeviceCats";
  public static final String DEVICE_CAT_BY_ID = "inv:deviceCatById";
  public static final String ALL_DEVICE_STATUSES = "inv:allDeviceStatuses";
  public static final String DEVICE_STATUS_BY_ID = "inv:deviceStatusById";
  public static final String ALL_DEVICE_RETURNS = "inv:allDeviceReturns";
  public static final String DEVICE_RETURN_BY_ID = "inv:deviceReturnById";
  public static final String ALL_DEVICE_CONDITION_STATUSES = "inv:allDeviceConditionStatuses";
  public static final String DEVICE_CONDITION_STATUS_BY_ID = "inv:deviceConditionStatusById";

  // Inventory - transactional data caches (15 min)
  public static final String ALL_CREDIT_NOTES = "inv:allCreditNotes";
  public static final String CREDIT_NOTE_BY_ID = "inv:creditNoteById";
  public static final String ALL_DC_CREDIT_NOTES = "inv:allDcCreditNotes";
  public static final String DC_CREDIT_NOTES_BY_ID = "inv:dcCreditNotesById";
  public static final String ALL_DEVICE_ACKNOWLEDGEMENTS = "inv:allDeviceAcknowledgements";
  public static final String DEVICE_ACKNOWLEDGEMENT_BY_ID = "inv:deviceAcknowledgementById";
  public static final String ALL_DEVICE_DETAILS = "inv:allDeviceDetails";
  public static final String DEVICE_DETAILS_BY_ID = "inv:deviceDetailsById";
  public static final String ALL_DEVICE_DETAILS_AUDITS = "inv:allDeviceDetailsAudits";
  public static final String DEVICE_DETAILS_AUDIT_BY_ID = "inv:deviceDetailsAuditById";
  public static final String ALL_DEVICE_TRANSFER_REQUESTS = "inv:allDeviceTransferRequests";
  public static final String DEVICE_TRANSFER_REQUEST_BY_ID = "inv:deviceTransferRequestById";
  public static final String ALL_DEVICE_TRANSFER_MOVEMENTS = "inv:allDeviceTransferMovements";
  public static final String DEVICE_TRANSFER_MOVEMENT_BY_ID = "inv:deviceTransferMovementById";
  public static final String ALL_PO_DETAILS = "inv:allPoDetails";
  public static final String PO_DETAILS_BY_ID = "inv:poDetailsById";
  public static final String ALL_PO_DOCUMENTS = "inv:allPoDocuments";
  public static final String PO_DOCUMENT_BY_ID = "inv:poDocumentById";
  public static final String ALL_LNP_DEVICE_REQUESTS = "inv:allLnpDeviceRequests";
  public static final String LNP_DEVICE_REQUEST_BY_ID = "inv:lnpDeviceRequestById";
  public static final String ALL_LNP_DEVICE_REQUEST_MOVEMENTS = "inv:allLnpDeviceRequestMovements";
  public static final String LNP_DEVICE_REQUEST_MOVEMENT_BY_ID = "inv:lnpDeviceRequestMovementById";
  public static final String ALL_DC_CREDIT_NOTE = "inv:allDcCreditNote";
  public static final String DC_CREDIT_NOTE_BY_ID = "inv:dcCreditNoteById";
  public static final String ALL_KFON_DC_DEVICE_REQUESTS = "inv:allKfonDcDeviceRequests";
  public static final String KFON_DC_DEVICE_REQUEST_BY_ID = "inv:kfonDcDeviceRequestById";
  public static final String ALL_DEVICE_DETAILS_MOVEMENTS = "inv:allDeviceDetailsMovements";
  public static final String DEVICE_DETAILS_MOVEMENT_BY_ID = "inv:deviceDetailsMovementById";
  public static final String ALL_FAULTY_REQUESTS = "inv:allFaultyRequests";
  public static final String FAULTY_REQUEST_BY_ID = "inv:faultyRequestById";
}
