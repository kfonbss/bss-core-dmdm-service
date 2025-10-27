package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.SubscriberFeedback;
import in.gov.kfon.dmdm.model.SubscriberOffers;
import in.gov.kfon.dmdm.repository.SubscriberFeedbackRepository;
import in.gov.kfon.dmdm.repository.SubscriberOffersRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

  private final SubscriberFeedbackRepository feedbackRepository;
  private final SubscriberOffersRepository offersRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllFeedbacks() {
    return feedbackRepository.findAll().stream()
        .map(f -> modelMapper.map(f, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchFeedbackById(UUID id) {
    SubscriberFeedback f =
        feedbackRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("SubscriberFeedback not found with id: " + id));
    return modelMapper.map(f, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllOffers() {
    return offersRepository.findAll().stream()
        .map(o -> modelMapper.map(o, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchOfferById(UUID id) {
    SubscriberOffers o =
        offersRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("SubscriberOffer not found with id: " + id));
    return modelMapper.map(o, CommonLookUp.class);
  }
}
