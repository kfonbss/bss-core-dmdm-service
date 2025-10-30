package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.PartnerFinance2;
import in.gov.kfon.dmdm.model.PartnerTaxpayerLogs;
import in.gov.kfon.dmdm.repository.PartnerFinance2Repository;
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
  @Mock private ModelMapper modelMapper;

  @InjectMocks private PartnerServiceImpl service;

  private UUID id;
  private PartnerFinance2 finance;
  private PartnerTaxpayerLogs taxLog;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    id = UUID.randomUUID();

    finance = new PartnerFinance2();
    finance.setId(id);

    taxLog = new PartnerTaxpayerLogs();
    taxLog.setId(id);

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
}
