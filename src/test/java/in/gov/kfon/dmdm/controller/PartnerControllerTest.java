package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.PartnerService;
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
@ContextConfiguration(classes = {PartnerController.class})
public class PartnerControllerTest {

  private MockMvc mockMvc;

  @MockBean private PartnerService service;

  @Autowired private PartnerController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("P001");
    lookup.setName("Partner Test");
    lookup.setNameInLocal("പാർട്ണർ ടെസ്റ്റ്");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllPartnerFinance() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllFinanceDetails()).thenReturn(list);

    mockMvc
        .perform(get("/api/partner/finances"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner financial details"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerFinanceById() throws Exception {
    when(service.fetchFinanceDetailsById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/finance/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner finance detail"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerTaxLogs() throws Exception {
    when(service.fetchAllTaxpayerLogs()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/taxpayer-logs"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner taxpayer logs"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerTaxLogById() throws Exception {
    when(service.fetchTaxpayerLogById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/taxpayer-log/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner taxpayer log"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerGroups() throws Exception {
    when(service.fetchAllPartnerGroups()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/groups"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner groups"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerGroupById() throws Exception {
    when(service.fetchPartnerGroupById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/group/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner group by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerGstDetails() throws Exception {
    when(service.fetchAllPartnerGstDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/gst-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner GST details"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerGstDetailById() throws Exception {
    when(service.fetchPartnerGstDetailById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/gst-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner GST detail by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllGstInvoices() throws Exception {
    when(service.fetchAllGstInvoices()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/gst-invoices"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner GST invoices"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchGstInvoiceById() throws Exception {
    when(service.fetchGstInvoiceById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/gst-invoice/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner GST invoice by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllOnlineRecharges() throws Exception {
    when(service.fetchAllOnlineRecharges()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/online-recharges"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner online recharges"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchOnlineRechargeById() throws Exception {
    when(service.fetchOnlineRechargeById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/online-recharge/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner online recharge by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerReceipts() throws Exception {
    when(service.fetchAllPartnerReceipts()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/receipts"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner receipts"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerReceiptById() throws Exception {
    when(service.fetchPartnerReceiptById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/receipt/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner receipt by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerAccountReports() throws Exception {
    when(service.fetchAllPartnerAccountReports()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/account-reports"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner account reports"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerAccountReportById() throws Exception {
    when(service.fetchPartnerAccountReportById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/account-report/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner account report by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerDisbursements() throws Exception {
    when(service.fetchAllPartnerDisbursements()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/disbursements"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner disbursements"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerDisbursementById() throws Exception {
    when(service.fetchPartnerDisbursementById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/disbursement/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner disbursement by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerFinanceRecords() throws Exception {
    when(service.fetchAllPartnerFinances()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/finance-records"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner finance records"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerFinanceRecordById() throws Exception {
    when(service.fetchPartnerFinanceById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/finance-record/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner finance record by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerConfirmations() throws Exception {
    when(service.fetchAllPartnerConfirmationsFromAgnp()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/confirmations"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner confirmations from AGNP"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerConfirmationById() throws Exception {
    when(service.fetchPartnerConfirmationFromAgnpById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/confirmation/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner confirmation from AGNP by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerConfirmationMovements() throws Exception {
    when(service.fetchAllPartnerConfirmationMovements()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/confirmation-movements"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner confirmation movements"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerConfirmationMovementById() throws Exception {
    when(service.fetchPartnerConfirmationMovementById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/confirmation-movement/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner confirmation movement by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllGstValets() throws Exception {
    when(service.fetchAllGstValets()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/gst-valets"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner GST valets"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchGstValetById() throws Exception {
    when(service.fetchGstValetById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/gst-valet/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner GST valet by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllRevenues() throws Exception {
    when(service.fetchAllRevenues()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/revenues"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner revenues"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchRevenueById() throws Exception {
    when(service.fetchRevenueById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/revenue/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner revenue by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerDetails() throws Exception {
    when(service.fetchAllPartnerDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner details"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerDetailById() throws Exception {
    when(service.fetchPartnerDetailById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner detail by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerAccounts() throws Exception {
    when(service.fetchAllAccounts()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/accounts"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner accounts"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerAccountById() throws Exception {
    when(service.fetchAccountById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/account/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner account by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }
}
