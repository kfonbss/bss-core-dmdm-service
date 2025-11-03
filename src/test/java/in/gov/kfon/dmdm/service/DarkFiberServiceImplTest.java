package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.DfGroupDetails;
import in.gov.kfon.dmdm.model.DfGroupDetailsMovent;
import in.gov.kfon.dmdm.repository.DfGroupDetailsMoventRepository;
import in.gov.kfon.dmdm.repository.DfGroupDetailsRepository;
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
  @Mock private ModelMapper modelMapper;

  @InjectMocks private DarkFiberServiceImpl service;

  private UUID id;
  private DfGroupDetails groupDetails;
  private DfGroupDetailsMovent groupMovement;
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
}
