package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.PincodeService;
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
@ContextConfiguration(classes = {PincodeController.class})
class PincodeControllerTest {

  private MockMvc mockMvc;

  @MockBean private PincodeService service;

  @Autowired private PincodeController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("P001");
    lookup.setName("Pincode Sample");
    lookup.setNameInLocal("പിന്കോഡ് സാമ്പിൾ");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllPincodes() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllPincodes()).thenReturn(list);

    mockMvc
        .perform(get("/api/pincode/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all pincodes"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchPincodeById() throws Exception {
    when(service.fetchPincodeById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/pincode/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched pincode"))
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.name").value("Pincode Sample"))
        .andExpect(jsonPath("$.data.nameInLocal").value("പിന്കോഡ് സാമ്പിൾ"))
        .andExpect(jsonPath("$.data.code").value("P001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }

  @Test
  void testFetchAllPincodeDetails() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllPincodeDetails()).thenReturn(list);

    mockMvc
        .perform(get("/api/pincode/details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all pincode details"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPincodeDetailById() throws Exception {
    when(service.fetchPincodeDetailsById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/pincode/detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched pincode detail"))
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.name").value("Pincode Sample"))
        .andExpect(jsonPath("$.data.nameInLocal").value("പിന്കോഡ് സാമ്പിൾ"))
        .andExpect(jsonPath("$.data.code").value("P001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }
}
