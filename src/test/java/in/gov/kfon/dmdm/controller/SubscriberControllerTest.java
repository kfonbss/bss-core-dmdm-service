package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.SubscriberService;
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
@ContextConfiguration(classes = {SubscriberController.class})
public class SubscriberControllerTest {

  private MockMvc mockMvc;

  @MockBean private SubscriberService service;

  @Autowired private SubscriberController controller;

  private UUID feedbackId;
  private UUID offerId;
  private CommonLookUp lookupFeedback;
  private CommonLookUp lookupOffer;

  private UUID idStatusType;
  private UUID idSubscriberAccount;
  private CommonLookUp lookupStatusType;
  private CommonLookUp lookupSubscriberAccount;

  private UUID idStaticIp;
  private UUID idDataUsage;
  private CommonLookUp lookupStaticIp;
  private CommonLookUp lookupDataUsage;

  private UUID idSubscriberDetail;
  private UUID idSubscriberEmail;
  private CommonLookUp lookupSubscriberDetail;
  private CommonLookUp lookupSubscriberEmail;

  private UUID idFinance;
  private UUID idContact;
  private CommonLookUp lookupFinance;
  private CommonLookUp lookupContact;

  private UUID idGstDetail;
  private UUID idInvoice;
  private CommonLookUp lookupGstDetail;
  private CommonLookUp lookupInvoice;

  private UUID idSubscription;
  private CommonLookUp lookUpSubscription;

  private UUID id;
  private CommonLookUp lookup;

  private UUID idUsername;
  private CommonLookUp lookupUsername;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    feedbackId = UUID.randomUUID();
    offerId = UUID.randomUUID();

    lookupFeedback = new CommonLookUp();
    lookupFeedback.setId(feedbackId);
    lookupFeedback.setCode("FB001");
    lookupFeedback.setName("Feedback 1");
    lookupFeedback.setNameInLocal("ഫീഡ്ബാക്ക് 1");
    lookupFeedback.setIsActive(true);

    lookupOffer = new CommonLookUp();
    lookupOffer.setId(offerId);
    lookupOffer.setCode("OF001");
    lookupOffer.setName("Offer 1");
    lookupOffer.setNameInLocal("ഓഫർ 1");
    lookupOffer.setIsActive(true);

    idStatusType = UUID.randomUUID();
    idSubscriberAccount = UUID.randomUUID();

    lookupStatusType = new CommonLookUp();
    lookupStatusType.setId(idStatusType);
    lookupStatusType.setCode("STAT001");
    lookupStatusType.setName("Active");
    lookupStatusType.setNameInLocal("സജീവം");
    lookupStatusType.setIsActive(true);

    lookupSubscriberAccount = new CommonLookUp();
    lookupSubscriberAccount.setId(idSubscriberAccount);
    lookupSubscriberAccount.setCode("ACC001");
    lookupSubscriberAccount.setName("John Doe");
    lookupSubscriberAccount.setNameInLocal("ജോൺ ഡോ");
    lookupSubscriberAccount.setIsActive(true);

    idStaticIp = UUID.randomUUID();
    idDataUsage = UUID.randomUUID();

    lookupStaticIp = new CommonLookUp();
    lookupStaticIp.setId(idStaticIp);
    lookupStaticIp.setCode("STATIC001");
    lookupStaticIp.setName("Static IP 1");
    lookupStaticIp.setNameInLocal("സ്റ്റാറ്റിക് ഐപി 1");
    lookupStaticIp.setIsActive(true);

    lookupDataUsage = new CommonLookUp();
    lookupDataUsage.setId(idDataUsage);
    lookupDataUsage.setCode("DATA001");
    lookupDataUsage.setName("John Data Usage");
    lookupDataUsage.setNameInLocal("ജോൺ ഡാറ്റ ഉപയോഗം");
    lookupDataUsage.setIsActive(true);

    idSubscriberDetail = UUID.randomUUID();
    idSubscriberEmail = UUID.randomUUID();

    lookupSubscriberDetail = new CommonLookUp();
    lookupSubscriberDetail.setId(idSubscriberDetail);
    lookupSubscriberDetail.setCode("SUBDET001");
    lookupSubscriberDetail.setName("John Doe");
    lookupSubscriberDetail.setNameInLocal("ജോൺ ഡോ");
    lookupSubscriberDetail.setIsActive(true);

