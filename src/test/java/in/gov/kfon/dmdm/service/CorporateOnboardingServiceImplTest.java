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
            inovoiceRepository);

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
}
