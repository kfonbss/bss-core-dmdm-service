package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.SubscriberFeedback;
import in.gov.kfon.dmdm.model.SubscriberOffers;
import in.gov.kfon.dmdm.repository.SubscriberFeedbackRepository;
import in.gov.kfon.dmdm.repository.SubscriberOffersRepository;
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
    @Mock private ModelMapper modelMapper;

    @InjectMocks private SubscriberServiceImpl service;

    private UUID feedbackId;
    private UUID offerId;
    private SubscriberFeedback feedback;
    private SubscriberOffers offer;
    private CommonLookUp lookupFeedback;
    private CommonLookUp lookupOffer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        feedbackId = UUID.randomUUID();
        offerId = UUID.randomUUID();

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

        EntityNotFoundException exception = assertThrows(
                EntityNotFoundException.class,
                () -> service.fetchFeedbackById(feedbackId)
        );

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

        EntityNotFoundException exception = assertThrows(
                EntityNotFoundException.class,
                () -> service.fetchOfferById(offerId)
        );

        assertEquals("SubscriberOffer not found with id: " + offerId, exception.getMessage());
    }
}
