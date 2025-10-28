package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.repository.*;
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
  private final SubscriberAccountStaticIpRepository subscriberAccountStaticIpRepository;
  private final SubscriberDataUsageRepository dataUsageRepository;
  private final SubscriberDetailRepository subscriberDetailRepository;
  private final SubscriberEmailRepository subscriberEmailRepository;
  private final SubscriberFinanceRepository financeRepository;
  private final SubscriberContactInformationRepository contactRepository;
  private final SubscriberGstDetailRepository subscriberGstDetailRepository;
  private final SubscriberInvoiceRepository subscriberInvoiceRepository;
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

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllSubscriberAccountStaticIps() {
    return subscriberAccountStaticIpRepository.findAll().stream()
        .map(sa -> modelMapper.map(sa, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchSubscriberAccountStaticIpById(UUID id) {
    SubscriberAccountStaticIp sa =
        subscriberAccountStaticIpRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "SubscriberAccountStaticIp not found with id: " + id));
    return modelMapper.map(sa, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllSubscriberDataUsages() {
    return dataUsageRepository.findAll().stream()
        .map(du -> modelMapper.map(du, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchSubscriberDataUsageById(UUID id) {
    SubscriberDataUsage du =
        dataUsageRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("SubscriberDataUsage not found with id: " + id));
    return modelMapper.map(du, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllSubscriberDetails() {
    return subscriberDetailRepository.findAll().stream()
        .map(s -> modelMapper.map(s, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchSubscriberDetailById(UUID id) {
    SubscriberDetail sd =
        subscriberDetailRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("SubscriberDetail not found with id: " + id));
    return modelMapper.map(sd, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllSubscriberEmails() {
    return subscriberEmailRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchSubscriberEmailById(UUID id) {
    SubscriberEmail se =
        subscriberEmailRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("SubscriberEmail not found with id: " + id));
    return modelMapper.map(se, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllFinance() {
    return financeRepository.findAll().stream()
        .map(f -> modelMapper.map(f, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchFinanceById(UUID id) {
    SubscriberFinance f =
        financeRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("SubscriberFinance not found with id: " + id));
    return modelMapper.map(f, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllContactInfo() {
    return contactRepository.findAll().stream()
        .map(c -> modelMapper.map(c, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchContactInfoById(UUID id) {
    SubscriberContactInformation c =
        contactRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "SubscriberContactInformation not found with id: " + id));
    return modelMapper.map(c, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllGstDetails() {
    return subscriberGstDetailRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchGstDetailsById(UUID id) {
    var gstDetail =
        subscriberGstDetailRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("GST Detail not found"));
    return modelMapper.map(gstDetail, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllInvoices() {
    return subscriberInvoiceRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchInvoiceById(UUID id) {
    var invoice =
        subscriberInvoiceRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
    return modelMapper.map(invoice, CommonLookUp.class);
  }
}
