package in.gov.kfon.dmdm.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.SpecialEventsServiceImpl;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpecialEventsController.class})
class SpecialEventsControllerTest {
  private MockMvc mockMvc;

  @MockBean private SpecialEventsServiceImpl service;

  @Autowired private SpecialEventsController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("SE123");
    lookup.setName("Special Events");
    lookup.setNameInLocal("സ്പെഷ്യൽ ഇവെന്റ്സ് ");
    lookup.setIsActive(true);
  }

  @Test
  void testCustomersFetchAll() throws Exception {
    when(service.customersFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/special-events/customers/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("SE123"));
  }

  @Test
  void testCustomerById() throws Exception {
    when(service.customersFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/special-events/customer/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("SE123"));
  }

  @Test
  void testDisbursementFetchAll() throws Exception {
    when(service.disbursementFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/special-events/disbursements/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("SE123"));
  }

  @Test
  void testDisbursementById() throws Exception {
    when(service.disbursementFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/special-events/disbursement/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("SE123"));
  }
}
