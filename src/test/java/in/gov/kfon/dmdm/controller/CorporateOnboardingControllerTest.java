package in.gov.kfon.dmdm.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.CorporateOnboardingService;
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
@ContextConfiguration(classes = {CorporateOnboardingController.class})
class CorporateOnboardingControllerTest {

  private MockMvc mockMvc;

  @MockBean private CorporateOnboardingService service;

  @Autowired private CorporateOnboardingController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("CORP001");
    lookup.setName("Tech Innovations Pvt Ltd");
    lookup.setNameInLocal("ടെക് ഇന്നവേഷൻസ് പ്രൈവറ്റ് ലിമിറ്റഡ്");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllCorporateEnquiries() throws Exception {
    when(service.fetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/corporate/enquires/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testFetchCorporateEnquiryById() throws Exception {
    when(service.fetchById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/enquiry/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testLocationFetchAll() throws Exception {
    CommonLookUp l1 = new CommonLookUp();
    l1.setId(UUID.randomUUID());
    l1.setName("Head Office");

    CommonLookUp l2 = new CommonLookUp();
    l2.setId(UUID.randomUUID());
    l2.setName("Branch Office");

    when(service.locationFetchAll()).thenReturn(List.of(l1, l2));

    mockMvc
        .perform(
            get("/api/corporate/location-lists/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].name").value("Head Office"))
        .andExpect(jsonPath("$.data[1].name").value("Branch Office"));
  }

  @Test
  void testLocationFetchById() throws Exception {
    when(service.locationFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/location-list/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testConnectionsFetchAll() throws Exception {
    when(service.connectionsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/connection/breakups/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testConnectionFetchById() throws Exception {
    when(service.connectionFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/connection/breakup/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testMovementsFetchAll() throws Exception {
    when(service.movementsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/connection/breakup-movements/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testMovementFetchById() throws Exception {
    when(service.movementFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/connection/breakup-movement/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testCMovementsFetchAll() throws Exception {
    when(service.cMovementsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/connection/breakup-movements/revisions/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"))
        .andExpect(jsonPath("$.data[0].name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testCMovementFetchById() throws Exception {
    when(service.cMovementFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/connection/breakup-movement/revision/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"))
        .andExpect(jsonPath("$.data.name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testCustomersFetchAll() throws Exception {
    when(service.customersFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/corporate/customers/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"))
        .andExpect(jsonPath("$.data[0].name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testCustomerFetchById() throws Exception {
    when(service.customerFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/customer/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"))
        .andExpect(jsonPath("$.data.name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testDisbursementsFetchAll() throws Exception {
    CommonLookUp lookups = new CommonLookUp();
    lookups.setCode("CORP001");
    lookups.setName("Tech Innovations Pvt Ltd");

    when(service.disbursementsFetchAll()).thenReturn(List.of(lookups));

    mockMvc
        .perform(
            get("/api/corporate/disbursements/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"))
        .andExpect(jsonPath("$.data[0].name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testDisbursementsFetchById() throws Exception {
    UUID ids = UUID.randomUUID();

    CommonLookUp look = new CommonLookUp();
    look.setId(ids);
    look.setCode("CORP001");
    look.setName("Tech Innovations Pvt Ltd");

    when(service.disbursementFetchById(any(UUID.class))).thenReturn(look);

    mockMvc
        .perform(
            get("/api/corporate/disbursement/{id}", ids).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"))
        .andExpect(jsonPath("$.data.name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testDisbursementsHisFetchAll() throws Exception {
    when(service.disbursementsHisFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/disbursement-histories/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"));
  }

  @Test
  void testDisbursementHisFetchById() throws Exception {
    when(service.disbursementHisFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/disbursement-history/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"));
  }

  @Test
  void testDnoteMastersFetchAll() throws Exception {
    when(service.mastersFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/dNoteMasters/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"));
  }

  @Test
  void testDnoteMasterFetchById() throws Exception {
    when(service.masterFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/dNoteMaster/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"));
  }

  @Test
  void tesRenewalFetchAll() throws Exception {
    when(service.renewalsHistoryFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/dNote/Renewal-histories/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"))
        .andExpect(jsonPath("$.data[0].name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testRenewalFetchById() throws Exception {
    when(service.renewalHistoryFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/dNote/Renewal-history/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"))
        .andExpect(jsonPath("$.data.name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void tesEoDetailsFetchAll() throws Exception {
    when(service.eoDetailsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/corporate/eoDetails/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"))
        .andExpect(jsonPath("$.data[0].name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testEoDetailsetchById() throws Exception {
    when(service.eoDetailFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/eoDetail/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"))
        .andExpect(jsonPath("$.data.name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testInvoiceFetchAll() throws Exception {
    when(service.invoicesFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/corporate/invoices/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"))
        .andExpect(jsonPath("$.data[0].name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testInvoiceFetchById() throws Exception {
    when(service.invoiceFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/invoice/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"))
        .andExpect(jsonPath("$.data.name").value("Tech Innovations Pvt Ltd"));
  }

  @Test
  void testMastersFetchAll() throws Exception {
    when(service.invoiceMasterFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/invoice-masters/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testInvoiceMasterById() throws Exception {
    when(service.invoiceMasterFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/invoice-master/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testKycDetailsFetchAll() throws Exception {
    when(service.kycDetailsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/kyc-details/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testKycDetailById() throws Exception {
    when(service.kycDetailsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/kyc-detail/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testLocationMovementFetchAll() throws Exception {
    when(service.locationMovementFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/location/movements/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testMovementById() throws Exception {
    when(service.locationMovementFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/location/movement/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testLocationRenewalHistoryFetchAll() throws Exception {
    when(service.locationRenewalHistoryFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/location/renewal-histories/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testRenewalHistoryById() throws Exception {
    when(service.locationRenewalHistoryFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/location/renewal-history/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testLocationsFetchAll() throws Exception {
    when(service.locationsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/corporate/locations/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testLocationById() throws Exception {
    when(service.locationsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/location/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testOnlineApplicationFetchAll() throws Exception {
    when(service.onlineApplicationFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/online-applications/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testOnlineApplicationById() throws Exception {
    when(service.onlineApplicationFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/online-application/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testOtcInvoiceFetchAll() throws Exception {
    when(service.otcInvoiceFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/otc-invoices/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testOtcInvoiceById() throws Exception {
    when(service.otcInvoiceFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/otc-invoice/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testPackageFetchAll() throws Exception {
    when(service.packageFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/corporate/packages/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testPackageById() throws Exception {
    when(service.packageFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/package/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testParentCustomersFetchAll() throws Exception {
    when(service.parentCustomersFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/parent-customers/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testParentCustomerById() throws Exception {
    when(service.parentCustomersFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/parent-customer/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testPaymentHistoryFetchAll() throws Exception {
    when(service.paymentHistoryFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/payment-histories/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testPaymentHistoryById() throws Exception {
    when(service.paymentHistoryFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/payment-history/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testPoMovementFetchAll() throws Exception {
    when(service.poMovementFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/po-movements/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testPoMovementById() throws Exception {
    when(service.poMovementFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/po-movement/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testPaymentKycDetailsFetchAll() throws Exception {
    when(service.paymentKycDetailsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/payment/kyc-details/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testPaymentKycDetailById() throws Exception {
    when(service.paymentKycDetailsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/payment/kyc-detail/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testQuotationsFetchAll() throws Exception {
    when(service.quotationsFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/corporate/quotations/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testQuotationById() throws Exception {
    when(service.quotationsFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/quotation/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testPurchaseOrderFetchAll() throws Exception {
    when(service.purchaseOrderFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/purchase-orders/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testPurchaseOrderById() throws Exception {
    when(service.purchaseOrderFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/purchase-order/{id}", id).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testQuotationsRevisionFetchAll() throws Exception {
    when(service.quotationsRevisionFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/quotations-revisions/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testQuotationsRevisionById() throws Exception {
    when(service.quotationsRevisionFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/quotations-revision/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }

  @Test
  void testQuotationsMovementFetchAll() throws Exception {
    when(service.quotationsMovementFetchAll()).thenReturn(List.of(lookup));

    mockMvc
        .perform(
            get("/api/corporate/quotations-movements/fetch-all")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"));
  }

  @Test
  void testQuotationsMovementById() throws Exception {
    when(service.quotationsMovementFetchById(any(UUID.class))).thenReturn(lookup);

    mockMvc
        .perform(
            get("/api/corporate/quotations-movement/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.code").value("CORP001"));
  }
}
