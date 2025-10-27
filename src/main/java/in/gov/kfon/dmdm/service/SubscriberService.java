package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;

import java.util.List;
import java.util.UUID;

public interface SubscriberService {

    List<CommonLookUp> fetchAllFeedbacks();

    CommonLookUp fetchFeedbackById(UUID id);

    List<CommonLookUp> fetchAllOffers();

    CommonLookUp fetchOfferById(UUID id);
}
