package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.PartnerFinance2;
import in.gov.kfon.dmdm.model.PartnerGroup;
import in.gov.kfon.dmdm.model.PartnerGstDetail;
import in.gov.kfon.dmdm.model.PartnerTaxpayerLogs;
import in.gov.kfon.dmdm.repository.PartnerFinance2Repository;
import in.gov.kfon.dmdm.repository.PartnerGroupRepository;
import in.gov.kfon.dmdm.repository.PartnerGstDetailRepository;
import in.gov.kfon.dmdm.repository.PartnerTaxpayerLogsRepository;
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
  @Mock private ModelMapper modelMapper;

  @InjectMocks private PartnerServiceImpl service;

  private UUID id;
  private PartnerFinance2 finance;
  private PartnerTaxpayerLogs taxLog;
  private CommonLookUp lookup;
  private PartnerGroup group;
  private PartnerGstDetail gstDetail;

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
}