    lookupSubscriberEmail = new CommonLookUp();
    lookupSubscriberEmail.setId(idSubscriberEmail);
    lookupSubscriberEmail.setCode("SE001");
    lookupSubscriberEmail.setName("John Email");
    lookupSubscriberEmail.setNameInLocal("ജോൺ ഇമെയിൽ");
    lookupSubscriberEmail.setIsActive(true);

    idGstDetail = UUID.randomUUID();
    idInvoice = UUID.randomUUID();

    lookupGstDetail = new CommonLookUp();
    lookupGstDetail.setId(idGstDetail);
    lookupGstDetail.setCode("GST001");
    lookupGstDetail.setName("GST Detail 1");
    lookupGstDetail.setNameInLocal("ജിഎസ്എസ് ഡീറ്റയിൽ 1");
    lookupGstDetail.setIsActive(true);

    lookupInvoice = new CommonLookUp();
    lookupInvoice.setId(idInvoice);
    lookupInvoice.setCode("INV001");
    lookupInvoice.setName("Invoice 1");
    lookupInvoice.setNameInLocal("ഇൻവോയിസ് 1");
    lookupInvoice.setIsActive(true);

    idFinance = UUID.randomUUID();
    idContact = UUID.randomUUID();

    lookupFinance = new CommonLookUp();
    lookupFinance.setId(idFinance);
    lookupFinance.setCode("FIN001");
    lookupFinance.setName("Finance Record 1");
    lookupFinance.setNameInLocal("ഫിനാൻസ് റെക്കോർഡ് 1");
    lookupFinance.setIsActive(true);

    lookupContact = new CommonLookUp();
    lookupContact.setId(idContact);
    lookupContact.setCode("CONTACT001");
    lookupContact.setName("John Doe");
    lookupContact.setNameInLocal("ജോൺ ഡോ");
    lookupContact.setIsActive(true);

    idSubscription = UUID.randomUUID();

    lookUpSubscription = new CommonLookUp();
    lookUpSubscription.setId(idSubscription);
    lookUpSubscription.setName("Subscription-100");

    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setName("Standard Plan");
    lookup.setCode("SP001");
    lookup.setNameInLocal("സ്റ്റാൻഡേർഡ് പ്ലാൻ");
    lookup.setIsActive(true);

