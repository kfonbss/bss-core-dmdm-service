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

class SpecialEventsServiceImplTest {
  private ModelMapper modelMapper;
  private SpecialEventsServiceImpl service;
  private SeDisbursementRepository disbursementRepository;
  private SeCustomersRepository customersRepository;
  private SeInvoiceMasterRepository invoiceMasterRepository;
  private SeInvoiceRepository invoiceRepository;
  private SeKycDetailsRepository kycDetailsRepository;
  private SeLocationMovementRepository locationMovementRepository;
  private SeLocationsRepository locationsRepository;
  private SeLocFinanceRepository locFinanceRepository;
  private SePaymentDetailsRepository paymentDetailsRepository;
  private SePaymentHistoryRepository paymentHistoryRepository;
  private SePoMovementRepository poMovementRepository;
  private SeProposalMovementRepository proposalMovementRepository;
  private SePurchaseOrderRepository purchaseOrderRepository;
  private SeProposalsRepository proposalsRepository;

  @BeforeEach
  void setUp() {
    modelMapper = spy(new ModelMapper());
    disbursementRepository = mock(SeDisbursementRepository.class);
    customersRepository = mock(SeCustomersRepository.class);
    invoiceMasterRepository = mock(SeInvoiceMasterRepository.class);
    invoiceRepository = mock(SeInvoiceRepository.class);
    kycDetailsRepository = mock(SeKycDetailsRepository.class);
    locationMovementRepository = mock(SeLocationMovementRepository.class);
    locationsRepository = mock(SeLocationsRepository.class);
    locFinanceRepository = mock(SeLocFinanceRepository.class);
    paymentDetailsRepository = mock(SePaymentDetailsRepository.class);
    paymentHistoryRepository = mock(SePaymentHistoryRepository.class);
    poMovementRepository = mock(SePoMovementRepository.class);
    proposalMovementRepository = mock(SeProposalMovementRepository.class);
    purchaseOrderRepository = mock(SePurchaseOrderRepository.class);
    proposalsRepository = mock(SeProposalsRepository.class);

    service =
        new SpecialEventsServiceImpl(
            customersRepository,
            disbursementRepository,
            modelMapper,
            invoiceMasterRepository,
            invoiceRepository,
            kycDetailsRepository,
            locationMovementRepository,
            locationsRepository,
            locFinanceRepository,
            paymentDetailsRepository,
            paymentHistoryRepository,
            poMovementRepository,
            proposalMovementRepository,
            purchaseOrderRepository,
            proposalsRepository);
    service.setupMapper();
  }

  @Test
  void testCustomersFetchAll_ShouldReturnMappedList() {
    SeCustomers customers = new SeCustomers();
    customers.setCustomerId(UUID.randomUUID());

    when(customersRepository.findAll()).thenReturn(List.of(customers));

    List<CommonLookUp> result = service.customersFetchAll();

    assertEquals(1, result.size());
    verify(customersRepository, times(1)).findAll();
  }

  @Test
  void testCustomersFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeCustomers customers = new SeCustomers();
    customers.setCustomerId(id);

    when(customersRepository.findById(id)).thenReturn(Optional.of(customers));

    CommonLookUp result = service.customersFetchById(id);

