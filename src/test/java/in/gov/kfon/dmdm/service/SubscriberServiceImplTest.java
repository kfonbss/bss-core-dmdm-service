package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.repository.*;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

public class SubscriberServiceImplTest {

  @Mock private SubscriberFeedbackRepository feedbackRepository;
  @Mock private SubscriberOffersRepository offersRepository;
  @Mock private SubscriberStatusTypeRepository statusRepository;
  @Mock private SubscriberAccountRepository accountRepository;
  @Mock private SubscriberAccountStaticIpRepository staticIpRepository;
  @Mock private SubscriberDataUsageRepository dataUsageRepository;
  @Mock private SubscriberDetailRepository subscriberDetailRepository;
  @Mock private SubscriberEmailRepository subscriberEmailRepository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private SubscriberServiceImpl service;

  private UUID feedbackId;
  private UUID offerId;
  private UUID statusId;
  private UUID accountId;
  private SubscriberFeedback feedback;
  private SubscriberOffers offer;
  private SubscriberStatusType status;
  private SubscriberAccount account;
  private CommonLookUp lookupFeedback;
  private CommonLookUp lookupOffer;
  private CommonLookUp lookupStatus;
  private CommonLookUp lookupAccount;
  private UUID idStaticIp;
  private UUID idDataUsage;
  private SubscriberAccountStaticIp staticIp;
  private SubscriberDataUsage dataUsage;
  private CommonLookUp lookupStaticIp;
  private CommonLookUp lookupDataUsage;
  private UUID idSubscriberDetail;
  private UUID idSubscriberEmail;
  private SubscriberDetail subscriberDetail;
  private SubscriberEmail subscriberEmail;
  private CommonLookUp lookupSubscriberDetail;
  private CommonLookUp lookupSubscriberEmail;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    feedbackId = UUID.randomUUID();
    offerId = UUID.randomUUID();
    statusId = UUID.randomUUID();
    accountId = UUID.randomUUID();

    feedback = new SubscriberFeedback();
    feedback.setId(feedbackId);
    feedback.setCode("FB001");
    feedback.setName("Feedback 1");
    feedback.setNameInLocal("ഫീഡ്ബാക്ക് 1");
    feedback.setIsActive(true);

    offer = new SubscriberOffers();
    offer.setId(offerId);
    offer.setCode("OF001");
    offer.setName("Offer 1");
    offer.setNameInLocal("ഓഫർ 1");
    offer.setIsActive(true);

    status = new SubscriberStatusType();
    status.setId(statusId);
    status.setCode("ST001");
    status.setName("Active");
    status.setNameInLocal("സജീവം");
    status.setIsActive(true);
    status.setDescription("Active subscriber status");

    account = new SubscriberAccount();
    account.setId(accountId);
    account.setSubscriberid(1001);
    account.setBalance(new java.math.BigDecimal("500.00"));
    account.setIsActive(true);
    account.setCode("ACC001");
    account.setName("Subscriber Account 1");
    account.setNameInLocal("സബ്സ്ക്രൈബർ അക്കൗണ്ട് 1");

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

    lookupStatus = new CommonLookUp();
    lookupStatus.setId(UUID.randomUUID());
    lookupStatus.setCode("ST001");
    lookupStatus.setName("Active");
    lookupStatus.setNameInLocal("സജീവം");
    lookupStatus.setIsActive(true);

    lookupAccount = new CommonLookUp();
    lookupAccount.setId(accountId);
    lookupAccount.setCode("ACC001");
    lookupAccount.setName("Subscriber Account 1");
    lookupAccount.setNameInLocal("സബ്സ്ക്രൈബർ അക്കൗണ്ട് 1");
    lookupAccount.setIsActive(true);

    idStaticIp = UUID.randomUUID();
    idDataUsage = UUID.randomUUID();

    staticIp = new SubscriberAccountStaticIp();
    staticIp.setId(idStaticIp);
    staticIp.setSubscriberId(1001);

    dataUsage = new SubscriberDataUsage();
    dataUsage.setId(idDataUsage);
    dataUsage.setSubscriberId(2001);
    dataUsage.setUsername("user1");

    lookupStaticIp = new CommonLookUp();
    lookupStaticIp.setId(idStaticIp);
    lookupStaticIp.setCode("STATICIP001");
    lookupStaticIp.setName("Static IP 1");
    lookupStaticIp.setNameInLocal("സ്റ്റാറ്റിക് ഐപി 1");
    lookupStaticIp.setIsActive(true);

    lookupDataUsage = new CommonLookUp();
    lookupDataUsage.setId(idDataUsage);
    lookupDataUsage.setCode("DATAUSG001");
    lookupDataUsage.setName("Data Usage 1");
    lookupDataUsage.setNameInLocal("ഡാറ്റാ യൂസേജ് 1");
    lookupDataUsage.setIsActive(true);

    idSubscriberDetail = UUID.randomUUID();
    idSubscriberEmail = UUID.randomUUID();

