package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.StateService;
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
@ContextConfiguration(classes = {StateController.class})
class StateControllerTest {

  private MockMvc mockMvc;

  @MockBean private StateService service;

  @Autowired private StateController controller;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  void testFetchAll() throws Exception {

    CommonLookUp state1 = new CommonLookUp();
    state1.setId(UUID.randomUUID());
    state1.setCode("001");
    state1.setName("Kerala");
    state1.setNameInLocal("കേരളം");
    state1.setIsActive(true);

    CommonLookUp state2 = new CommonLookUp();
    state2.setId(UUID.randomUUID());
    state2.setCode("002");
    state2.setName("Karnataka");
    state2.setNameInLocal("ಕರ್ನಾಟಕ");
    state2.setIsActive(true);

    List<CommonLookUp> responseList = List.of(state1, state2);

    when(service.fetchAll()).thenReturn(responseList);

    mockMvc
        .perform(get("/api/state/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(2));
  }

  @Test
  void testFetchById() throws Exception {
    UUID stateId = UUID.randomUUID();

    CommonLookUp state = new CommonLookUp();
    state.setId(stateId);
    state.setCode("001");
    state.setName("Kerala");
    state.setNameInLocal("കേരളം");
    state.setIsActive(true);

    when(service.fetchById(stateId)).thenReturn(state);

    mockMvc
        .perform(get("/api/state/{id}", stateId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(stateId.toString()))
        .andExpect(jsonPath("$.data.name").value("Kerala"))
        .andExpect(jsonPath("$.data.nameInLocal").value("കേരളം"))
        .andExpect(jsonPath("$.data.code").value("001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }
}
