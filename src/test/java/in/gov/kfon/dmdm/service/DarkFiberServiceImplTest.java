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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

public class DarkFiberServiceImplTest {

  @Mock private DfGroupDetailsRepository dfGroupDetailsRepository;
  @Mock private DfGroupDetailsMoventRepository dfGroupDetailsMoventRepository;
  @Mock private DfGroupInvoiceRepository dfGroupInvoiceRepository;
  @Mock private DfGroupInvoiceMasterRepository dfGroupInvoiceMasterRepository;
  @Mock private DfLinkDetailsRepository dfLinkDetailsRepository;
  @Mock private DfLinkRenewalHistoryRepository dfLinkRenewalHistoryRepository;
  @Mock private DfPowerRatingRepository dfPowerRatingRepository;
  @Mock private DfPurchaseOrderRepository dfPurchaseOrderRepository;
  @Mock private DfSubFinanceRepository dfSubFinanceRepository;
  @Mock private DfRenewalDetailsRepository dfRenewalDetailsRepository;
  @Mock private DfSubscribersRepository dfSubscribersRepository;
  @Mock private DfTransRenewalDetailsRepository dfTransRenewalDetailsRepository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private DarkFiberServiceImpl service;

  private UUID id;
  private DfGroupDetails groupDetails;
  private DfGroupDetailsMovent groupMovement;
  private DfGroupInvoice invoice;
  private DfGroupInvoiceMaster master;
  private DfLinkDetails linkDetails;
  private DfLinkRenewalHistory renewalHistory;
  private DfPowerRating powerRating;
  private DfPurchaseOrder purchaseOrder;
  private DfSubFinance subFinance;
  private DfRenewalDetails renewalDetails;
  private DfSubscribers subscriber;
  private DfTransRenewalDetails transRenewalDetail;
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

    linkDetails = new DfLinkDetails();
    linkDetails.setDetailsId(id);
    linkDetails.setName("Test Link");
    linkDetails.setIsActive(true);

    renewalHistory = new DfLinkRenewalHistory();
    renewalHistory.setHistoryId(id);
    renewalHistory.setName("Test Link Renewal");
    renewalHistory.setIsActive(true);

    powerRating = new DfPowerRating();
    powerRating.setDfPowerRatingId(id);
    powerRating.setName("Power Rating 10KW");

    purchaseOrder = new DfPurchaseOrder();
    purchaseOrder.setDfPurchaseOrderId(id);
    purchaseOrder.setName("PO - 001");

    subFinance = new DfSubFinance();
    subFinance.setDfSubFinanceId(id);
    subFinance.setName("Finance Record");
    subFinance.setIsActive(true);

    renewalDetails = new DfRenewalDetails();
    renewalDetails.setDfRenewalDetailsId(id);
    renewalDetails.setName("Renewal Record");
    renewalDetails.setIsActive(true);

    subscriber = new DfSubscribers();
    subscriber.setDfSubscribersId(id);
    subscriber.setIsActive(true);
    subscriber.setCode("S001");
    subscriber.setName("Test Subscriber");
    subscriber.setNameInLocal("ടെസ്റ്റ് സബ്സ്ക്രൈബർ");

    transRenewalDetail = new DfTransRenewalDetails();
    transRenewalDetail.setDfTransRenewalDetailsId(id);
    transRenewalDetail.setIsActive(true);
    transRenewalDetail.setCode("TR001");
    transRenewalDetail.setName("Test Renewal");
    transRenewalDetail.setNameInLocal("ടെസ്റ്റ് റീന്യുവൽ");

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

