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

  @Test
  void testInvoiceFetchAll() throws Exception {
    when(service.invoiceFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/special-events/invoices/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("SE123"));
  }

  @Test
  void testInvoiceById() throws Exception {
    when(service.invoiceFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/special-events/invoice/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("SE123"));
  }

  @Test
  void testInvoiceMasterFetchAll() throws Exception {
    when(service.invoiceMasterFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/special-events/invoice-masters/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("SE123"));
  }

  @Test
  void testInvoiceMasterById() throws Exception {
    when(service.invoiceMasterFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/special-events/invoice-master/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("SE123"));
  }

  @Test
  void testKycDetailsFetchAll() throws Exception {
    when(service.kycDetailsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/special-events/kyc-details/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("SE123"));
  }

  @Test
  void testKycDetailById() throws Exception {
    when(service.kycDetailsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/special-events/kyc-detail/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("SE123"));
  }

  @Test
  void testLocationMovementsFetchAll() throws Exception {
    when(service.locationMovementsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/special-events/location-movements/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("SE123"));
  }

  @Test
  void testLocationMovementById() throws Exception {
    when(service.locationMovementsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/special-events/location-movement/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("SE123"));
  }

  @Test
  void testLocationsFetchAll() throws Exception {
    when(service.locationsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/special-events/locations/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("SE123"));
  }

  @Test
  void testLocationById() throws Exception {
    when(service.locationsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/special-events/location/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("SE123"));
  }

  @Test
  void testLocFinanceFetchAll() throws Exception {
    when(service.locFinanceFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/special-events/loc-finances/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("SE123"));
  }

  @Test
  void testLocFinanceById() throws Exception {
    when(service.locFinanceFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/special-events/loc-finance/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("SE123"));
  }
}