    subscriberDetail = new SubscriberDetail();
    subscriberDetail.setId(idSubscriberDetail);
    subscriberDetail.setUsername("johndoe");
    subscriberDetail.setCode("SUBDET001");
    subscriberDetail.setName("John Doe");
    subscriberDetail.setNameInLocal("ജോൺ ഡോ");
    subscriberDetail.setIsActive(true);

    subscriberEmail = new SubscriberEmail();
    subscriberEmail.setId(idSubscriberEmail);
    subscriberEmail.setSubscriberid(1001);
    subscriberEmail.setUsername("johndoe");
    subscriberEmail.setEmail("john.doe@example.com");
    subscriberEmail.setCode("SE001");
    subscriberEmail.setName("John Email");
    subscriberEmail.setNameInLocal("ജോൺ ഇമെയിൽ");
    subscriberEmail.setIsActive(true);

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
  }

  @Test
  void testFetchAllFeedbacks() {
    when(feedbackRepository.findAll()).thenReturn(List.of(feedback));
    when(modelMapper.map(feedback, CommonLookUp.class)).thenReturn(lookupFeedback);

    List<CommonLookUp> result = service.fetchAllFeedbacks();
    assertEquals(1, result.size());
    assertEquals(feedbackId, result.get(0).getId());
  }

  @Test
  void testFetchFeedbackById_Success() {
    when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.of(feedback));
    when(modelMapper.map(feedback, CommonLookUp.class)).thenReturn(lookupFeedback);

    CommonLookUp result = service.fetchFeedbackById(feedbackId);
    assertEquals(feedbackId, result.getId());
    assertEquals("Feedback 1", result.getName());
  }

  @Test
  void testFetchFeedbackById_NotFound() {
    when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchFeedbackById(feedbackId));

    assertEquals("SubscriberFeedback not found with id: " + feedbackId, exception.getMessage());
  }

  @Test
  void testFetchAllOffers() {
    when(offersRepository.findAll()).thenReturn(List.of(offer));
    when(modelMapper.map(offer, CommonLookUp.class)).thenReturn(lookupOffer);

    List<CommonLookUp> result = service.fetchAllOffers();
    assertEquals(1, result.size());
    assertEquals(offerId, result.get(0).getId());
  }

  @Test
  void testFetchOfferById_Success() {
    when(offersRepository.findById(offerId)).thenReturn(Optional.of(offer));
    when(modelMapper.map(offer, CommonLookUp.class)).thenReturn(lookupOffer);

    CommonLookUp result = service.fetchOfferById(offerId);
    assertEquals(offerId, result.getId());
    assertEquals("Offer 1", result.getName());
  }

  @Test
  void testFetchOfferById_NotFound() {
    when(offersRepository.findById(offerId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchOfferById(offerId));

    assertEquals("SubscriberOffer not found with id: " + offerId, exception.getMessage());
  }

  @Test
  void testFetchAllStatusTypes() {
    when(statusRepository.findAll()).thenReturn(List.of(status));
    when(modelMapper.map(status, CommonLookUp.class)).thenReturn(lookupStatus);

    List<CommonLookUp> result = service.fetchAllSubscriberStatusTypes();
    assertEquals(1, result.size());
  }

  @Test
  void testFetchSubscriberStatusTypeById_Success() {
    when(statusRepository.findById(statusId)).thenReturn(Optional.of(status));
    when(modelMapper.map(status, CommonLookUp.class)).thenReturn(lookupStatus);

    CommonLookUp result = service.fetchSubscriberStatusTypeById(statusId);
    assertNotNull(result);
  }

  @Test
  void testFetchSubscriberStatusTypeById_NotFound() {
    when(statusRepository.findById(statusId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(
            EntityNotFoundException.class, () -> service.fetchSubscriberStatusTypeById(statusId));
    assertEquals("SubscriberStatusType not found with id: " + statusId, exception.getMessage());
  }

  @Test
  void testFetchAllSubscriberAccounts() {
    when(accountRepository.findAll()).thenReturn(List.of(account));
    when(modelMapper.map(account, CommonLookUp.class)).thenReturn(lookupAccount);

    List<CommonLookUp> result = service.fetchAllSubscriberAccounts();
    assertEquals(1, result.size());
  }

  @Test
  void testFetchSubscriberAccountById_Success() {
    when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
    when(modelMapper.map(account, CommonLookUp.class)).thenReturn(lookupAccount);

    CommonLookUp result = service.fetchSubscriberAccountById(accountId);
    assertNotNull(result);
    assertEquals(accountId, result.getId());
  }

  @Test
  void testFetchSubscriberAccountById_NotFound() {
    when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(
            EntityNotFoundException.class, () -> service.fetchSubscriberAccountById(accountId));
    assertEquals("SubscriberAccount not found with id: " + accountId, exception.getMessage());
  }

  @Test
  void testFetchAllSubscriberAccountStaticIps() {
    when(staticIpRepository.findAll()).thenReturn(List.of(staticIp));
    when(modelMapper.map(staticIp, CommonLookUp.class)).thenReturn(lookupStaticIp);

    List<CommonLookUp> result = service.fetchAllSubscriberAccountStaticIps();

    assertEquals(1, result.size());
    assertEquals(idStaticIp, result.get(0).getId());
  }

  @Test
  void testFetchSubscriberAccountStaticIpById_Success() {
    when(staticIpRepository.findById(idStaticIp)).thenReturn(Optional.of(staticIp));
    when(modelMapper.map(staticIp, CommonLookUp.class)).thenReturn(lookupStaticIp);

    CommonLookUp result = service.fetchSubscriberAccountStaticIpById(idStaticIp);
    assertEquals(idStaticIp, result.getId());
  }

  @Test
  void testFetchSubscriberAccountStaticIpById_NotFound() {
    when(staticIpRepository.findById(idStaticIp)).thenReturn(Optional.empty());

    EntityNotFoundException ex =
        assertThrows(
            EntityNotFoundException.class,
            () -> service.fetchSubscriberAccountStaticIpById(idStaticIp));

    assertEquals("SubscriberAccountStaticIp not found with id: " + idStaticIp, ex.getMessage());
  }

  @Test
  void testFetchAllSubscriberDataUsages() {
    when(dataUsageRepository.findAll()).thenReturn(List.of(dataUsage));
    when(modelMapper.map(dataUsage, CommonLookUp.class)).thenReturn(lookupDataUsage);

    List<CommonLookUp> result = service.fetchAllSubscriberDataUsages();

    assertEquals(1, result.size());
    assertEquals(idDataUsage, result.get(0).getId());
  }

  @Test
  void testFetchSubscriberDataUsageById_Success() {
    when(dataUsageRepository.findById(idDataUsage)).thenReturn(Optional.of(dataUsage));
    when(modelMapper.map(dataUsage, CommonLookUp.class)).thenReturn(lookupDataUsage);

    CommonLookUp result = service.fetchSubscriberDataUsageById(idDataUsage);
    assertEquals(idDataUsage, result.getId());
  }

  @Test
  void testFetchSubscriberDataUsageById_NotFound() {
    when(dataUsageRepository.findById(idDataUsage)).thenReturn(Optional.empty());

    EntityNotFoundException ex =
        assertThrows(
            EntityNotFoundException.class, () -> service.fetchSubscriberDataUsageById(idDataUsage));

    assertEquals("SubscriberDataUsage not found with id: " + idDataUsage, ex.getMessage());
  }

  @Test
  void testFetchAllSubscriberDetails() {
    when(subscriberDetailRepository.findAll()).thenReturn(List.of(subscriberDetail));
    when(modelMapper.map(subscriberDetail, CommonLookUp.class)).thenReturn(lookupSubscriberDetail);

    List<CommonLookUp> result = service.fetchAllSubscriberDetails();
    assertEquals(1, result.size());
    assertEquals(idSubscriberDetail, result.get(0).getId());
  }

  @Test
  void testFetchSubscriberDetailById_Success() {
    when(subscriberDetailRepository.findById(idSubscriberDetail))
        .thenReturn(Optional.of(subscriberDetail));
    when(modelMapper.map(subscriberDetail, CommonLookUp.class)).thenReturn(lookupSubscriberDetail);

    CommonLookUp result = service.fetchSubscriberDetailById(idSubscriberDetail);
    assertEquals(idSubscriberDetail, result.getId());
  }

  @Test
  void testFetchSubscriberDetailById_NotFound() {
    when(subscriberDetailRepository.findById(idSubscriberDetail)).thenReturn(Optional.empty());
    EntityNotFoundException ex =
        assertThrows(
            EntityNotFoundException.class,
            () -> service.fetchSubscriberDetailById(idSubscriberDetail));
    assertEquals("SubscriberDetail not found with id: " + idSubscriberDetail, ex.getMessage());
  }

  @Test
  void testFetchAllSubscriberEmails() {
    when(subscriberEmailRepository.findAll()).thenReturn(List.of(subscriberEmail));
    when(modelMapper.map(subscriberEmail, CommonLookUp.class)).thenReturn(lookupSubscriberEmail);

    List<CommonLookUp> result = service.fetchAllSubscriberEmails();
    assertEquals(1, result.size());
    assertEquals(idSubscriberEmail, result.get(0).getId());
  }

  @Test
  void testFetchSubscriberEmailById_Success() {
    when(subscriberEmailRepository.findById(idSubscriberEmail))
        .thenReturn(Optional.of(subscriberEmail));
    when(modelMapper.map(subscriberEmail, CommonLookUp.class)).thenReturn(lookupSubscriberEmail);

    CommonLookUp result = service.fetchSubscriberEmailById(idSubscriberEmail);
    assertEquals(idSubscriberEmail, result.getId());
  }

  @Test
  void testFetchSubscriberEmailById_NotFound() {
    when(subscriberEmailRepository.findById(idSubscriberEmail)).thenReturn(Optional.empty());
    EntityNotFoundException ex =
        assertThrows(
            EntityNotFoundException.class,
            () -> service.fetchSubscriberEmailById(idSubscriberEmail));
    assertEquals("SubscriberEmail not found with id: " + idSubscriberEmail, ex.getMessage());
  }
}
