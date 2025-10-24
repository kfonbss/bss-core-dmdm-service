package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.RoleType;
import in.gov.kfon.dmdm.model.Roles;
import in.gov.kfon.dmdm.model.RolesModules;
import in.gov.kfon.dmdm.repository.RoleTypeRepository;
import in.gov.kfon.dmdm.repository.RolesModulesRepository;
import in.gov.kfon.dmdm.repository.RolesRepository;
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

public class RoleServiceImplTest {

  @Mock private RoleTypeRepository roleTypeRepository;
  @Mock private RolesRepository rolesRepository;
  @Mock private RolesModulesRepository rolesModulesRepository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private RoleServiceImpl service;

  private UUID id;
  private RoleType roleType;
  private Roles role;
  private RolesModules rolesModule;
  private CommonLookUp commonLookUp;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    id = UUID.randomUUID();

    roleType = new RoleType();
    roleType.setId(id);
    roleType.setName("Admin");

    role = new Roles();
    role.setId(id);
    role.setName("SuperAdmin");

    rolesModule = new RolesModules();
    rolesModule.setId(id);
    rolesModule.setName("UserModule");

    commonLookUp = new CommonLookUp();
    commonLookUp.setId(id);
    commonLookUp.setName("TestName");
  }

  @Test
  void testFetchAllRoleTypes() {
    when(roleTypeRepository.findAll()).thenReturn(List.of(roleType));
    when(modelMapper.map(roleType, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllRoleTypes();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(roleTypeRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(roleType, CommonLookUp.class);
  }

  @Test
  void testFetchRoleTypeById_Success() {
    when(roleTypeRepository.findById(id)).thenReturn(Optional.of(roleType));
    when(modelMapper.map(roleType, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchRoleTypeById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(roleTypeRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(roleType, CommonLookUp.class);
  }

  @Test
  void testFetchRoleTypeById_NotFound() {
    when(roleTypeRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchRoleTypeById(id));

    assertEquals("RoleType not found with id: " + id, exception.getMessage());

    verify(roleTypeRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllRoles() {
    when(rolesRepository.findAll()).thenReturn(List.of(role));
    when(modelMapper.map(role, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllRoles();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(rolesRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(role, CommonLookUp.class);
  }

  @Test
  void testFetchRoleById_Success() {
    when(rolesRepository.findById(id)).thenReturn(Optional.of(role));
    when(modelMapper.map(role, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchRoleById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(rolesRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(role, CommonLookUp.class);
  }

  @Test
  void testFetchRoleById_NotFound() {
    when(rolesRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchRoleById(id));

    assertEquals("Role not found with id: " + id, exception.getMessage());

    verify(rolesRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllRolesModules() {
    when(rolesModulesRepository.findAll()).thenReturn(List.of(rolesModule));
    when(modelMapper.map(rolesModule, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllRolesModules();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(rolesModulesRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(rolesModule, CommonLookUp.class);
  }

  @Test
  void testFetchRolesModuleById_Success() {
    when(rolesModulesRepository.findById(id)).thenReturn(Optional.of(rolesModule));
    when(modelMapper.map(rolesModule, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchRolesModuleById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(rolesModulesRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(rolesModule, CommonLookUp.class);
  }

  @Test
  void testFetchRolesModuleById_NotFound() {
    when(rolesModulesRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchRolesModuleById(id));

    assertEquals("RolesModule not found with id: " + id, exception.getMessage());

    verify(rolesModulesRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }
}
