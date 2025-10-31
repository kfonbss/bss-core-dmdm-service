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

public class PartnerServiceImplTest {

  @Mock private PartnerFinance2Repository partnerFinanceRepository;
  @Mock private PartnerTaxpayerLogsRepository partnerTaxpayerLogsRepository;
  @Mock private PartnerGroupRepository partnerGroupRepository;
  @Mock private PartnerGstDetailRepository partnerGstDetailRepository;
  @Mock private PartnerGstInvoiceRepository partnerGstInvoiceRepository;
  @Mock private PartnerOnlineRechargeRepository partnerOnlineRechargeRepository;
  @Mock private PartnerReceiptRepository partnerReceiptRepository;
  @Mock private PartnerAccountBalanceReportRepository partnerAccountBalanceReportRepository;
  @Mock private PartnerDisbursementRepository partnerDisbursementRepository;
  @Mock private PartnerFinanceRepository financeRepository;
  @Mock private PartnerConfirmationFromAgnpRepository partnerConfirmationRepository;
  @Mock private PartnerConfirmationFromAgnpMovementRepository partnerConfirmationMovementRepository;
  @Mock private PartnerGstValetRepository partnerGstValetRepository;
  @Mock private PartnerRevenueRepository partnerRevenueRepository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private PartnerServiceImpl service;

  private UUID id;
  private PartnerFinance2 finance;
  private PartnerTaxpayerLogs taxLog;
  private CommonLookUp lookup;
  private PartnerGroup group;
  private PartnerGstDetail gstDetail;
  private PartnerGstInvoice gstInvoice;
  private PartnerOnlineRecharge onlineRecharge;
  private PartnerReceipt receipt;
  private PartnerAccountBalanceReport accountReport;
  private PartnerDisbursement disbursement;
  private PartnerFinance financeEntity;
  private PartnerConfirmationFromAgnp confirmation;
  private PartnerConfirmationFromAgnpMovement confirmationMovement;
  private PartnerGstValet gstValet;
  private PartnerRevenue revenue;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    id = UUID.randomUUID();

    finance = new PartnerFinance2();
    finance.setId(id);

    taxLog = new PartnerTaxpayerLogs();
    taxLog.setId(id);

    group = new PartnerGroup();
    group.setId(id);

    gstDetail = new PartnerGstDetail();
    gstDetail.setId(id);

    gstInvoice = new PartnerGstInvoice();
    gstInvoice.setId(id);

    onlineRecharge = new PartnerOnlineRecharge();
    onlineRecharge.setRechargeId(id);

    receipt = new PartnerReceipt();
    receipt.setId(id);

    accountReport = new PartnerAccountBalanceReport();
    accountReport.setId(id);

    disbursement = new PartnerDisbursement();
    disbursement.setId(id);

    financeEntity = new PartnerFinance();
    financeEntity.setId(id);

    confirmation = new PartnerConfirmationFromAgnp();
    confirmation.setAgnpId(id);

    confirmationMovement = new PartnerConfirmationFromAgnpMovement();
    confirmationMovement.setMovementId(id);

    gstValet = new PartnerGstValet();
    gstValet.setId(id);

    revenue = new PartnerRevenue();
    revenue.setRevenueId(id);

