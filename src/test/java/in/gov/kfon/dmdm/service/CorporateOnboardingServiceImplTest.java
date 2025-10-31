package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.repository.*;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class CorporateOnboardingServiceImplTest {

  private ModelMapper modelMapper;
  private CorporateEnquiryRepository enquiryRepository;
  private CorpLocationListRepository locationListRepository;
  private CeConnectionBreakupRepository connectionBreakupRepository;
  private CeConnectionBreakupMovementRepository movementRepository;
  private CeConnectionBreakupRevisionRepository breakupRevisionRepository;
  private CeCustomerRepository customerRepository;
  private CorporateOnboardingServiceImpl service;
  private CeDisbursementRepository disbursementRepository;
  private CeDisbursementHistoryRepository disbursementHistoryRepository;
  private CeDnoteMasterRepository dnoteMasterRepository;
  private CeDnoteRenewalHistoryRepository renewalHistoryRepository;
  private CeEodetailsRepository eodetailsRepository;
  private CeInovoiceRepository inovoiceRepository;
  private CeInovoiceMasterRepository inovoiceMasterRepository;
  private CeKycDetailsRepository kycDetailsRepository;
  private CeLocationMovementRepository locationMovementRepository;
  private CeLocationRenewalHistoryRepository locationRenewalHistoryRepository;
  private CeLocationsRepository locationsRepository;
  private CeOnlineApplicationRepository onlineApplicationRepository;
  private CeOtcInvoiceRepository invoiceRepository;
  private CePackageRepository packageRepository;
  private CeParentCustomersRepository parentCustomersRepository;
  private CePaymentHistoryRepository paymentHistoryRepository;
  private CePaymentKycDetailsRepository paymentKycDetailsRepository;
  private CePoMovementRepository poMovementRepository;
  private CeQuotationsRepository quotationsRepository;
  private CePurchaseOrderRepository purchaseOrderRepository;
  private CeQuotationsMovementRepository quotationsMovementRepository;
  private CeQuotationsRevisionRepository quotationsRevisionRepository;
  private CeRenewalDetailsRepository renewalDetailsRepository;
  private CeRevisionConnectionBreakupRepository revisionConnectionBreakupRepository;

  @BeforeEach
  void setUp() {
    modelMapper = spy(new ModelMapper());
    enquiryRepository = mock(CorporateEnquiryRepository.class);
    locationListRepository = mock(CorpLocationListRepository.class);
    connectionBreakupRepository = mock(CeConnectionBreakupRepository.class);
    movementRepository = mock(CeConnectionBreakupMovementRepository.class);
    breakupRevisionRepository = mock(CeConnectionBreakupRevisionRepository.class);
    customerRepository = mock(CeCustomerRepository.class);
    disbursementRepository = mock(CeDisbursementRepository.class);
    disbursementHistoryRepository = mock(CeDisbursementHistoryRepository.class);
    dnoteMasterRepository = mock(CeDnoteMasterRepository.class);
    renewalHistoryRepository = mock(CeDnoteRenewalHistoryRepository.class);
    eodetailsRepository = mock(CeEodetailsRepository.class);
    inovoiceRepository = mock(CeInovoiceRepository.class);
    inovoiceMasterRepository = mock(CeInovoiceMasterRepository.class);
    kycDetailsRepository = mock(CeKycDetailsRepository.class);
    locationMovementRepository = mock(CeLocationMovementRepository.class);
    locationRenewalHistoryRepository = mock(CeLocationRenewalHistoryRepository.class);
    locationsRepository = mock(CeLocationsRepository.class);
    onlineApplicationRepository = mock(CeOnlineApplicationRepository.class);
    invoiceRepository = mock(CeOtcInvoiceRepository.class);
    packageRepository = mock(CePackageRepository.class);
    parentCustomersRepository = mock(CeParentCustomersRepository.class);
    paymentHistoryRepository = mock(CePaymentHistoryRepository.class);
    paymentKycDetailsRepository = mock(CePaymentKycDetailsRepository.class);
    poMovementRepository = mock(CePoMovementRepository.class);
    quotationsRepository = mock(CeQuotationsRepository.class);
    purchaseOrderRepository = mock(CePurchaseOrderRepository.class);
    quotationsMovementRepository = mock(CeQuotationsMovementRepository.class);
    quotationsRevisionRepository = mock(CeQuotationsRevisionRepository.class);
    renewalDetailsRepository = mock(CeRenewalDetailsRepository.class);
    revisionConnectionBreakupRepository = mock(CeRevisionConnectionBreakupRepository.class);
    service =
        new CorporateOnboardingServiceImpl(
            modelMapper,
            enquiryRepository,
            locationListRepository,
            connectionBreakupRepository,
            movementRepository,
            breakupRevisionRepository,
            customerRepository,
            disbursementRepository,
            disbursementHistoryRepository,
            dnoteMasterRepository,
            renewalHistoryRepository,
            eodetailsRepository,
            inovoiceRepository,
            inovoiceMasterRepository,
            kycDetailsRepository,
            locationMovementRepository,
            locationRenewalHistoryRepository,
            locationsRepository,
            onlineApplicationRepository,
            invoiceRepository,
            packageRepository,
            parentCustomersRepository,
            paymentHistoryRepository,
            paymentKycDetailsRepository,
            poMovementRepository,
            quotationsRepository,
            purchaseOrderRepository,
            quotationsMovementRepository,
            quotationsRevisionRepository,
            renewalDetailsRepository,
            revisionConnectionBreakupRepository);

    service.setupMapper();
  }

  @Test
  void testFetchAll_ShouldReturnMappedList() {
    UUID id = UUID.randomUUID();
    CorporateEnquiry enquiry = new CorporateEnquiry();
    enquiry.setEnquiriesId(id);
    enquiry.setEmailId("test@example.com");

    when(enquiryRepository.findAll()).thenReturn(List.of(enquiry));

    List<CommonLookUp> result = service.fetchAll();

    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());
    verify(enquiryRepository, times(1)).findAll();
  }

  @Test
  void testFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CorporateEnquiry enquiry = new CorporateEnquiry();
    enquiry.setEnquiriesId(id);
    enquiry.setEmailId("test@example.com");

    when(enquiryRepository.findByEnquiriesId(id)).thenReturn(Optional.of(enquiry));

    CommonLookUp result = service.fetchById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(enquiryRepository, times(1)).findByEnquiriesId(id);
  }

  @Test
  void testFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(enquiryRepository.findByEnquiriesId(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchById(id));
  }

  @Test
  void testLocationFetchAll_ShouldReturnMappedList() {
    UUID id = UUID.randomUUID();
    CorpLocationList list = new CorpLocationList();
    list.setListId(id);
    list.setName("Location A");

    when(locationListRepository.findAll()).thenReturn(List.of(list));

    List<CommonLookUp> result = service.locationFetchAll();

    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());
    verify(locationListRepository, times(1)).findAll();
  }

  @Test
  void testLocationFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CorpLocationList list = new CorpLocationList();
    list.setListId(id);
    list.setName("HQ");

    when(locationListRepository.findByListId(id)).thenReturn(Optional.of(list));

    CommonLookUp result = service.locationFetchById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(locationListRepository, times(1)).findByListId(id);
  }

  @Test
  void testLocationFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(locationListRepository.findByListId(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.locationFetchById(id));
  }

  @Test
  void testConnectionsFetchAll_ShouldReturnMappedList() {
    CeConnectionBreakup breakup = new CeConnectionBreakup();
    breakup.setBreakupId(UUID.randomUUID());
    breakup.setCode("CON001");

    when(connectionBreakupRepository.findAll()).thenReturn(List.of(breakup));

    List<CommonLookUp> result = service.connectionsFetchAll();

    assertEquals(1, result.size());
    verify(connectionBreakupRepository, times(1)).findAll();
  }

  @Test
  void testConnectionFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeConnectionBreakup breakup = new CeConnectionBreakup();
    breakup.setBreakupId(id);

    when(connectionBreakupRepository.findById(id)).thenReturn(Optional.of(breakup));

    CommonLookUp result = service.connectionFetchById(id);

    assertNotNull(result);
    verify(connectionBreakupRepository, times(1)).findById(id);
  }

  @Test
  void testConnectionFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(connectionBreakupRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.connectionFetchById(id));
  }

  @Test
  void testMovementsFetchAll_ShouldReturnMappedList() {
    CeConnectionBreakupMovement movement = new CeConnectionBreakupMovement();
    movement.setMovementId(UUID.randomUUID());
    movement.setCode("MOV001");

    when(movementRepository.findAll()).thenReturn(List.of(movement));

    List<CommonLookUp> result = service.movementsFetchAll();

    assertEquals(1, result.size());
    verify(movementRepository, times(1)).findAll();
  }

  @Test
  void testMovementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeConnectionBreakupMovement movement = new CeConnectionBreakupMovement();
    movement.setMovementId(id);

    when(movementRepository.findById(id)).thenReturn(Optional.of(movement));

    CommonLookUp result = service.movementFetchById(id);

    assertNotNull(result);
    verify(movementRepository, times(1)).findById(id);
  }

  @Test
  void testMovementFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(movementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.movementFetchById(id));
  }

  @Test
  void testCMovementsFetchAll_ShouldReturnMappedList() {
    CeConnectionBreakupMovementRevision movement = new CeConnectionBreakupMovementRevision();
    movement.setRevisionId(UUID.randomUUID());

    when(breakupRevisionRepository.findAll()).thenReturn(List.of(movement));

    List<CommonLookUp> result = service.cMovementsFetchAll();

    assertEquals(1, result.size());
    verify(breakupRevisionRepository, times(1)).findAll();
  }

  @Test
  void testCMovementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeConnectionBreakupMovementRevision movement = new CeConnectionBreakupMovementRevision();
    movement.setRevisionId(id);

    when(breakupRevisionRepository.findById(id)).thenReturn(Optional.of(movement));

    CommonLookUp result = service.cMovementFetchById(id);

    assertNotNull(result);
    verify(breakupRevisionRepository, times(1)).findById(id);
  }

  @Test
  void testCMovementFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(breakupRevisionRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.cMovementFetchById(id));
  }

  @Test
  void testCustomerFetchAll_ShouldReturnMappedList() {
    CeCustomer customer = new CeCustomer();
    customer.setCustomerId(UUID.randomUUID());

    when(customerRepository.findAll()).thenReturn(List.of(customer));

    List<CommonLookUp> result = service.customersFetchAll();

    assertEquals(1, result.size());
    verify(customerRepository, times(1)).findAll();
  }

  @Test
  void testCustomerFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeCustomer customer = new CeCustomer();
    customer.setCustomerId(id);

    when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

    CommonLookUp result = service.customerFetchById(id);

    assertNotNull(result);
    verify(customerRepository, times(1)).findById(id);
  }

  @Test
  void testCustomerFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(customerRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.customerFetchById(id));
  }

  @Test
  void testDisbursementFetchAll_ShouldReturnMappedList() {
    CeDisbursement customer = new CeDisbursement();
    customer.setId(UUID.randomUUID());

    when(disbursementRepository.findAll()).thenReturn(List.of(customer));

    List<CommonLookUp> result = service.disbursementsFetchAll();

    assertEquals(1, result.size());
    verify(disbursementRepository, times(1)).findAll();
  }

  @Test
  void testDisbursementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeDisbursement customer = new CeDisbursement();
    customer.setId(id);

    when(disbursementRepository.findById(id)).thenReturn(Optional.of(customer));

    CommonLookUp result = service.disbursementFetchById(id);

    assertNotNull(result);
    verify(disbursementRepository, times(1)).findById(id);
  }

  @Test
  void testDisbursementFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(disbursementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.disbursementFetchById(id));
  }

  @Test
  void testDisbursementsHisFetchAll_ShouldReturnMappedList() {
    CeDisbursementHistory history = new CeDisbursementHistory();
    history.setHistoryId(UUID.randomUUID());

    when(disbursementHistoryRepository.findAll()).thenReturn(List.of(history));

    List<CommonLookUp> result = service.disbursementsHisFetchAll();

    assertEquals(1, result.size());
    verify(disbursementHistoryRepository, times(1)).findAll();
  }

  @Test
  void testDisbursementHisFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeDisbursementHistory history = new CeDisbursementHistory();
    history.setHistoryId(id);

    when(disbursementHistoryRepository.findById(id)).thenReturn(Optional.of(history));

    CommonLookUp result = service.disbursementHisFetchById(id);

    assertNotNull(result);
    verify(disbursementHistoryRepository, times(1)).findById(id);
  }

  @Test
  void testDisbursementHisFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(disbursementHistoryRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.disbursementHisFetchById(id));
  }

  @Test
  void testMastersFetchAll_ShouldReturnMappedList() {
    CeDnoteMaster master = new CeDnoteMaster();
    master.setMasterId(UUID.randomUUID());

    when(dnoteMasterRepository.findAll()).thenReturn(List.of(master));

    List<CommonLookUp> result = service.mastersFetchAll();

    assertEquals(1, result.size());
    verify(dnoteMasterRepository, times(1)).findAll();
  }

  @Test
  void testMasterFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeDnoteMaster master = new CeDnoteMaster();
    master.setMasterId(id);

    when(dnoteMasterRepository.findById(id)).thenReturn(Optional.of(master));

    CommonLookUp result = service.masterFetchById(id);

    assertNotNull(result);
    verify(dnoteMasterRepository, times(1)).findById(id);
  }

  @Test
  void testMasterFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(dnoteMasterRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.masterFetchById(id));
  }

  @Test
  void testRenewalsHistoryFetchAll_ShouldReturnMappedList() {
    CeDnoteRenewalHistory history = new CeDnoteRenewalHistory();
    history.setHistoryId(UUID.randomUUID());

    when(renewalHistoryRepository.findAll()).thenReturn(List.of(history));

    List<CommonLookUp> result = service.renewalsHistoryFetchAll();

    assertEquals(1, result.size());
    verify(renewalHistoryRepository, times(1)).findAll();
  }

  @Test
  void testRenewalsHistoryFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeDnoteRenewalHistory history = new CeDnoteRenewalHistory();
    history.setHistoryId(id);

    when(renewalHistoryRepository.findById(id)).thenReturn(Optional.of(history));

    CommonLookUp result = service.renewalHistoryFetchById(id);

    assertNotNull(result);
    verify(renewalHistoryRepository, times(1)).findById(id);
  }

  @Test
  void testRenewalsHistoryById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(renewalHistoryRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.renewalHistoryFetchById(id));
  }

  @Test
  void testEoDetailsFetchAll_ShouldReturnMappedList() {
    CeEodetails eodetails = new CeEodetails();
    eodetails.setEodetailsId(UUID.randomUUID());

    when(eodetailsRepository.findAll()).thenReturn(List.of(eodetails));

    List<CommonLookUp> result = service.eoDetailsFetchAll();

    assertEquals(1, result.size());
    verify(eodetailsRepository, times(1)).findAll();
  }

  @Test
  void testEoDetailFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeEodetails ceEodetails = new CeEodetails();
    ceEodetails.setEodetailsId(id);

    when(eodetailsRepository.findById(id)).thenReturn(Optional.of(ceEodetails));

    CommonLookUp result = service.eoDetailFetchById(id);

    assertNotNull(result);
    verify(eodetailsRepository, times(1)).findById(id);
  }

  @Test
  void testEoDetailFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(eodetailsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.eoDetailFetchById(id));
  }

  @Test
  void testInvoiceFetchAll_ShouldReturnMappedList() {
    CeInovoice inovoice = new CeInovoice();
    inovoice.setInovoiceId(UUID.randomUUID());

    when(inovoiceRepository.findAll()).thenReturn(List.of(inovoice));

    List<CommonLookUp> result = service.invoicesFetchAll();

    assertEquals(1, result.size());
    verify(inovoiceRepository, times(1)).findAll();
  }

  @Test
  void testInvoiceFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeInovoice inovoice = new CeInovoice();
    inovoice.setInovoiceId(id);

    when(inovoiceRepository.findById(id)).thenReturn(Optional.of(inovoice));

    CommonLookUp result = service.invoiceFetchById(id);

    assertNotNull(result);
    verify(inovoiceRepository, times(1)).findById(id);
  }

  @Test
  void testInoviceFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(inovoiceRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.invoiceFetchById(id));
  }

  @Test
  void testInvoiceMasterFetchAll_ShouldReturnMappedList() {
    CeInovoiceMaster inovoice = new CeInovoiceMaster();
    inovoice.setMasterId(UUID.randomUUID());

    when(inovoiceMasterRepository.findAll()).thenReturn(List.of(inovoice));

    List<CommonLookUp> result = service.invoiceMasterFetchAll();

    assertEquals(1, result.size());
    verify(inovoiceMasterRepository, times(1)).findAll();
  }

  @Test
  void testInvoiceMasterFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeInovoiceMaster inovoice = new CeInovoiceMaster();
    inovoice.setMasterId(id);

    when(inovoiceMasterRepository.findById(id)).thenReturn(Optional.of(inovoice));

    CommonLookUp result = service.invoiceMasterFetchById(id);

    assertNotNull(result);
    verify(inovoiceMasterRepository, times(1)).findById(id);
  }

  @Test
  void testInoviceMasterFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(inovoiceMasterRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.invoiceMasterFetchById(id));
  }

  @Test
  void testKycDetailsFetchAll_ShouldReturnMappedList() {
    CeKycDetails inovoice = new CeKycDetails();
    inovoice.setKycId(UUID.randomUUID());

    when(kycDetailsRepository.findAll()).thenReturn(List.of(inovoice));

    List<CommonLookUp> result = service.kycDetailsFetchAll();

    assertEquals(1, result.size());
    verify(kycDetailsRepository, times(1)).findAll();
  }

  @Test
  void testKycDetailsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeKycDetails inovoice = new CeKycDetails();
    inovoice.setKycId(id);

    when(kycDetailsRepository.findById(id)).thenReturn(Optional.of(inovoice));

    CommonLookUp result = service.kycDetailsFetchById(id);

    assertNotNull(result);
    verify(kycDetailsRepository, times(1)).findById(id);
  }

  @Test
  void testKycDetailsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(kycDetailsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.kycDetailsFetchById(id));
  }

  @Test
  void testLocationMovementFetchAll_ShouldReturnMappedList() {
    CeLocationMovement inovoice = new CeLocationMovement();
    inovoice.setMovementId(UUID.randomUUID());

    when(locationMovementRepository.findAll()).thenReturn(List.of(inovoice));

    List<CommonLookUp> result = service.locationMovementFetchAll();

    assertEquals(1, result.size());
    verify(locationMovementRepository, times(1)).findAll();
  }

  @Test
  void testLocationMovementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeLocationMovement inovoice = new CeLocationMovement();
    inovoice.setMovementId(id);

    when(locationMovementRepository.findById(id)).thenReturn(Optional.of(inovoice));

    CommonLookUp result = service.locationMovementFetchById(id);

    assertNotNull(result);
    verify(locationMovementRepository, times(1)).findById(id);
  }

  @Test
  void testLocationMovementFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(locationMovementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.locationMovementFetchById(id));
  }

  @Test
  void testLocationRenewalHistoryFetchAll_ShouldReturnMappedList() {
    CeLocationRenewalHistory history = new CeLocationRenewalHistory();
    history.setHistoryId(UUID.randomUUID());

    when(locationRenewalHistoryRepository.findAll()).thenReturn(List.of(history));

    List<CommonLookUp> result = service.locationRenewalHistoryFetchAll();

    assertEquals(1, result.size());
    verify(locationRenewalHistoryRepository, times(1)).findAll();
  }

  @Test
  void testLocationRenewalHistoryFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeLocationRenewalHistory history = new CeLocationRenewalHistory();
    history.setHistoryId(id);

    when(locationRenewalHistoryRepository.findById(id)).thenReturn(Optional.of(history));

    CommonLookUp result = service.locationRenewalHistoryFetchById(id);

    assertNotNull(result);
    verify(locationRenewalHistoryRepository, times(1)).findById(id);
  }

  @Test
  void testLocationRenewalHistoryFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(locationRenewalHistoryRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.locationRenewalHistoryFetchById(id));
  }

  @Test
  void testCeLocationsFetchAll_ShouldReturnMappedList() {
    CeLocations locations = new CeLocations();
    locations.setLocationsId(UUID.randomUUID());

    when(locationsRepository.findAll()).thenReturn(List.of(locations));

    List<CommonLookUp> result = service.locationsFetchAll();

    assertEquals(1, result.size());
    verify(locationsRepository, times(1)).findAll();
  }

  @Test
  void testCeLocationsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeLocations locations = new CeLocations();
    locations.setLocationsId(id);

    when(locationsRepository.findById(id)).thenReturn(Optional.of(locations));

    CommonLookUp result = service.locationsFetchById(id);

    assertNotNull(result);
    verify(locationsRepository, times(1)).findById(id);
  }

  @Test
  void testCeLocationsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(locationsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.locationFetchById(id));
  }

  @Test
  void testOnlineApplicationFetchAll_ShouldReturnMappedList() {
    CeOnlineApplication onlineApplication = new CeOnlineApplication();
    onlineApplication.setApplicationId(UUID.randomUUID());

    when(onlineApplicationRepository.findAll()).thenReturn(List.of(onlineApplication));

    List<CommonLookUp> result = service.onlineApplicationFetchAll();

    assertEquals(1, result.size());
    verify(onlineApplicationRepository, times(1)).findAll();
  }

  @Test
  void testOnlineApplicationFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeOnlineApplication onlineApplication = new CeOnlineApplication();
    onlineApplication.setApplicationId(id);

    when(onlineApplicationRepository.findById(id)).thenReturn(Optional.of(onlineApplication));

    CommonLookUp result = service.onlineApplicationFetchById(id);

    assertNotNull(result);
    verify(onlineApplicationRepository, times(1)).findById(id);
  }

  @Test
  void testOnlineApplicationFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(onlineApplicationRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.onlineApplicationFetchById(id));
  }

  @Test
  void testOtcInvoiceFetchAll_ShouldReturnMappedList() {
    CeOtcInvoice otcInvoice = new CeOtcInvoice();
    otcInvoice.setInvoiceId(UUID.randomUUID());

    when(invoiceRepository.findAll()).thenReturn(List.of(otcInvoice));

    List<CommonLookUp> result = service.otcInvoiceFetchAll();

    assertEquals(1, result.size());
    verify(invoiceRepository, times(1)).findAll();
  }

  @Test
  void testOtcInvoiceFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeOtcInvoice otcInvoice = new CeOtcInvoice();
    otcInvoice.setInvoiceId(id);

    when(invoiceRepository.findById(id)).thenReturn(Optional.of(otcInvoice));

    CommonLookUp result = service.otcInvoiceFetchById(id);

    assertNotNull(result);
    verify(invoiceRepository, times(1)).findById(id);
  }

  @Test
  void testOtcInvoiceFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(invoiceRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.invoiceMasterFetchById(id));
  }

  @Test
  void testPackageFetchAll_ShouldReturnMappedList() {
    CePackage pck = new CePackage();
    pck.setId(UUID.randomUUID());

    when(packageRepository.findAll()).thenReturn(List.of(pck));

    List<CommonLookUp> result = service.packageFetchAll();

    assertEquals(1, result.size());
    verify(packageRepository, times(1)).findAll();
  }

  @Test
  void testPackageFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CePackage cePackage = new CePackage();
    cePackage.setId(id);

    when(packageRepository.findById(id)).thenReturn(Optional.of(cePackage));

    CommonLookUp result = service.packageFetchById(id);

    assertNotNull(result);
    verify(packageRepository, times(1)).findById(id);
  }

  @Test
  void testPackageFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(packageRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.packageFetchById(id));
  }

  @Test
  void testParentCustomersFetchAll_ShouldReturnMappedList() {
    CeParentCustomers parentCustomers = new CeParentCustomers();
    parentCustomers.setCustomerId(UUID.randomUUID());

    when(parentCustomersRepository.findAll()).thenReturn(List.of(parentCustomers));

    List<CommonLookUp> result = service.parentCustomersFetchAll();

    assertEquals(1, result.size());
    verify(parentCustomersRepository, times(1)).findAll();
  }

  @Test
  void testParentCustomersFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeParentCustomers parentCustomers = new CeParentCustomers();
    parentCustomers.setCustomerId(id);

    when(parentCustomersRepository.findById(id)).thenReturn(Optional.of(parentCustomers));

    CommonLookUp result = service.parentCustomersFetchById(id);

    assertNotNull(result);
    verify(parentCustomersRepository, times(1)).findById(id);
  }

  @Test
  void testParentCustomersFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(parentCustomersRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.paymentHistoryFetchById(id));
  }

  @Test
  void testPaymentHistoryFetchAll_ShouldReturnMappedList() {
    CePaymentHistory paymentHistory = new CePaymentHistory();
    paymentHistory.setHistoryId(UUID.randomUUID());

    when(paymentHistoryRepository.findAll()).thenReturn(List.of(paymentHistory));

    List<CommonLookUp> result = service.paymentHistoryFetchAll();

    assertEquals(1, result.size());
    verify(paymentHistoryRepository, times(1)).findAll();
  }

  @Test
  void testPaymentHistoryFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CePaymentHistory paymentHistory = new CePaymentHistory();
    paymentHistory.setHistoryId(id);

    when(paymentHistoryRepository.findById(id)).thenReturn(Optional.of(paymentHistory));

    CommonLookUp result = service.paymentHistoryFetchById(id);

    assertNotNull(result);
    verify(paymentHistoryRepository, times(1)).findById(id);
  }

  @Test
  void testPaymentHistoryFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(paymentHistoryRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.paymentHistoryFetchById(id));
  }

  @Test
  void testPaymentKycDetailsFetchAll_ShouldReturnMappedList() {
    CePaymentKycDetails PaymentKycDetails = new CePaymentKycDetails();
    PaymentKycDetails.setDetailsId(UUID.randomUUID());

    when(paymentKycDetailsRepository.findAll()).thenReturn(List.of(PaymentKycDetails));

    List<CommonLookUp> result = service.paymentKycDetailsFetchAll();

    assertEquals(1, result.size());
    verify(paymentKycDetailsRepository, times(1)).findAll();
  }

  @Test
  void testPaymentKycDetailsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CePaymentKycDetails paymentKycDetails = new CePaymentKycDetails();
    paymentKycDetails.setDetailsId(id);

    when(paymentKycDetailsRepository.findById(id)).thenReturn(Optional.of(paymentKycDetails));

    CommonLookUp result = service.paymentKycDetailsFetchById(id);

    assertNotNull(result);
    verify(paymentKycDetailsRepository, times(1)).findById(id);
  }

  @Test
  void testPaymentKycDetailsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(paymentKycDetailsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.paymentKycDetailsFetchById(id));
  }

  @Test
  void testPoMovementFetchAll_ShouldReturnMappedList() {
    CePoMovement poMovement = new CePoMovement();
    poMovement.setMovementId(UUID.randomUUID());

    when(poMovementRepository.findAll()).thenReturn(List.of(poMovement));

    List<CommonLookUp> result = service.poMovementFetchAll();

    assertEquals(1, result.size());
    verify(poMovementRepository, times(1)).findAll();
  }

  @Test
  void testPoMovementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CePoMovement poMovement = new CePoMovement();
    poMovement.setMovementId(id);

    when(poMovementRepository.findById(id)).thenReturn(Optional.of(poMovement));

    CommonLookUp result = service.poMovementFetchById(id);

    assertNotNull(result);
    verify(poMovementRepository, times(1)).findById(id);
  }

  @Test
  void testPoMovementFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(poMovementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.poMovementFetchById(id));
  }

  @Test
  void testQuotationsFetchAll_ShouldReturnMappedList() {
    CeQuotations quotations = new CeQuotations();
    quotations.setQuoationsId(UUID.randomUUID());

    when(quotationsRepository.findAll()).thenReturn(List.of(quotations));

    List<CommonLookUp> result = service.quotationsFetchAll();

    assertEquals(1, result.size());
    verify(quotationsRepository, times(1)).findAll();
  }

  @Test
  void testQuotationsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeQuotations quotations = new CeQuotations();
    quotations.setQuoationsId(id);

    when(quotationsRepository.findById(id)).thenReturn(Optional.of(quotations));

    CommonLookUp result = service.quotationsFetchById(id);

    assertNotNull(result);
    verify(quotationsRepository, times(1)).findById(id);
  }

  @Test
  void testQuotationsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(quotationsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.quotationsFetchById(id));
  }

  @Test
  void testPurchaseOrderFetchAll_ShouldReturnMappedList() {
    CePurchaseOrder purchaseOrder = new CePurchaseOrder();
    purchaseOrder.setOrderId(UUID.randomUUID());

    when(purchaseOrderRepository.findAll()).thenReturn(List.of(purchaseOrder));

    List<CommonLookUp> result = service.purchaseOrderFetchAll();

    assertEquals(1, result.size());
    verify(purchaseOrderRepository, times(1)).findAll();
  }

  @Test
  void testPurchaseOrderFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CePurchaseOrder purchaseOrder = new CePurchaseOrder();
    purchaseOrder.setOrderId(id);

    when(purchaseOrderRepository.findById(id)).thenReturn(Optional.of(purchaseOrder));

    CommonLookUp result = service.purchaseOrderFetchById(id);

    assertNotNull(result);
    verify(purchaseOrderRepository, times(1)).findById(id);
  }

  @Test
  void testPurchaseOrderFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(purchaseOrderRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.purchaseOrderFetchById(id));
  }

  @Test
  void testQuotationsMovementFetchAll_ShouldReturnMappedList() {
    CeQuotationsMovement quotationsMovement = new CeQuotationsMovement();
    quotationsMovement.setMovementId(UUID.randomUUID());

    when(quotationsMovementRepository.findAll()).thenReturn(List.of(quotationsMovement));

    List<CommonLookUp> result = service.quotationsMovementFetchAll();

    assertEquals(1, result.size());
    verify(quotationsMovementRepository, times(1)).findAll();
  }

  @Test
  void testQuotationsMovementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeQuotationsMovement quotationsMovement = new CeQuotationsMovement();
    quotationsMovement.setMovementId(id);

    when(quotationsMovementRepository.findById(id)).thenReturn(Optional.of(quotationsMovement));

    CommonLookUp result = service.quotationsMovementFetchById(id);

    assertNotNull(result);
    verify(quotationsMovementRepository, times(1)).findById(id);
  }

  @Test
  void testQuotationsMovementFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(quotationsMovementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.quotationsMovementFetchById(id));
  }

  @Test
  void testQuotationsRevisionFetchAll_ShouldReturnMappedList() {
    CeQuotationsRevision quotationsRevision = new CeQuotationsRevision();
    quotationsRevision.setRevisionId(UUID.randomUUID());

    when(quotationsRevisionRepository.findAll()).thenReturn(List.of(quotationsRevision));

    List<CommonLookUp> result = service.quotationsRevisionFetchAll();

    assertEquals(1, result.size());
    verify(quotationsRevisionRepository, times(1)).findAll();
  }

  @Test
  void testQuotationsRevisionFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeQuotationsRevision quotationsRevision = new CeQuotationsRevision();
    quotationsRevision.setRevisionId(id);

    when(quotationsRevisionRepository.findById(id)).thenReturn(Optional.of(quotationsRevision));

    CommonLookUp result = service.quotationsRevisionFetchById(id);

    assertNotNull(result);
    verify(quotationsRevisionRepository, times(1)).findById(id);
  }

  @Test
  void testQuotationsRevisionFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(quotationsRevisionRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.quotationsRevisionFetchById(id));
  }

  @Test
  void testRenewalDetailsFetchAll_ShouldReturnMappedList() {
    CeRenewalDetails renewalDetails = new CeRenewalDetails();
    renewalDetails.setDetailsId(UUID.randomUUID());

    when(renewalDetailsRepository.findAll()).thenReturn(List.of(renewalDetails));

    List<CommonLookUp> result = service.renewalDetailsFetchAll();

    assertEquals(1, result.size());
    verify(renewalDetailsRepository, times(1)).findAll();
  }

  @Test
  void testRenewalDetailsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeRenewalDetails renewalDetails = new CeRenewalDetails();
    renewalDetails.setDetailsId(id);

    when(renewalDetailsRepository.findById(id)).thenReturn(Optional.of(renewalDetails));

    CommonLookUp result = service.renewalDetailsFetchById(id);

    assertNotNull(result);
    verify(renewalDetailsRepository, times(1)).findById(id);
  }

  @Test
  void testRenewalDetailsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(renewalDetailsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.renewalDetailsFetchById(id));
  }

  @Test
  void testRevisionConnectionBreakupFetchAll_ShouldReturnMappedList() {
    CeRevisionConnectionBreakup revisionConnectionBreakup = new CeRevisionConnectionBreakup();
    revisionConnectionBreakup.setBreakupId(UUID.randomUUID());

    when(revisionConnectionBreakupRepository.findAll())
        .thenReturn(List.of(revisionConnectionBreakup));

    List<CommonLookUp> result = service.revisionConnectionBreakupFetchAll();

    assertEquals(1, result.size());
    verify(revisionConnectionBreakupRepository, times(1)).findAll();
  }

  @Test
  void testRevisionConnectionBreakupFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeRevisionConnectionBreakup revisionConnectionBreakup = new CeRevisionConnectionBreakup();
    revisionConnectionBreakup.setBreakupId(id);

    when(revisionConnectionBreakupRepository.findById(id))
        .thenReturn(Optional.of(revisionConnectionBreakup));

    CommonLookUp result = service.revisionConnectionBreakupFetchById(id);

    assertNotNull(result);
    verify(revisionConnectionBreakupRepository, times(1)).findById(id);
  }

  @Test
  void testRevisionConnectionBreakupFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(revisionConnectionBreakupRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(
        EntityNotFoundException.class, () -> service.revisionConnectionBreakupFetchById(id));
  }
}
