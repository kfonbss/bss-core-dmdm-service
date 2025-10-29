package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.repository.*;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CorporateOnboardingServiceImpl implements CorporateOnboardingService {

  private final ModelMapper modelMapper;
  private static final String NOT_FOUND = "Not found with id: ";
  private final CorporateEnquiryRepository repository;
  private final CorpLocationListRepository locationListRepository;
  private final CeConnectionBreakupRepository connectionBreakupRepository;
  private final CeConnectionBreakupMovementRepository movementRepository;
  private final CeConnectionBreakupRevisionRepository revisionRepository;
  private final CeCustomerRepository customerRepository;
  private final CeDisbursementRepository disbursementRepository;
  private final CeDisbursementHistoryRepository disbursementHistoryRepository;
  private final CeDnoteMasterRepository dnoteMasterRepository;
  private final CeDnoteRenewalHistoryRepository renewalHistoryRepository;
  private final CeEodetailsRepository eodetailsRepository;
  private final CeInovoiceRepository inovoiceRepository;

  @PostConstruct
  public void setupMapper() {
    // For CorporateEnquiry
    modelMapper.addMappings(
        new PropertyMap<CorporateEnquiry, CommonLookUp>() {
          @Override
          protected void configure() {
            skip(destination.getId());
          }
        });

    // For CorpLocationList
    modelMapper.addMappings(
        new PropertyMap<CorpLocationList, CommonLookUp>() {
          @Override
          protected void configure() {
            skip(destination.getId());
          }
        });
    // For CeEodetails
    modelMapper.addMappings(
        new PropertyMap<CeEodetails, CommonLookUp>() {
          @Override
          protected void configure() {
            skip(destination.getId());
          }
        });
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAll() {
    return repository.findAll().stream()
        .map(
            enquiry -> {
              CommonLookUp lookup = modelMapper.map(enquiry, CommonLookUp.class);
              lookup.setId(enquiry.getEnquiriesId());
              return lookup;
            })
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchById(UUID id) {
    CorporateEnquiry enquiry =
        repository
            .findByEnquiriesId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Corporate Enquiry not found with id: " + id));

    CommonLookUp lookup = modelMapper.map(enquiry, CommonLookUp.class);
    lookup.setId(enquiry.getEnquiriesId());

    return lookup;
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> locationFetchAll() {
    return locationListRepository.findAll().stream()
        .map(
            enquiry -> {
              CommonLookUp lookup = modelMapper.map(enquiry, CommonLookUp.class);
              lookup.setId(enquiry.getListId());
              return lookup;
            })
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp locationFetchById(UUID id) {
    CorpLocationList list =
        locationListRepository
            .findByListId(id)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Corporate Location List not found with id: " + id));

    CommonLookUp lookup = modelMapper.map(list, CommonLookUp.class);
    lookup.setId(list.getListId());

    return lookup;
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> connectionsFetchAll() {
    return connectionBreakupRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp connectionFetchById(UUID id) {

    CeConnectionBreakup breakup =
        connectionBreakupRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(breakup, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> movementsFetchAll() {
    return movementRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp movementFetchById(UUID id) {
    CeConnectionBreakupMovement movement =
        movementRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(movement, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> cMovementsFetchAll() {
    return revisionRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp cMovementFetchById(UUID id) {
    CeConnectionBreakupMovementRevision revision =
        revisionRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(revision, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> customersFetchAll() {
    return customerRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp customerFetchById(UUID id) {
    CeCustomer customer =
        customerRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(customer, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> disbursementsFetchAll() {
    return disbursementRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp disbursementFetchById(UUID id) {
    CeDisbursement disbursement =
        disbursementRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(disbursement, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> disbursementsHisFetchAll() {
    return disbursementHistoryRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp disbursementHisFetchById(UUID id) {
    CeDisbursementHistory disbursement =
        disbursementHistoryRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(disbursement, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> mastersFetchAll() {
    return dnoteMasterRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp masterFetchById(UUID id) {
    CeDnoteMaster master =
        dnoteMasterRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(master, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> renewalsHistoryFetchAll() {
    return renewalHistoryRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp renewalHistoryFetchById(UUID id) {
    CeDnoteRenewalHistory history =
        renewalHistoryRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(history, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> eoDetailsFetchAll() {
    return eodetailsRepository.findAll().stream()
        .map(
            eodetails -> {
              CommonLookUp lookup = modelMapper.map(eodetails, CommonLookUp.class);
              lookup.setId(eodetails.getEodetailsId());
              return lookup;
            })
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp eoDetailFetchById(UUID id) {
    CeEodetails details =
        eodetailsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));

    CommonLookUp lookup = modelMapper.map(details, CommonLookUp.class);
    lookup.setId(details.getEodetailsId());

    return lookup;
  }

  @Override
  public List<CommonLookUp> invoicesFetchAll() {
    return inovoiceRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp invoiceFetchById(UUID id) {
    CeInovoice invoice =
        inovoiceRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(invoice, CommonLookUp.class);
  }
}
