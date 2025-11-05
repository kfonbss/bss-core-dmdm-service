package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.ServiceTypeService;
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
@ContextConfiguration(classes = {ServiceTypeController.class})
public class ServiceTypeControllerTest {

  private MockMvc mockMvc;

  @MockBean private ServiceTypeService service;

  @Autowired private ServiceTypeController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("ST01");
    lookup.setName("Internet");
    lookup.setNameInLocal("ഇന്റർനെറ്റ്");
    lookup.setIsActive(true);
  }

  @Test
  void fetchAllServiceTypesTest() throws Exception {
    when(service.fetchAllServiceTypes()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/service-types/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all service types"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void fetchServiceTypeByIdTest() throws Exception {
    when(service.fetchServiceTypeById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/service-type/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched service type"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void fetchAllServicesTest() throws Exception {
    UUID serviceId = UUID.randomUUID();
    var lookup = new CommonLookUp();
    lookup.setId(serviceId);
    lookup.setCode("INT");
    lookup.setName("Internet Service");
    lookup.setNameInLocal("ഇന്റർനെറ്റ് സേവനം");
    lookup.setIsActive(true);

    when(service.fetchAllServices()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/services/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all services"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void fetchServiceByIdTest() throws Exception {
    UUID serviceId = UUID.randomUUID();
    var lookup = new CommonLookUp();
    lookup.setId(serviceId);
    lookup.setCode("INT");
    lookup.setName("Internet Service");
    lookup.setNameInLocal("ഇന്റർനെറ്റ് സേവനം");
    lookup.setIsActive(true);

    when(service.fetchServiceById(serviceId)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/service/{id}", serviceId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched service"))
        .andExpect(jsonPath("$.data.id").value(serviceId.toString()));
  }
}
