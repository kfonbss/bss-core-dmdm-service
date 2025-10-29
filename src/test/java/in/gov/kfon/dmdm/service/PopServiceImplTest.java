package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.DfPopList;
import in.gov.kfon.dmdm.model.PopMaster;
import in.gov.kfon.dmdm.model.PopMasterBackup;
import in.gov.kfon.dmdm.repository.DfPopListRepository;
import in.gov.kfon.dmdm.repository.PopMasterBackupRepository;
import in.gov.kfon.dmdm.repository.PopMasterRepository;
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

class PopServiceImplTest {

  @Mock private PopMasterRepository popMasterRepository;
  @Mock private PopMasterBackupRepository popMasterBackupRepository;
  @Mock private DfPopListRepository dfPopListRepository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private PopServiceImpl service;

  private UUID id;
  private PopMaster popMaster;
  private PopMasterBackup popBackup;
  private CommonLookUp commonLookUp;

  private UUID dfPopListId;
  private DfPopList dfPopList;
  private CommonLookUp dfPopLookup;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    id = UUID.randomUUID();

    popMaster = new PopMaster();
    popMaster.setId(id);
    popMaster.setName("POP Master Sample");

    popBackup = new PopMasterBackup();
    popBackup.setId(id);
    popBackup.setName("POP Backup Sample");

    commonLookUp = new CommonLookUp();
    commonLookUp.setId(id);
    commonLookUp.setName("TestName");

    dfPopListId = UUID.randomUUID();
    dfPopList = new DfPopList();
    dfPopList.setId(dfPopListId);
    dfPopList.setName("Thiruvananthapuram POP");
    dfPopList.setNameInLocal("തിരുവനന്തപുരം POP");
    dfPopList.setCode("POP01");
    dfPopList.setIsActive(true);

    dfPopLookup = new CommonLookUp();
    dfPopLookup.setId(dfPopListId);
    dfPopLookup.setName("Thiruvananthapuram POP");
    dfPopLookup.setNameInLocal("തിരുവനന്തപുരം POP");
    dfPopLookup.setCode("POP01");
    dfPopLookup.setIsActive(true);
  }

  @Test
  void testFetchAllPopMaster() {
    when(popMasterRepository.findAll()).thenReturn(List.of(popMaster));
    when(modelMapper.map(popMaster, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllPopMasters();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(popMasterRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(popMaster, CommonLookUp.class);
  }

  @Test
  void testFetchPopMasterById_Success() {
    when(popMasterRepository.findById(id)).thenReturn(Optional.of(popMaster));
    when(modelMapper.map(popMaster, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchPopMasterById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(popMasterRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(popMaster, CommonLookUp.class);
  }

  @Test
  void testFetchPopMasterById_NotFound() {
    when(popMasterRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchPopMasterById(id));

    assertEquals("PopMaster not found with id: " + id, exception.getMessage());

    verify(popMasterRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllPopBackup() {
    when(popMasterBackupRepository.findAll()).thenReturn(List.of(popBackup));
    when(modelMapper.map(popBackup, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllPopMasterBackups();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(popMasterBackupRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(popBackup, CommonLookUp.class);
  }

  @Test
  void testFetchPopBackupById_Success() {
    when(popMasterBackupRepository.findById(id)).thenReturn(Optional.of(popBackup));
    when(modelMapper.map(popBackup, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchPopMasterBackupById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(popMasterBackupRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(popBackup, CommonLookUp.class);
  }

  @Test
  void testFetchPopBackupById_NotFound() {
    when(popMasterBackupRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchPopMasterBackupById(id));

    assertEquals("PopMasterBackup not found with id: " + id, exception.getMessage());

    verify(popMasterBackupRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }
}