    lookup = new CommonLookUp();
    lookup.setId(id);
  }

  @Test
  void testFetchAllPartnerFinance() {
    when(partnerFinanceRepository.findAll()).thenReturn(List.of(finance));
    when(modelMapper.map(finance, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllFinanceDetails();

    assertEquals(1, result.size());
    verify(partnerFinanceRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerFinanceById2_Success() {
    when(partnerFinanceRepository.findById(id)).thenReturn(Optional.of(finance));
    when(modelMapper.map(finance, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchFinanceDetailsById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
  }

  @Test
  void testFetchPartnerFinance2ById_NotFound() {
    when(partnerFinanceRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchFinanceDetailsById(id));
  }

  @Test
  void testFetchAllPartnerTaxLogs() {
    when(partnerTaxpayerLogsRepository.findAll()).thenReturn(List.of(taxLog));
    when(modelMapper.map(taxLog, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllTaxpayerLogs();

    assertEquals(1, result.size());
    verify(partnerTaxpayerLogsRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerTaxLogById_Success() {
    when(partnerTaxpayerLogsRepository.findById(id)).thenReturn(Optional.of(taxLog));
    when(modelMapper.map(taxLog, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchTaxpayerLogById(id);

    assertEquals(id, result.getId());
  }

  @Test
  void testFetchPartnerTaxLogById_NotFound() {
    when(partnerTaxpayerLogsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchTaxpayerLogById(id));
  }

  @Test
  void testFetchAllPartnerGroups() {
    when(partnerGroupRepository.findAll()).thenReturn(List.of(group));
    when(modelMapper.map(group, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllPartnerGroups();

    assertEquals(1, result.size());
    verify(partnerGroupRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerGroupById_Success() {
    when(partnerGroupRepository.findById(id)).thenReturn(Optional.of(group));
    when(modelMapper.map(group, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchPartnerGroupById(id);

    assertEquals(id, result.getId());
  }

  @Test
  void testFetchPartnerGroupById_NotFound() {
    when(partnerGroupRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchPartnerGroupById(id));
  }

  @Test
  void testFetchAllPartnerGstDetails() {
    when(partnerGstDetailRepository.findAll()).thenReturn(List.of(gstDetail));
    when(modelMapper.map(gstDetail, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllPartnerGstDetails();

    assertEquals(1, result.size());
    verify(partnerGstDetailRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerGstDetailById_Success() {
    when(partnerGstDetailRepository.findById(id)).thenReturn(Optional.of(gstDetail));
    when(modelMapper.map(gstDetail, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchPartnerGstDetailById(id);

    assertEquals(id, result.getId());
  }

  @Test
  void testFetchPartnerGstDetailById_NotFound() {
    when(partnerGstDetailRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchPartnerGstDetailById(id));
  }

  @Test
  void testFetchAllGstInvoices() {
    when(partnerGstInvoiceRepository.findAll()).thenReturn(List.of(gstInvoice));
    when(modelMapper.map(gstInvoice, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllGstInvoices();
    assertEquals(1, result.size());
    verify(partnerGstInvoiceRepository, times(1)).findAll();
  }

  @Test
  void testFetchGstInvoiceById_Success() {
    when(partnerGstInvoiceRepository.findById(id)).thenReturn(Optional.of(gstInvoice));
    when(modelMapper.map(gstInvoice, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchGstInvoiceById(id);
    assertEquals(id, result.getId());
  }

  @Test
  void testFetchGstInvoiceById_NotFound() {
    when(partnerGstInvoiceRepository.findById(id)).thenReturn(Optional.empty());
    assertThrows(EntityNotFoundException.class, () -> service.fetchGstInvoiceById(id));
  }

  @Test
  void testFetchAllOnlineRecharges() {
    when(partnerOnlineRechargeRepository.findAll()).thenReturn(List.of(onlineRecharge));
    when(modelMapper.map(onlineRecharge, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllOnlineRecharges();
    assertEquals(1, result.size());
    verify(partnerOnlineRechargeRepository, times(1)).findAll();
  }

  @Test
  void testFetchOnlineRechargeById_Success() {
    when(partnerOnlineRechargeRepository.findById(id)).thenReturn(Optional.of(onlineRecharge));
    when(modelMapper.map(onlineRecharge, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchOnlineRechargeById(id);
    assertEquals(id, result.getId());
  }

  @Test
  void testFetchOnlineRechargeById_NotFound() {
    when(partnerOnlineRechargeRepository.findById(id)).thenReturn(Optional.empty());
    assertThrows(EntityNotFoundException.class, () -> service.fetchOnlineRechargeById(id));
  }

  @Test
  void testFetchAllPartnerReceipts() {
    when(partnerReceiptRepository.findAll()).thenReturn(List.of(receipt));
    when(modelMapper.map(receipt, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllPartnerReceipts();

    assertEquals(1, result.size());
    verify(partnerReceiptRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerReceiptById_Success() {
    when(partnerReceiptRepository.findById(id)).thenReturn(Optional.of(receipt));
    when(modelMapper.map(receipt, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchPartnerReceiptById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(partnerReceiptRepository, times(1)).findById(id);
  }

  @Test
  void testFetchPartnerReceiptById_NotFound() {
    when(partnerReceiptRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchPartnerReceiptById(id));
    verify(partnerReceiptRepository, times(1)).findById(id);
  }

  @Test
  void testFetchAllPartnerAccountReports() {
    when(partnerAccountBalanceReportRepository.findAll()).thenReturn(List.of(accountReport));
    when(modelMapper.map(accountReport, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllPartnerAccountReports();

    assertEquals(1, result.size());
    verify(partnerAccountBalanceReportRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerAccountReportById_Success() {
    when(partnerAccountBalanceReportRepository.findById(id)).thenReturn(Optional.of(accountReport));
    when(modelMapper.map(accountReport, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchPartnerAccountReportById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(partnerAccountBalanceReportRepository, times(1)).findById(id);
  }

  @Test
  void testFetchPartnerAccountReportById_NotFound() {
    when(partnerAccountBalanceReportRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchPartnerAccountReportById(id));
    verify(partnerAccountBalanceReportRepository, times(1)).findById(id);
  }

  @Test
  void testFetchAllPartnerDisbursements() {
    when(partnerDisbursementRepository.findAll()).thenReturn(List.of(disbursement));
    when(modelMapper.map(disbursement, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllPartnerDisbursements();

    assertEquals(1, result.size());
    verify(partnerDisbursementRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerDisbursementById_Success() {
    when(partnerDisbursementRepository.findById(id)).thenReturn(Optional.of(disbursement));
    when(modelMapper.map(disbursement, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchPartnerDisbursementById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(partnerDisbursementRepository, times(1)).findById(id);
  }

  @Test
  void testFetchPartnerDisbursementById_NotFound() {
    when(partnerDisbursementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchPartnerDisbursementById(id));
    verify(partnerDisbursementRepository, times(1)).findById(id);
  }

  @Test
  void testFetchAllPartnerFinances() {
    when(financeRepository.findAll()).thenReturn(List.of(financeEntity));
    when(modelMapper.map(financeEntity, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllPartnerFinances();

    assertEquals(1, result.size());
    verify(financeRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerFinanceById_Success() {
    when(financeRepository.findById(id)).thenReturn(Optional.of(financeEntity));
    when(modelMapper.map(financeEntity, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchPartnerFinanceById(id);

    assertEquals(id, result.getId());
    verify(financeRepository, times(1)).findById(id);
  }

  @Test
  void testFetchPartnerFinanceById_NotFound() {
    when(partnerFinanceRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchPartnerFinanceById(id));
    verify(financeRepository, times(1)).findById(id);
  }

  @Test
  void testFetchAllPartnerConfirmations() {
    when(partnerConfirmationRepository.findAll()).thenReturn(List.of(confirmation));
    when(modelMapper.map(confirmation, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllPartnerConfirmationsFromAgnp();

    assertEquals(1, result.size());
    verify(partnerConfirmationRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerConfirmationById_Success() {
    when(partnerConfirmationRepository.findById(id)).thenReturn(Optional.of(confirmation));
    when(modelMapper.map(confirmation, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchPartnerConfirmationFromAgnpById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(partnerConfirmationRepository, times(1)).findById(id);
  }

  @Test
  void testFetchPartnerConfirmationById_NotFound() {
    when(partnerConfirmationRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(
        EntityNotFoundException.class, () -> service.fetchPartnerConfirmationFromAgnpById(id));
    verify(partnerConfirmationRepository, times(1)).findById(id);
  }

  @Test
  void testFetchAllPartnerConfirmationMovements() {
    when(partnerConfirmationMovementRepository.findAll()).thenReturn(List.of(confirmationMovement));
    when(modelMapper.map(confirmationMovement, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllPartnerConfirmationMovements();

    assertEquals(1, result.size());
    verify(partnerConfirmationMovementRepository, times(1)).findAll();
  }

  @Test
  void testFetchPartnerConfirmationMovementById_Success() {
    when(partnerConfirmationMovementRepository.findById(id))
        .thenReturn(Optional.of(confirmationMovement));
    when(modelMapper.map(confirmationMovement, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchPartnerConfirmationMovementById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(partnerConfirmationMovementRepository, times(1)).findById(id);
  }

  @Test
  void testFetchPartnerConfirmationMovementById_NotFound() {
    when(partnerConfirmationMovementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(
        EntityNotFoundException.class, () -> service.fetchPartnerConfirmationMovementById(id));
    verify(partnerConfirmationMovementRepository, times(1)).findById(id);
  }

  @Test
  void testFetchAllGstValets() {
    when(partnerGstValetRepository.findAll()).thenReturn(List.of(gstValet));
    when(modelMapper.map(gstValet, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllGstValets();

    assertEquals(1, result.size());
    verify(partnerGstValetRepository, times(1)).findAll();
  }

  @Test
  void testFetchGstValetById_Success() {
    when(partnerGstValetRepository.findById(id)).thenReturn(Optional.of(gstValet));
    when(modelMapper.map(gstValet, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchGstValetById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(partnerGstValetRepository, times(1)).findById(id);
  }

  @Test
  void testFetchGstValetById_NotFound() {
    when(partnerGstValetRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchGstValetById(id));
    verify(partnerGstValetRepository, times(1)).findById(id);
  }

  @Test
  void testFetchAllRevenues() {
    when(partnerRevenueRepository.findAll()).thenReturn(List.of(revenue));
    when(modelMapper.map(revenue, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchAllRevenues();

    assertEquals(1, result.size());
    verify(partnerRevenueRepository, times(1)).findAll();
  }

  @Test
  void testFetchRevenueById_Success() {
    when(partnerRevenueRepository.findById(id)).thenReturn(Optional.of(revenue));
    when(modelMapper.map(revenue, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchRevenueById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(partnerRevenueRepository, times(1)).findById(id);
  }

  @Test
  void testFetchRevenueById_NotFound() {
    when(partnerRevenueRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchRevenueById(id));
    verify(partnerRevenueRepository, times(1)).findById(id);
  }
}