  @Test
  void testFetchAllLinkDetails() {
    when(dfLinkDetailsRepository.findAll()).thenReturn(List.of(linkDetails));
    when(modelMapper.map(linkDetails, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllLinkDetails();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfLinkDetailsRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(linkDetails, CommonLookUp.class);
  }

  @Test
  void testFetchLinkDetailsById_Success() {
    when(dfLinkDetailsRepository.findByDetailsId(id)).thenReturn(Optional.of(linkDetails));
    when(modelMapper.map(linkDetails, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchLinkDetailsById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfLinkDetailsRepository, times(1)).findByDetailsId(id);
    verify(modelMapper, times(1)).map(linkDetails, CommonLookUp.class);
  }

  @Test
  void testFetchLinkDetailsById_NotFound() {
    when(dfLinkDetailsRepository.findByDetailsId(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchLinkDetailsById(id));

    assertEquals("Link Details not found with id: " + id, exception.getMessage());

    verify(dfLinkDetailsRepository, times(1)).findByDetailsId(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllLinkRenewalHistories() {
    when(dfLinkRenewalHistoryRepository.findAll()).thenReturn(List.of(renewalHistory));
    when(modelMapper.map(renewalHistory, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllLinkRenewalHistories();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfLinkRenewalHistoryRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(renewalHistory, CommonLookUp.class);
  }

  @Test
  void testFetchLinkRenewalHistoryById_Success() {
    when(dfLinkRenewalHistoryRepository.findByHistoryId(id))
        .thenReturn(Optional.of(renewalHistory));
    when(modelMapper.map(renewalHistory, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchLinkRenewalHistoryById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfLinkRenewalHistoryRepository, times(1)).findByHistoryId(id);
    verify(modelMapper, times(1)).map(renewalHistory, CommonLookUp.class);
  }

  @Test
  void testFetchLinkRenewalHistoryById_NotFound() {
    when(dfLinkRenewalHistoryRepository.findByHistoryId(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> service.fetchLinkRenewalHistoryById(id));

    assertEquals("Link Renewal History not found with id: " + id, exception.getMessage());
    verify(dfLinkRenewalHistoryRepository, times(1)).findByHistoryId(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllPowerRatings() {
    when(dfPowerRatingRepository.findAll()).thenReturn(List.of(powerRating));
    when(modelMapper.map(powerRating, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllPowerRatings();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfPowerRatingRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(powerRating, CommonLookUp.class);
  }

  @Test
  void testFetchPowerRatingById_Success() {
    when(dfPowerRatingRepository.findByDfPowerRatingId(id)).thenReturn(Optional.of(powerRating));
    when(modelMapper.map(powerRating, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchPowerRatingById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfPowerRatingRepository, times(1)).findByDfPowerRatingId(id);
    verify(modelMapper, times(1)).map(powerRating, CommonLookUp.class);
  }

  @Test
  void testFetchPowerRatingById_NotFound() {
    when(dfPowerRatingRepository.findByDfPowerRatingId(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchPowerRatingById(id));

    assertEquals("Power Rating not found with id: " + id, exception.getMessage());
    verify(dfPowerRatingRepository, times(1)).findByDfPowerRatingId(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllPurchaseOrders() {
    when(dfPurchaseOrderRepository.findAll()).thenReturn(List.of(purchaseOrder));
    when(modelMapper.map(purchaseOrder, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllPurchaseOrders();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfPurchaseOrderRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(purchaseOrder, CommonLookUp.class);
  }

  @Test
  void testFetchPurchaseOrderById_Success() {
    when(dfPurchaseOrderRepository.findByDfPurchaseOrderId(id))
        .thenReturn(Optional.of(purchaseOrder));
    when(modelMapper.map(purchaseOrder, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchPurchaseOrderById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfPurchaseOrderRepository, times(1)).findByDfPurchaseOrderId(id);
    verify(modelMapper, times(1)).map(purchaseOrder, CommonLookUp.class);
  }

  @Test
  void testFetchPurchaseOrderById_NotFound() {
    when(dfPurchaseOrderRepository.findByDfPurchaseOrderId(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchPurchaseOrderById(id));

    assertEquals("Purchase Order not found with id: " + id, exception.getMessage());
    verify(dfPurchaseOrderRepository, times(1)).findByDfPurchaseOrderId(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllRenewalDetails() {
    when(dfRenewalDetailsRepository.findAll()).thenReturn(List.of(renewalDetails));
    when(modelMapper.map(renewalDetails, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllRenewalDetails();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfRenewalDetailsRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(renewalDetails, CommonLookUp.class);
  }

  @Test
  void testFetchRenewalDetailById_Success() {
    when(dfRenewalDetailsRepository.findByDfRenewalDetailsId(id))
        .thenReturn(Optional.of(renewalDetails));
    when(modelMapper.map(renewalDetails, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchRenewalDetailsById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfRenewalDetailsRepository, times(1)).findByDfRenewalDetailsId(id);
    verify(modelMapper, times(1)).map(renewalDetails, CommonLookUp.class);
  }

  @Test
  void testFetchRenewalDetailById_NotFound() {
    when(dfRenewalDetailsRepository.findByDfRenewalDetailsId(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchRenewalDetailsById(id));

    assertEquals("Renewal Detail not found with id: " + id, exception.getMessage());
    verify(dfRenewalDetailsRepository, times(1)).findByDfRenewalDetailsId(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllSubFinances() {
    when(dfSubFinanceRepository.findAll()).thenReturn(List.of(subFinance));
    when(modelMapper.map(subFinance, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllSubFinance();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfSubFinanceRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(subFinance, CommonLookUp.class);
  }

  @Test
  void testFetchSubFinanceById_Success() {
    when(dfSubFinanceRepository.findByDfSubFinanceId(id)).thenReturn(Optional.of(subFinance));
    when(modelMapper.map(subFinance, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchSubFinanceById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfSubFinanceRepository, times(1)).findByDfSubFinanceId(id);
    verify(modelMapper, times(1)).map(subFinance, CommonLookUp.class);
  }

  @Test
  void testFetchSubFinanceById_NotFound() {
    when(dfSubFinanceRepository.findByDfSubFinanceId(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchSubFinanceById(id));

    assertEquals("SubFinance not found with id: " + id, exception.getMessage());
    verify(dfSubFinanceRepository, times(1)).findByDfSubFinanceId(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllSubscribers() {
    when(dfSubscribersRepository.findAll()).thenReturn(List.of(subscriber));
    when(modelMapper.map(subscriber, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllSubscribers();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfSubscribersRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(subscriber, CommonLookUp.class);
  }

  @Test
  void testFetchSubscriberById_Success() {
    when(dfSubscribersRepository.findById(id)).thenReturn(Optional.of(subscriber));
    when(modelMapper.map(subscriber, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchSubscriberById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfSubscribersRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(subscriber, CommonLookUp.class);
  }

  @Test
  void testFetchSubscriberById_NotFound() {
    when(dfSubscribersRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchSubscriberById(id));

    assertEquals("Subscriber not found with id: " + id, exception.getMessage());
    verify(dfSubscribersRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllTransRenewalDetails() {
    when(dfTransRenewalDetailsRepository.findAll()).thenReturn(List.of(transRenewalDetail));
    when(modelMapper.map(transRenewalDetail, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllTransRenewalDetails();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(dfTransRenewalDetailsRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(transRenewalDetail, CommonLookUp.class);
  }

  @Test
  void testFetchTransRenewalDetailById_Success() {
    when(dfTransRenewalDetailsRepository.findById(id)).thenReturn(Optional.of(transRenewalDetail));
    when(modelMapper.map(transRenewalDetail, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchTransRenewalDetailById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(dfTransRenewalDetailsRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(transRenewalDetail, CommonLookUp.class);
  }

  @Test
  void testFetchTransRenewalDetailById_NotFound() {
    when(dfTransRenewalDetailsRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchTransRenewalDetailById(id));

    assertEquals("Trans Renewal Detail not found with id: " + id, exception.getMessage());
    verify(dfTransRenewalDetailsRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }
}
