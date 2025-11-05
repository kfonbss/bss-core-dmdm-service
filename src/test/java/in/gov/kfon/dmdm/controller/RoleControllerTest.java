package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.RoleService;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RoleController.class})
public class RoleControllerTest {

  private MockMvc mockMvc;

  @MockBean private RoleService service;

  @Autowired private RoleController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("001");
    lookup.setName("Admin");
    lookup.setNameInLocal("അഡ്മിൻ");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllRoleTypes() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllRoleTypes()).thenReturn(list);

    mockMvc
        .perform(get("/api/role-types/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all role types"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchRoleTypeById() throws Exception {
    when(service.fetchRoleTypeById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/role-type/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched role type"))
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.name").value("Admin"))
        .andExpect(jsonPath("$.data.nameInLocal").value("അഡ്മിൻ"))
        .andExpect(jsonPath("$.data.code").value("001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }

  @Test
  void testFetchAllRoles() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllRoles()).thenReturn(list);

    mockMvc
        .perform(get("/api/roles/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all roles"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchRoleById() throws Exception {
    when(service.fetchRoleById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/role/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched role"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllRolesModules() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllRolesModules()).thenReturn(list);

    mockMvc
        .perform(get("/api/roles-modules/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all roles modules"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchRolesModuleById() throws Exception {
    when(service.fetchRolesModuleById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/roles-module/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched roles module"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }
}