    assertNotNull(result);
    verify(customersRepository, times(1)).findById(id);
  }

  @Test
  void testCustomersFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(customersRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.customersFetchById(id));
  }

  @Test
  void testDisbursementFetchAll_ShouldReturnMappedList() {
    SeDisbursement disbursement = new SeDisbursement();
    disbursement.setId(UUID.randomUUID());

    when(disbursementRepository.findAll()).thenReturn(List.of(disbursement));

    List<CommonLookUp> result = service.disbursementFetchAll();

    assertEquals(1, result.size());
    verify(disbursementRepository, times(1)).findAll();
  }

  @Test
  void testDisbursementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeDisbursement disbursement = new SeDisbursement();
    disbursement.setId(id);

    when(disbursementRepository.findById(id)).thenReturn(Optional.of(disbursement));

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
  void testInvoiceMasterFetchAll_ShouldReturnMappedList() {
    SeInvoiceMaster invoiceMaster = new SeInvoiceMaster();
    invoiceMaster.setId(UUID.randomUUID());

    when(invoiceMasterRepository.findAll()).thenReturn(List.of(invoiceMaster));

    List<CommonLookUp> result = service.invoiceMasterFetchAll();

    assertEquals(1, result.size());
    verify(invoiceMasterRepository, times(1)).findAll();
  }

  @Test
  void testInvoiceMasterFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeInvoiceMaster invoiceMaster = new SeInvoiceMaster();
    invoiceMaster.setId(id);

    when(invoiceMasterRepository.findById(id)).thenReturn(Optional.of(invoiceMaster));

    CommonLookUp result = service.invoiceMasterFetchById(id);

    assertNotNull(result);
    verify(invoiceMasterRepository, times(1)).findById(id);
  }

  @Test
  void testInvoiceMasterFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(invoiceMasterRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.invoiceMasterFetchById(id));
  }

  @Test
  void testInvoiceFetchAll_ShouldReturnMappedList() {
    SeInvoice invoice = new SeInvoice();
    invoice.setId(UUID.randomUUID());

    when(invoiceRepository.findAll()).thenReturn(List.of(invoice));

    List<CommonLookUp> result = service.invoiceFetchAll();

    assertEquals(1, result.size());
    verify(invoiceRepository, times(1)).findAll();
  }

  @Test
  void testInvoiceFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeInvoice invoice = new SeInvoice();
    invoice.setId(id);

    when(invoiceRepository.findById(id)).thenReturn(Optional.of(invoice));

    CommonLookUp result = service.invoiceFetchById(id);

    assertNotNull(result);
    verify(invoiceRepository, times(1)).findById(id);
  }

  @Test
  void testInvoiceFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(invoiceRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.invoiceFetchById(id));
  }

  @Test
  void testKycDetailsFetchAll_ShouldReturnMappedList() {
    SeKycDetails kycDetails = new SeKycDetails();
    kycDetails.setDetailsId(UUID.randomUUID());

    when(kycDetailsRepository.findAll()).thenReturn(List.of(kycDetails));

    List<CommonLookUp> result = service.kycDetailsFetchAll();

    assertEquals(1, result.size());
    verify(kycDetailsRepository, times(1)).findAll();
  }

  @Test
  void testKycDetailsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeKycDetails kycDetails = new SeKycDetails();
    kycDetails.setDetailsId(id);

    when(kycDetailsRepository.findById(id)).thenReturn(Optional.of(kycDetails));

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
  void testLocationMovementsFetchAll_ShouldReturnMappedList() {
    SeLocationMovement locationMovements = new SeLocationMovement();
    locationMovements.setMovementId(UUID.randomUUID());

    when(locationMovementRepository.findAll()).thenReturn(List.of(locationMovements));

    List<CommonLookUp> result = service.locationMovementsFetchAll();

    assertEquals(1, result.size());
    verify(locationMovementRepository, times(1)).findAll();
  }

  @Test
  void testLocationMovementsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeLocationMovement locationMovements = new SeLocationMovement();
    locationMovements.setMovementId(id);

    when(locationMovementRepository.findById(id)).thenReturn(Optional.of(locationMovements));

    CommonLookUp result = service.locationMovementsFetchById(id);

    assertNotNull(result);
    verify(locationMovementRepository, times(1)).findById(id);
  }

  @Test
  void testLocationMovementsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(locationMovementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.locationMovementsFetchById(id));
  }

  @Test
  void testLocationsFetchAll_ShouldReturnMappedList() {
    SeLocations locations = new SeLocations();
    locations.setLocationId(UUID.randomUUID());

    when(locationsRepository.findAll()).thenReturn(List.of(locations));

    List<CommonLookUp> result = service.locationsFetchAll();

    assertEquals(1, result.size());
    verify(locationsRepository, times(1)).findAll();
  }

  @Test
  void testLocationsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeLocations locations = new SeLocations();
    locations.setLocationId(id);

    when(locationsRepository.findById(id)).thenReturn(Optional.of(locations));

    CommonLookUp result = service.locationsFetchById(id);

    assertNotNull(result);
    verify(locationsRepository, times(1)).findById(id);
  }

  @Test
  void testLocationsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(locationsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.locationsFetchById(id));
  }

  @Test
  void testLocFinanceFetchAll_ShouldReturnMappedList() {
    SeLocFinance locFinance = new SeLocFinance();
    locFinance.setFinanceId(UUID.randomUUID());

    when(locFinanceRepository.findAll()).thenReturn(List.of(locFinance));

    List<CommonLookUp> result = service.locFinanceFetchAll();

    assertEquals(1, result.size());
    verify(locFinanceRepository, times(1)).findAll();
  }

  @Test
  void testLocFinanceFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeLocFinance locFinance = new SeLocFinance();
    locFinance.setFinanceId(id);

    when(locFinanceRepository.findById(id)).thenReturn(Optional.of(locFinance));

    CommonLookUp result = service.locFinanceFetchById(id);

    assertNotNull(result);
    verify(locFinanceRepository, times(1)).findById(id);
  }

  @Test
  void testLocFinanceFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(locFinanceRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.locFinanceFetchById(id));
  }

  @Test
  void testPaymentDetailsFetchAll_ShouldReturnMappedList() {
    SePaymentDetails paymentDetails = new SePaymentDetails();
    paymentDetails.setDetailsId(UUID.randomUUID());

    when(paymentDetailsRepository.findAll()).thenReturn(List.of(paymentDetails));

    List<CommonLookUp> result = service.paymentDetailsFetchAll();

    assertEquals(1, result.size());
    verify(paymentDetailsRepository, times(1)).findAll();
  }

  @Test
  void testPaymentDetailsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SePaymentDetails paymentDetails = new SePaymentDetails();
    paymentDetails.setDetailsId(id);

    when(paymentDetailsRepository.findById(id)).thenReturn(Optional.of(paymentDetails));

    CommonLookUp result = service.paymentDetailsFetchById(id);

    assertNotNull(result);
    verify(paymentDetailsRepository, times(1)).findById(id);
  }

  @Test
  void testPaymentDetailsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(paymentDetailsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.paymentDetailsFetchById(id));
  }

  @Test
  void testPaymentHistoryFetchAll_ShouldReturnMappedList() {
    SePaymentHistory paymentHistory = new SePaymentHistory();
    paymentHistory.setHistoryId(UUID.randomUUID());

    when(paymentHistoryRepository.findAll()).thenReturn(List.of(paymentHistory));

    List<CommonLookUp> result = service.paymentHistoryFetchAll();

    assertEquals(1, result.size());
    verify(paymentHistoryRepository, times(1)).findAll();
  }

  @Test
  void testPaymentHistoryFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SePaymentHistory paymentHistory = new SePaymentHistory();
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
  void testPoMovementFetchAll_ShouldReturnMappedList() {
    SePoMovement poMovement = new SePoMovement();
    poMovement.setMovementId(UUID.randomUUID());

    when(poMovementRepository.findAll()).thenReturn(List.of(poMovement));

    List<CommonLookUp> result = service.poMovementFetchAll();

    assertEquals(1, result.size());
    verify(poMovementRepository, times(1)).findAll();
  }

  @Test
  void testPoMovementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SePoMovement poMovement = new SePoMovement();
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
  void testProposalMovementFetchAll_ShouldReturnMappedList() {
    SeProposalMovement proposalMovement = new SeProposalMovement();
    proposalMovement.setMovementId(UUID.randomUUID());

    when(proposalMovementRepository.findAll()).thenReturn(List.of(proposalMovement));

    List<CommonLookUp> result = service.proposalMovementFetchAll();

    assertEquals(1, result.size());
    verify(proposalMovementRepository, times(1)).findAll();
  }

  @Test
  void testProposalMovementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeProposalMovement proposalMovement = new SeProposalMovement();
    proposalMovement.setMovementId(id);

    when(proposalMovementRepository.findById(id)).thenReturn(Optional.of(proposalMovement));

    CommonLookUp result = service.proposalMovementFetchById(id);

    assertNotNull(result);
    verify(proposalMovementRepository, times(1)).findById(id);
  }

  @Test
  void testProposalMovementFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(proposalMovementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.proposalMovementFetchById(id));
  }

  @Test
  void testPurchaseOrderFetchAll_ShouldReturnMappedList() {
    SePurchaseOrder purchaseOrder = new SePurchaseOrder();
    purchaseOrder.setId(UUID.randomUUID());

    when(purchaseOrderRepository.findAll()).thenReturn(List.of(purchaseOrder));

    List<CommonLookUp> result = service.purchaseOrderFetchAll();

    assertEquals(1, result.size());
    verify(purchaseOrderRepository, times(1)).findAll();
  }

  @Test
  void testPurchaseOrderFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SePurchaseOrder purchaseOrder = new SePurchaseOrder();
    purchaseOrder.setId(id);

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
  void testProposalsFetchAll_ShouldReturnMappedList() {
    SeProposals proposals = new SeProposals();
    proposals.setProposalsId(UUID.randomUUID());

    when(proposalsRepository.findAll()).thenReturn(List.of(proposals));

    List<CommonLookUp> result = service.proposalsFetchAll();

    assertEquals(1, result.size());
    verify(proposalsRepository, times(1)).findAll();
  }

  @Test
  void testProposalsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    SeProposals proposals = new SeProposals();
    proposals.setProposalsId(id);

    when(proposalsRepository.findById(id)).thenReturn(Optional.of(proposals));

    CommonLookUp result = service.proposalsFetchById(id);

    assertNotNull(result);
    verify(proposalsRepository, times(1)).findById(id);
  }

  @Test
  void testProposalsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(proposalsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.proposalsFetchById(id));
  }
}
