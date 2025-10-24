package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.ModulesService;
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
@ContextConfiguration(classes = {ModulesController.class})
class ModulesControllerTest {

  private MockMvc mockMvc;

  @MockBean private ModulesService service;

  @Autowired private ModulesController controller;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  void testFetchAll() throws Exception {
    CommonLookUp module1 = new CommonLookUp();
    module1.setId(UUID.randomUUID());
    module1.setCode("MOD001");
    module1.setName("User Management");
    module1.setNameInLocal("ഉപയോക്തൃ മാനേജ്മെന്റ്");
    module1.setIsActive(true);

    CommonLookUp module2 = new CommonLookUp();
    module2.setId(UUID.randomUUID());
    module2.setCode("MOD002");
    module2.setName("Reports");
    module2.setNameInLocal("റിപ്പോർട്ടുകൾ");
    module2.setIsActive(true);

    List<CommonLookUp> responseList = List.of(module1, module2);

    when(service.fetchAll()).thenReturn(responseList);

    mockMvc
        .perform(get("/api/modules/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(2));
  }

  @Test
  void testFetchById() throws Exception {
    UUID moduleId = UUID.randomUUID();

    CommonLookUp module = new CommonLookUp();
    module.setId(moduleId);
    module.setCode("MOD001");
    module.setName("User Management");
    module.setNameInLocal("ഉപയോക്തൃ മാനേജ്മെന്റ്");
    module.setIsActive(true);

    when(service.fetchById(moduleId)).thenReturn(module);

    mockMvc
        .perform(get("/api/modules/{id}", moduleId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(moduleId.toString()))
        .andExpect(jsonPath("$.data.code").value("MOD001"))
        .andExpect(jsonPath("$.data.name").value("User Management"))
        .andExpect(jsonPath("$.data.nameInLocal").value("ഉപയോക്തൃ മാനേജ്മെന്റ്"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }
}
