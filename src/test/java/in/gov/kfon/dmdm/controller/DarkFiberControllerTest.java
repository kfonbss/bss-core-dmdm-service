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

  @Test
  void testFetchAllPowerRatings() throws Exception {
    when(service.fetchAllPowerRatings()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/power-ratings"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all power ratings"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchPowerRatingById() throws Exception {
    when(service.fetchPowerRatingById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/power-rating/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched power rating by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPurchaseOrders() throws Exception {
    when(service.fetchAllPurchaseOrders()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/purchase-orders"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all purchase orders"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchPurchaseOrderById() throws Exception {
    when(service.fetchPurchaseOrderById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/purchase-order/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched purchase order by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllRenewalDetails() throws Exception {
    when(service.fetchAllRenewalDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/renewal-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all renewal details"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchRenewalDetailById() throws Exception {
    when(service.fetchRenewalDetailsById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/renewal-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched renewal detail by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllSubFinances() throws Exception {
    when(service.fetchAllSubFinance()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/subfinances"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all sub finances"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchSubFinanceById() throws Exception {
    when(service.fetchSubFinanceById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/subfinance/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched sub finance by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllSubscribers() throws Exception {
    when(service.fetchAllSubscribers()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/subscribers"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscribers"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchSubscriberById() throws Exception {
    when(service.fetchSubscriberById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/subscriber/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllTransRenewalDetails() throws Exception {
    when(service.fetchAllTransRenewalDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/trans-renewal-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all trans renewal details"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchTransRenewalDetailById() throws Exception {
    when(service.fetchTransRenewalDetailById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/trans-renewal-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched trans renewal detail by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllTransDetails() throws Exception {
    when(service.fetchAllTransDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/trans-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all trans details"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchTransDetailById() throws Exception {
    when(service.fetchTransDetailsById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/trans-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched trans detail by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllTransMovements() throws Exception {
    when(service.fetchAllTransDetailsMovements()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/trans-movements"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all trans movements"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchTransMovementById() throws Exception {
    when(service.fetchTransDetailsMovementById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/trans-movement/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched trans movement by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllWorkorders() throws Exception {
    when(service.fetchAllWorkorders()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/workorders"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all workorders"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchWorkorderById() throws Exception {
    when(service.fetchWorkorderById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/workorder/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched workorder by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllBankDetails() throws Exception {
    when(service.fetchAllBankDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/bank-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all bank details"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchBankDetailById() throws Exception {
    when(service.fetchBankDetailById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/bank-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched bank detail by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllCustomerDetails() throws Exception {
    when(service.fetchAllCustomerDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/customer-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all customer details"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchCustomerDetailById() throws Exception {
    when(service.fetchCustomerDetailsById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/customer-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched customer detail by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllDemandNotes() throws Exception {
    when(service.fetchAllDemandNoteHistory()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/darkfiber/demand-notes"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all demand note history"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchDemandNoteById() throws Exception {
    when(service.fetchDemandNoteHistoryById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/darkfiber/demand-note/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched demand note history by ID"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }
}
