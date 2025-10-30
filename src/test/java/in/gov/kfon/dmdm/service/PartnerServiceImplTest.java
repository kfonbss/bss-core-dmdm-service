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
  void testFetchPartnerFinanceById_Success() {
    when(partnerFinanceRepository.findById(id)).thenReturn(Optional.of(finance));
    when(modelMapper.map(finance, CommonLookUp.class)).thenReturn(lookup);

    var result = service.fetchFinanceDetailsById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
  }

  @Test
  void testFetchPartnerFinanceById_NotFound() {
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

  // --- Partner Online Recharges ---
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
}
