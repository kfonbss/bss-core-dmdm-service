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

  @Test
  void testFetchAllDeviceReturnToOem() throws Exception {
    when(service.fetchAllDeviceReturns()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/inventory/returns/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all device return to OEM"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchDeviceReturnToOemById() throws Exception {
    when(service.fetchDeviceReturnById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/inventory/return/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched device return to OEM"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllDeviceStatuses() throws Exception {
    when(service.fetchAllDeviceStatuses()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/inventory/statuses/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all device statuses"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchDeviceStatusById() throws Exception {
    when(service.fetchDeviceStatusById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/inventory/status/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched device status"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testDeviceDetailsFetchAll() throws Exception {
    when(service.deviceDetailsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/device-details/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testDeviceDetailById() throws Exception {
    when(service.deviceDetailsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/device-detail/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testDeviceDetailsAuditsFetchAll() throws Exception {
    when(service.deviceDetailsAuditsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/device/details-audits/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testDetailsAuditById() throws Exception {
    when(service.deviceDetailsAuditsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/device/details-audit/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testFetchAllDeviceTypes() throws Exception {
    when(service.fetchAllDeviceTypes()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/inventory/device-types/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all device types"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchDeviceTypeById() throws Exception {
    when(service.fetchDeviceTypeById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/inventory/device-type/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched device type"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllDeviceVendors() throws Exception {
    when(service.fetchAllDeviceVendors()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/device-vendors/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all device vendors"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchDeviceVendorById() throws Exception {
    when(service.fetchDeviceVendorById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/device-vendor/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched device vendor"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testDeviceTransfersFetchAll() throws Exception {
    when(service.fetchAllDeviceTransferRequests()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/device-transfers/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testDeviceTransfersFetchById() throws Exception {
    when(service.fetchDeviceTransferRequestById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/device-transfer/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testDeviceMovementsFetchAll() throws Exception {
    when(service.fetchAllDeviceTransferMovements()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/device-movements/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testDeviceMovementsFetchById() throws Exception {
    when(service.fetchDeviceTransferMovementById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/device-movement/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testPoDetailsFetchAll() throws Exception {
    when(service.fetchAllPoDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/inventory/po-details/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all PO details"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testPoDetailFetchById() throws Exception {
    when(service.fetchPoDetailsById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/inventory/po-detail/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched PO detail"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testPoDocumentsFetchAll() throws Exception {
    when(service.fetchAllPoDocuments()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/po-documents/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all PO documents"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testPoDocumentFetchById() throws Exception {
    when(service.fetchPoDocumentById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/inventory/po-document/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched PO document"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testLnpDeviceRequestsFetchAll() throws Exception {
    when(service.fetchAllLnpDeviceRequests()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/lnp-device-requests/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all LNP device requests"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testLnpDeviceRequestFetchById() throws Exception {
    when(service.fetchLnpDeviceRequestById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/lnp-device-request/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched LNP device request"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testLnpDeviceRequestMovementsFetchAll() throws Exception {
    when(service.fetchAllLnpDeviceRequestMovements()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/lnp-device-request-movements/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all LNP device request movements"))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testLnpDeviceRequestMovementFetchById() throws Exception {
    when(service.fetchLnpDeviceRequestMovementById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/lnp-device-request-movement/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched LNP device request movement"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testDcCreditNoteFetchAll() throws Exception {
    when(service.dcCreditNoteFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/dc-credit-notes/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testDdcCreditNoteById() throws Exception {
    when(service.dcCreditNoteFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/dc-credit-note/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testDeviceConditionStatusFetchAll() throws Exception {
    when(service.deviceConditionStatusFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/device/condition-statuses/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testConditionStatuseById() throws Exception {
    when(service.deviceConditionStatusFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/device/condition-status/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testDeviceDetailsMovementFetchAll() throws Exception {
    when(service.deviceDetailsMovementFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/device/details-movements/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testDetailsMovementById() throws Exception {
    when(service.deviceDetailsMovementFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/device/details-movement/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }

  @Test
  void testKfonDcDeviceRequestsFetchAll() throws Exception {
    when(service.kfonDcDeviceRequestsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/inventory/kfon-dc/device-requests/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("INV001"));
  }

  @Test
  void testDevice_requestById() throws Exception {
    when(service.kfonDcDeviceRequestsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/inventory/kfon-dc/device-request/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("INV001"));
  }
}
