package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.DfGroupDetails;
import in.gov.kfon.dmdm.model.DfGroupDetailsMovent;
import in.gov.kfon.dmdm.model.DfGroupInvoice;
import in.gov.kfon.dmdm.model.DfGroupInvoiceMaster;
import in.gov.kfon.dmdm.repository.DfGroupDetailsMoventRepository;
import in.gov.kfon.dmdm.repository.DfGroupDetailsRepository;
import in.gov.kfon.dmdm.repository.DfGroupInvoiceMasterRepository;
import in.gov.kfon.dmdm.repository.DfGroupInvoiceRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

public class DarkFiberServiceImplTest {

  @Mock private DfGroupDetailsRepository dfGroupDetailsRepository;
  @Mock private DfGroupDetailsMoventRepository dfGroupDetailsMoventRepository;
  @Mock private DfGroupInvoiceRepository dfGroupInvoiceRepository;
  @Mock private DfGroupInvoiceMasterRepository dfGroupInvoiceMasterRepository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private DarkFiberServiceImpl service;

  private UUID id;
  private DfGroupDetails groupDetails;
  private DfGroupDetailsMovent groupMovement;
  private DfGroupInvoice invoice;
  private DfGroupInvoiceMaster master;
  private CommonLookUp commonLookUp;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    id = UUID.randomUUID();

    groupDetails = new DfGroupDetails();
    groupDetails.setDetailsId(id);
    groupDetails.setGroupName("Fiber Group A");

    groupMovement = new DfGroupDetailsMovent();
    groupMovement.setMoventId(id);
    groupMovement.setApproveStatus(1);

    invoice = new DfGroupInvoice();
    invoice.setId(id);
    invoice.setSubscriberId(10001L);
    invoice.setGroupId(201);

    master = new DfGroupInvoiceMaster();
    master.setMasterId(id);
    master.setSubscriberId(10001L);
    master.setGroupId(201);

    commonLookUp = new CommonLookUp();
    commonLookUp.setId(id);
    commonLookUp.setName("Test Lookup");
  }

  @Test
  void testFetchAllGroupDetails() {
    when(dfGroupDetailsRepository.findAll()).thenReturn(List.of(groupDetails));
    when(modelMapper.map(groupDetails, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllGroupDetails();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfGroupDetailsRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(groupDetails, CommonLookUp.class);
  }

  @Test
  void testFetchGroupDetailsById_Success() {
    when(dfGroupDetailsRepository.findByDetailsId(id)).thenReturn(Optional.of(groupDetails));
    when(modelMapper.map(groupDetails, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchGroupDetailsById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfGroupDetailsRepository, times(1)).findByDetailsId(id);
    verify(modelMapper, times(1)).map(groupDetails, CommonLookUp.class);
  }

  @Test
  void testFetchGroupDetailsById_NotFound() {
    when(dfGroupDetailsRepository.findByDetailsId(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchGroupDetailsById(id));

    assertEquals("Group Details not found with id: " + id, exception.getMessage());

    verify(dfGroupDetailsRepository, times(1)).findByDetailsId(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllGroupMovements() {
    when(dfGroupDetailsMoventRepository.findAll()).thenReturn(List.of(groupMovement));
    when(modelMapper.map(groupMovement, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllGroupMovements();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfGroupDetailsMoventRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(groupMovement, CommonLookUp.class);
  }

  @Test
  void testFetchGroupMovementById_Success() {
    when(dfGroupDetailsMoventRepository.findByMoventId(id)).thenReturn(Optional.of(groupMovement));
    when(modelMapper.map(groupMovement, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchGroupMovementById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfGroupDetailsMoventRepository, times(1)).findByMoventId(id);
    verify(modelMapper, times(1)).map(groupMovement, CommonLookUp.class);
  }

  @Test
  void testFetchGroupMovementById_NotFound() {
    when(dfGroupDetailsMoventRepository.findByMoventId(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchGroupMovementById(id));

    assertEquals("Group Movement not found with id: " + id, exception.getMessage());

    verify(dfGroupDetailsMoventRepository, times(1)).findByMoventId(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllGroupInvoices() {
    when(dfGroupInvoiceRepository.findAll()).thenReturn(List.of(invoice));
    when(modelMapper.map(invoice, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllGroupInvoices();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfGroupInvoiceRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invoice, CommonLookUp.class);
  }

  @Test
  void testFetchGroupInvoiceById_Success() {
    when(dfGroupInvoiceRepository.findById(id)).thenReturn(Optional.of(invoice));
    when(modelMapper.map(invoice, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchGroupInvoiceById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfGroupInvoiceRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invoice, CommonLookUp.class);
  }

  @Test
  void testFetchGroupInvoiceById_NotFound() {
    when(dfGroupInvoiceRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> service.fetchGroupInvoiceById(id));

    assertEquals("Group Invoice not found with id: " + id, exception.getMessage());
    verify(dfGroupInvoiceRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllGroupInvoiceMasters() {
    when(dfGroupInvoiceMasterRepository.findAll()).thenReturn(List.of(master));
    when(modelMapper.map(master, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllGroupInvoiceMasters();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfGroupInvoiceMasterRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(master, CommonLookUp.class);
  }

  @Test
  void testFetchGroupInvoiceMasterById_Success() {
    when(dfGroupInvoiceMasterRepository.findByMasterId(id)).thenReturn(Optional.of(master));
    when(modelMapper.map(master, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchGroupInvoiceMasterById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfGroupInvoiceMasterRepository, times(1)).findByMasterId(id);
    verify(modelMapper, times(1)).map(master, CommonLookUp.class);
  }

  @Test
  void testFetchGroupInvoiceMasterById_NotFound() {
    when(dfGroupInvoiceMasterRepository.findByMasterId(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> service.fetchGroupInvoiceMasterById(id));

    assertEquals("Group Invoice Master not found with id: " + id, exception.getMessage());
    verify(dfGroupInvoiceMasterRepository, times(1)).findByMasterId(id);
    verifyNoInteractions(modelMapper);
  }
}
