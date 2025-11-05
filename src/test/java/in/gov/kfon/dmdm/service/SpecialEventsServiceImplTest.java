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

  @BeforeEach
  void setUp() {
    modelMapper = spy(new ModelMapper());
    disbursementRepository = mock(SeDisbursementRepository.class);
    customersRepository = mock(SeCustomersRepository.class);
    invoiceMasterRepository = mock(SeInvoiceMasterRepository.class);
    invoiceRepository = mock(SeInvoiceRepository.class);
    kycDetailsRepository = mock(SeKycDetailsRepository.class);
    locationMovementRepository = mock(SeLocationMovementRepository.class);
    service =
        new SpecialEventsServiceImpl(
            customersRepository,
            disbursementRepository,
            modelMapper,
            invoiceMasterRepository,
            invoiceRepository,
            kycDetailsRepository,
            locationMovementRepository);
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
}
