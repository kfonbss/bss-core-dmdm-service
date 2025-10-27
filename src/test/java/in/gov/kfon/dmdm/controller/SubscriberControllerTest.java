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
}
