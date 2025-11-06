package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.InventoryService;
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
@ContextConfiguration(classes = {InventoryController.class})
class InventoryControllerTest {

  private MockMvc mockMvc;

  @MockBean private InventoryService service;

  @Autowired private InventoryController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("INV001");
    lookup.setName("Cisco");
    lookup.setNameInLocal("സിസ്കോ");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllDeviceMakes() throws Exception {
    when(service.fetchAllDeviceMakes()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/inventory/device-makes/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all device makes"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchDeviceMakeById() throws Exception {
    when(service.fetchDeviceMakeById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/inventory/device-make/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched device make"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllDeviceModels() throws Exception {
    when(service.fetchAllDeviceModels()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/inventory/device-models/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all device models"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchDeviceModelById() throws Exception {
    when(service.fetchDeviceModelById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/inventory/device-model/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched device model"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }
}
