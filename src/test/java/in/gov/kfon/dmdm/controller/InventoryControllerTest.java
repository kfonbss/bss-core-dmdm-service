package in.gov.kfon.dmdm.controller;

import static org.mockito.ArgumentMatchers.any;
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
import org.springframework.http.MediaType;
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

  @Test
  void testCreditNotesFetchAll() throws Exception {
    when(service.creditNotesFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/credit-notes/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testCreditNoteById() throws Exception {
    when(service.creditNotesFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/inventory/credit-note/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testDcCreditNotesFetchAll() throws Exception {
    when(service.dcCreditNotesFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/dc/credit-notes/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testDcCreditNoteById() throws Exception {
    when(service.dcCreditNotesFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/dc/credit-note/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testDeviceAcknowledgementFetchAll() throws Exception {
    when(service.deviceAcknowledgementFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/device-acknowledgements/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testDeviceAcknowledgementById() throws Exception {
    when(service.deviceAcknowledgementFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/device-acknowledgement/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testDeviceCatFetchAll() throws Exception {
    when(service.deviceCatFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/device-cats/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testDeviceCatById() throws Exception {
    when(service.deviceCatFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/inventory/device-cat/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }
}
