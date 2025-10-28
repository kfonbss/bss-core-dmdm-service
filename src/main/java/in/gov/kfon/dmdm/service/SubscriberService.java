package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface SubscriberService {

  List<CommonLookUp> fetchAllFeedbacks();

  CommonLookUp fetchFeedbackById(UUID id);

  List<CommonLookUp> fetchAllOffers();

  CommonLookUp fetchOfferById(UUID id);

  List<CommonLookUp> fetchAllSubscriberStatusTypes();

  CommonLookUp fetchSubscriberStatusTypeById(UUID id);

  List<CommonLookUp> fetchAllSubscriberAccounts();

  CommonLookUp fetchSubscriberAccountById(UUID id);

  List<CommonLookUp> fetchAllSubscriberAccountStaticIps();

  CommonLookUp fetchSubscriberAccountStaticIpById(UUID id);

  List<CommonLookUp> fetchAllSubscriberDataUsages();

  CommonLookUp fetchSubscriberDataUsageById(UUID id);

  List<CommonLookUp> fetchAllSubscriberDetails();

  CommonLookUp fetchSubscriberDetailById(UUID id);

  List<CommonLookUp> fetchAllSubscriberEmails();

  CommonLookUp fetchSubscriberEmailById(UUID id);

  List<CommonLookUp> fetchAllFinance();

  CommonLookUp fetchFinanceById(UUID id);

  List<CommonLookUp> fetchAllContactInfo();

  CommonLookUp fetchContactInfoById(UUID id);
}
