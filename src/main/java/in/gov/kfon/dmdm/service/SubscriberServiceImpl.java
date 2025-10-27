package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.SubscriberAccount;
import in.gov.kfon.dmdm.model.SubscriberFeedback;
import in.gov.kfon.dmdm.model.SubscriberOffers;
import in.gov.kfon.dmdm.model.SubscriberStatusType;
import in.gov.kfon.dmdm.repository.SubscriberAccountRepository;
import in.gov.kfon.dmdm.repository.SubscriberFeedbackRepository;
import in.gov.kfon.dmdm.repository.SubscriberOffersRepository;
import in.gov.kfon.dmdm.repository.SubscriberStatusTypeRepository;
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
  private final SubscriberStatusTypeRepository statusTypeRepository;
  private final SubscriberAccountRepository accountRepository;
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

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllSubscriberStatusTypes() {
    return statusTypeRepository.findAll().stream()
        .map(s -> modelMapper.map(s, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchSubscriberStatusTypeById(UUID id) {
    SubscriberStatusType status =
        statusTypeRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("SubscriberStatusType not found with id: " + id));
    return modelMapper.map(status, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllSubscriberAccounts() {
    return accountRepository.findAll().stream()
        .map(a -> modelMapper.map(a, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchSubscriberAccountById(UUID id) {
    SubscriberAccount account =
        accountRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("SubscriberAccount not found with id: " + id));
    return modelMapper.map(account, CommonLookUp.class);
  }
}
