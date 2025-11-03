package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.DarkFiberService;
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
@ContextConfiguration(classes = {DarkFiberController.class})
public class DarkFiberControllerTest {

  private MockMvc mockMvc;

  @MockBean private DarkFiberService service;

  @Autowired private DarkFiberController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("G001");
    lookup.setName("Fiber Group 1");
    lookup.setNameInLocal("ഫൈബർ ഗ്രൂപ്പ് 1");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllGroupDetails() throws Exception {
    when(service.fetchAllGroupDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/group-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all group details"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchGroupDetailsById() throws Exception {
    when(service.fetchGroupDetailsById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/group-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched group detail"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllGroupMovements() throws Exception {
    when(service.fetchAllGroupMovements()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/group-movements"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all group movements"));
  }

  @Test
  void testFetchGroupMovementById() throws Exception {
    when(service.fetchGroupMovementById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/group-movement/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched group movement"));
  }

  @Test
  void testFetchAllGroupInvoices() throws Exception {
    when(service.fetchAllGroupInvoices()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/group-invoices"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all group invoices"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchGroupInvoiceById() throws Exception {
    when(service.fetchGroupInvoiceById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/group-invoice/" + id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched invoice by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllGroupInvoiceMasters() throws Exception {
    when(service.fetchAllGroupInvoiceMasters()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/group-invoice-masters"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all invoice masters"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchGroupInvoiceMasterById() throws Exception {
    when(service.fetchGroupInvoiceMasterById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/group-invoice-master/" + id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched invoice master by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllLinkDetails() throws Exception {
    when(service.fetchAllLinkDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/link-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all link details"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchLinkDetailsById() throws Exception {
    when(service.fetchLinkDetailsById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/link-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched link detail by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllLinkRenewalHistories() throws Exception {
    when(service.fetchAllLinkRenewalHistories()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/link-renewal-histories"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all link renewal histories"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchLinkRenewalHistoryById() throws Exception {
    when(service.fetchLinkRenewalHistoryById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/link-renewal-history/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched link renewal history by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }
}
