package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.SeCustomers;
import in.gov.kfon.dmdm.model.SeDisbursement;
import in.gov.kfon.dmdm.model.SeInvoice;
import in.gov.kfon.dmdm.model.SeInvoiceMaster;
import in.gov.kfon.dmdm.repository.SeCustomersRepository;
import in.gov.kfon.dmdm.repository.SeDisbursementRepository;
import in.gov.kfon.dmdm.repository.SeInvoiceMasterRepository;
import in.gov.kfon.dmdm.repository.SeInvoiceRepository;
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

  @BeforeEach
  void setUp() {
    modelMapper = spy(new ModelMapper());
    disbursementRepository = mock(SeDisbursementRepository.class);
    customersRepository = mock(SeCustomersRepository.class);
    invoiceMasterRepository = mock(SeInvoiceMasterRepository.class);
    invoiceRepository = mock(SeInvoiceRepository.class);
    service =
        new SpecialEventsServiceImpl(
            customersRepository,
            disbursementRepository,
            modelMapper,
            invoiceMasterRepository,
            invoiceRepository);
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
}
