package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.SeCustomers;
import in.gov.kfon.dmdm.model.SeDisbursement;
import in.gov.kfon.dmdm.repository.SeCustomersRepository;
import in.gov.kfon.dmdm.repository.SeDisbursementRepository;
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

  @BeforeEach
  void setUp() {
    modelMapper = spy(new ModelMapper());
    disbursementRepository = mock(SeDisbursementRepository.class);
    customersRepository = mock(SeCustomersRepository.class);
    service =
        new SpecialEventsServiceImpl(customersRepository, disbursementRepository, modelMapper);
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
}