    idUsername = UUID.randomUUID();
    lookupUsername = new CommonLookUp();
    lookupUsername.setId(idUsername);
    lookupUsername.setName("john_doe");
    lookupUsername.setCode(null);
    lookupUsername.setNameInLocal(null);
    lookupUsername.setIsActive(null);
  }

  @Test
  void testFetchAllFeedbacks() throws Exception {
    when(service.fetchAllFeedbacks()).thenReturn(List.of(lookupFeedback));

    mockMvc
        .perform(get("/api/subscriber/feedbacks"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber feedbacks"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(feedbackId.toString()));
  }

  @Test
  void testFetchFeedbackById() throws Exception {
    when(service.fetchFeedbackById(feedbackId)).thenReturn(lookupFeedback);

    mockMvc
        .perform(get("/api/subscriber/feedback/{id}", feedbackId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber feedback"))
        .andExpect(jsonPath("$.data.id").value(feedbackId.toString()))
        .andExpect(jsonPath("$.data.name").value("Feedback 1"));
  }

  @Test
  void testFetchAllOffers() throws Exception {
    when(service.fetchAllOffers()).thenReturn(List.of(lookupOffer));

    mockMvc
        .perform(get("/api/subscriber/offers"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber offers"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(offerId.toString()));
  }

  @Test
  void testFetchOfferById() throws Exception {
    when(service.fetchOfferById(offerId)).thenReturn(lookupOffer);

    mockMvc
        .perform(get("/api/subscriber/offer/{id}", offerId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber offer"))
        .andExpect(jsonPath("$.data.id").value(offerId.toString()))
        .andExpect(jsonPath("$.data.name").value("Offer 1"));
  }

  @Test
  void testFetchAllSubscriberStatusTypes() throws Exception {
    when(service.fetchAllSubscriberStatusTypes()).thenReturn(List.of(lookupStatusType));

    mockMvc
        .perform(get("/api/subscriber/status-types"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber status types"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idStatusType.toString()));
  }

  @Test
  void testFetchSubscriberStatusTypeById() throws Exception {
    when(service.fetchSubscriberStatusTypeById(idStatusType)).thenReturn(lookupStatusType);

    mockMvc
        .perform(get("/api/subscriber/status-type/{id}", idStatusType))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber status type"))
        .andExpect(jsonPath("$.data.id").value(idStatusType.toString()))
        .andExpect(jsonPath("$.data.name").value("Active"));
  }

  @Test
  void testFetchAllSubscriberAccounts() throws Exception {
    when(service.fetchAllSubscriberAccounts()).thenReturn(List.of(lookupSubscriberAccount));

    mockMvc
        .perform(get("/api/subscriber/accounts"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber accounts"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idSubscriberAccount.toString()));
  }

  @Test
  void testFetchSubscriberAccountById() throws Exception {
    when(service.fetchSubscriberAccountById(idSubscriberAccount))
        .thenReturn(lookupSubscriberAccount);

    mockMvc
        .perform(get("/api/subscriber/account/{id}", idSubscriberAccount))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber account"))
        .andExpect(jsonPath("$.data.id").value(idSubscriberAccount.toString()))
        .andExpect(jsonPath("$.data.name").value("John Doe"));
  }

  @Test
  void testFetchAllSubscriberAccountStaticIps() throws Exception {
    when(service.fetchAllSubscriberAccountStaticIps()).thenReturn(List.of(lookupStaticIp));

    mockMvc
        .perform(get("/api/subscriber/account-static-ips"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber account static IPs"))
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idStaticIp.toString()));
  }

  @Test
  void testFetchSubscriberAccountStaticIpById() throws Exception {
    when(service.fetchSubscriberAccountStaticIpById(idStaticIp)).thenReturn(lookupStaticIp);

    mockMvc
        .perform(get("/api/subscriber/account-static-ip/{id}", idStaticIp))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber account static IP"))
        .andExpect(jsonPath("$.data.id").value(idStaticIp.toString()));
  }

  @Test
  void testFetchAllSubscriberDataUsages() throws Exception {
    when(service.fetchAllSubscriberDataUsages()).thenReturn(List.of(lookupDataUsage));

    mockMvc
        .perform(get("/api/subscriber/data-usages"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber data usages"))
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idDataUsage.toString()));
  }

  @Test
  void testFetchSubscriberDataUsageById() throws Exception {
    when(service.fetchSubscriberDataUsageById(idDataUsage)).thenReturn(lookupDataUsage);

    mockMvc
        .perform(get("/api/subscriber/data-usage/{id}", idDataUsage))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber data usage"))
        .andExpect(jsonPath("$.data.id").value(idDataUsage.toString()));
  }

  @Test
  void testFetchAllSubscriberDetails() throws Exception {
    when(service.fetchAllSubscriberDetails()).thenReturn(List.of(lookupSubscriberDetail));
    mockMvc
        .perform(get("/api/subscriber/details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber details"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idSubscriberDetail.toString()));
  }

  @Test
  void testFetchSubscriberDetailById() throws Exception {
    when(service.fetchSubscriberDetailById(idSubscriberDetail)).thenReturn(lookupSubscriberDetail);

    mockMvc
        .perform(get("/api/subscriber/detail/{id}", idSubscriberDetail))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber detail"))
        .andExpect(jsonPath("$.data.id").value(idSubscriberDetail.toString()))
        .andExpect(jsonPath("$.data.name").value("John Doe"));
  }

  @Test
  void testFetchAllSubscriberEmails() throws Exception {
    when(service.fetchAllSubscriberEmails()).thenReturn(List.of(lookupSubscriberEmail));

    mockMvc
        .perform(get("/api/subscriber/emails"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber emails"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idSubscriberEmail.toString()));
  }

  @Test
  void testFetchSubscriberEmailById() throws Exception {
    when(service.fetchSubscriberEmailById(idSubscriberEmail)).thenReturn(lookupSubscriberEmail);

    mockMvc
        .perform(get("/api/subscriber/email/{id}", idSubscriberEmail))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber email"))
        .andExpect(jsonPath("$.data.id").value(idSubscriberEmail.toString()))
        .andExpect(jsonPath("$.data.name").value("John Email"));
  }

  @Test
  void testFetchAllFinance() throws Exception {
    when(service.fetchAllFinance()).thenReturn(List.of(lookupFinance));

    mockMvc
        .perform(get("/api/subscriber/finances/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber finance records"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idFinance.toString()));
  }

  @Test
  void testFetchFinanceById() throws Exception {
    when(service.fetchFinanceById(idFinance)).thenReturn(lookupFinance);

    mockMvc
        .perform(get("/api/subscriber/finance/{id}", idFinance))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber finance record"))
        .andExpect(jsonPath("$.data.id").value(idFinance.toString()))
        .andExpect(jsonPath("$.data.name").value("Finance Record 1"));
  }

  @Test
  void testFetchAllContactInfo() throws Exception {
    when(service.fetchAllContactInfo()).thenReturn(List.of(lookupContact));

    mockMvc
        .perform(get("/api/subscriber/contact-informations"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriber contact information"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idContact.toString()));
  }

  @Test
  void testFetchContactInfoById() throws Exception {
    when(service.fetchContactInfoById(idContact)).thenReturn(lookupContact);

    mockMvc
        .perform(get("/api/subscriber/contact-information/{id}", idContact))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber contact information"))
        .andExpect(jsonPath("$.data.id").value(idContact.toString()))
        .andExpect(jsonPath("$.data.name").value("John Doe"));
  }

  @Test
  void testFetchAllGstDetails() throws Exception {
    when(service.fetchAllGstDetails()).thenReturn(List.of(lookupGstDetail));

    mockMvc
        .perform(get("/api/subscriber/gsts/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all GST details"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idGstDetail.toString()));
  }

  @Test
  void testFetchGstDetailById() throws Exception {
    when(service.fetchGstDetailsById(idGstDetail)).thenReturn(lookupGstDetail);

    mockMvc
        .perform(get("/api/subscriber/gst/{id}", idGstDetail))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched GST detail"))
        .andExpect(jsonPath("$.data.id").value(idGstDetail.toString()))
        .andExpect(jsonPath("$.data.name").value("GST Detail 1"));
  }

  @Test
  void testFetchAllInvoices() throws Exception {
    when(service.fetchAllInvoices()).thenReturn(List.of(lookupInvoice));

    mockMvc
        .perform(get("/api/subscriber/invoices/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all invoices"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idInvoice.toString()));
  }

  @Test
  void testFetchInvoiceById() throws Exception {
    when(service.fetchInvoiceById(idInvoice)).thenReturn(lookupInvoice);

    mockMvc
        .perform(get("/api/subscriber/invoice/{id}", idInvoice))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscriber invoice"))
        .andExpect(jsonPath("$.data.id").value(idInvoice.toString()))
        .andExpect(jsonPath("$.data.name").value("Invoice 1"));
  }

  @Test
  void testFetchAllSubscriptions() throws Exception {
    when(service.fetchAllSubscriptions()).thenReturn(List.of(lookUpSubscription));

    mockMvc
        .perform(get("/api/subscriber/subscriptions"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all subscriptions"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idSubscription.toString()))
        .andExpect(jsonPath("$.data[0].name").value("Subscription-100"));
  }

  @Test
  void testFetchSubscriptionById() throws Exception {
    when(service.fetchSubscriptionById(idSubscription)).thenReturn(lookUpSubscription);

    mockMvc
        .perform(get("/api/subscriber/subscription/{id}", idSubscription))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched subscription"))
        .andExpect(jsonPath("$.data.id").value(idSubscription.toString()))
        .andExpect(jsonPath("$.data.name").value("Subscription-100"));
  }

  @Test
  void testFetchAllProfiles() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllProfiles()).thenReturn(list);

    mockMvc
        .perform(get("/api/subscriber/profiles"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all profiles"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchProfileById() throws Exception {
    when(service.fetchProfileById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/subscriber/profile/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched profile"))
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.name").value("Standard Plan"))
        .andExpect(jsonPath("$.data.nameInLocal").value("സ്റ്റാൻഡേർഡ് പ്ലാൻ"))
        .andExpect(jsonPath("$.data.code").value("SP001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }

  @Test
  void testFetchAllUsernames() throws Exception {
    List<CommonLookUp> list = List.of(lookupUsername);
    when(service.fetchAllSubscriberUsernames()).thenReturn(list);

    mockMvc
        .perform(get("/api/subscriber/usernames"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all usernames"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idUsername.toString()))
        .andExpect(jsonPath("$.data[0].name").value("john_doe"));
  }

  @Test
  void testFetchUsernameById() throws Exception {
    when(service.fetchSubscriberUsernameById(idUsername)).thenReturn(lookupUsername);

    mockMvc
        .perform(get("/api/subscriber/username/{id}", idUsername))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched username"))
        .andExpect(jsonPath("$.data.id").value(idUsername.toString()))
        .andExpect(jsonPath("$.data.name").value("john_doe"));
  }
}
