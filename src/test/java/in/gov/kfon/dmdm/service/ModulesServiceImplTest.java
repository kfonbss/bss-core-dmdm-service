package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.Modules;
import in.gov.kfon.dmdm.repository.ModulesRepository;
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

class ModulesServiceImplTest {

  @Mock private ModulesRepository repository;

  @Mock private ModelMapper modelMapper;

  @InjectMocks private ModulesServiceImpl service;

  private Modules module;
  private CommonLookUp commonLookUp;
  private UUID moduleId;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    moduleId = UUID.randomUUID();

    module = new Modules();
    module.setId(moduleId);
    module.setModuleId(1);
    module.setCode("MOD001");
    module.setName("User Management");
    module.setNameInLocal("ഉപയോക്തൃ മാനേജ്മെന്റ്");
    module.setIsActive(true);
    module.setCategory("ADMIN");

    commonLookUp = new CommonLookUp();
    commonLookUp.setId(moduleId);
    commonLookUp.setCode("MOD001");
    commonLookUp.setName("User Management");
    commonLookUp.setNameInLocal("ഉപയോക്തൃ മാനേജ്മെന്റ്");
    commonLookUp.setIsActive(true);
  }

  @Test
  void testFetchAll() {
    List<Modules> modulesList = List.of(module);

    when(repository.findAll()).thenReturn(modulesList);
    when(modelMapper.map(module, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(moduleId, result.get(0).getId());

    verify(repository, times(1)).findAll();
    verify(modelMapper, times(1)).map(module, CommonLookUp.class);
  }

  @Test
  void testFetchById_Success() {
    when(repository.findById(moduleId)).thenReturn(Optional.of(module));
    when(modelMapper.map(module, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchById(moduleId);

    assertNotNull(result);
    assertEquals(moduleId, result.getId());
    assertEquals("User Management", result.getName());
    assertEquals("ഉപയോക്തൃ മാനേജ്മെന്റ്", result.getNameInLocal());

    verify(repository, times(1)).findById(moduleId);
    verify(modelMapper, times(1)).map(module, CommonLookUp.class);
  }

  @Test
  void testFetchById_NotFound() {
    when(repository.findById(moduleId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchById(moduleId));

    assertEquals("Modules not found with id: " + moduleId, exception.getMessage());

    verify(repository, times(1)).findById(moduleId);
    verifyNoInteractions(modelMapper);
  }
}
