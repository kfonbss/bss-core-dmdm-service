package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.State;
import in.gov.kfon.dmdm.repository.StateRepository;
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

class StateServiceImplTest {

  @Mock private StateRepository repository;

  @Mock private ModelMapper modelMapper;

  @InjectMocks private StateServiceImpl service;

  private State state;
  private CommonLookUp commonLookUp;
  private UUID stateId;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    stateId = UUID.randomUUID();

    state = new State();
    state.setId(stateId);
    state.setCode("001");
    state.setName("Kerala");
    state.setNameInLocal("കേരളം");
    state.setIsActive(true);

    commonLookUp = new CommonLookUp();
    commonLookUp.setId(stateId);
    commonLookUp.setCode("001");
    commonLookUp.setName("Kerala");
    commonLookUp.setNameInLocal("കേരളം");
    commonLookUp.setIsActive(true);
  }

  @Test
  void testFetchAll() {
    List<State> states = List.of(state);

    when(repository.findByIsActive(true)).thenReturn(states);
    when(modelMapper.map(state, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(stateId, result.get(0).getId());

    verify(repository, times(1)).findByIsActive(true);
    verify(modelMapper, times(1)).map(state, CommonLookUp.class);
  }

  @Test
  void testFetchById_Success() {
    when(repository.findById(stateId)).thenReturn(Optional.of(state));
    when(modelMapper.map(state, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchById(stateId);

    assertNotNull(result);
    assertEquals(stateId, result.getId());
    assertEquals("Kerala", result.getName());
    assertEquals("കേരളം", result.getNameInLocal());

    verify(repository, times(1)).findById(stateId);
    verify(modelMapper, times(1)).map(state, CommonLookUp.class);
  }

  @Test
  void testFetchById_NotFound() {
    when(repository.findById(stateId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchById(stateId));

    assertEquals("State not found with id: " + stateId, exception.getMessage());

    verify(repository, times(1)).findById(stateId);
    verifyNoInteractions(modelMapper);
  }
}
