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
  private final CeInovoiceMasterRepository inovoiceMasterRepository;
  private final CeKycDetailsRepository ceKycDetailsRepository;
  private final CeLocationMovementRepository locationMovementRepository;
  private final CeLocationRenewalHistoryRepository locationRenewalHistoryRepository;
  private final CeLocationsRepository locationsRepository;
  private final CeOnlineApplicationRepository onlineApplicationRepository;
  private final CeOtcInvoiceRepository invoiceRepository;
  private final CePackageRepository packageRepository;
  private final CeParentCustomersRepository parentCustomersRepository;
  private final CePaymentHistoryRepository paymentHistoryRepository;
  private final CePaymentKycDetailsRepository paymentKycDetailsRepository;
  private final CePoMovementRepository poMovementRepository;
  private final CeQuotationsRepository quotationsRepository;
  private final CePurchaseOrderRepository purchaseOrderRepository;
  private final CeQuotationsMovementRepository quotationsMovementRepository;
  private final CeQuotationsRevisionRepository quotationsRevisionRepository;
  private final CeRenewalDetailsRepository renewalDetailsRepository;
  private final CeRevisionConnectionBreakupRepository revisionConnectionBreakupRepository;
  private final CeServiceListRepository serviceListRepository;
  private final CeSubCustomersRepository subCustomersRepository;
  private final CeSubPackageRepository subPackageRepository;
  private final CeSubPackageRenewalHistoryRepository subPackageRenewalHistoryRepository;

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
    // forOnlineApplication
    modelMapper.addMappings(
        new PropertyMap<CeOnlineApplication, CommonLookUp>() {
          @Override
          protected void configure() {
            skip(destination.getId());
          }
        });
    // For Payment History
    modelMapper.addMappings(
        new PropertyMap<CePaymentHistory, CommonLookUp>() {
          @Override
          protected void configure() {
            skip(destination.getId());
          }
        });
    // For Sub Customer
    modelMapper.addMappings(
        new PropertyMap<CeSubCustomers, CommonLookUp>() {
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
  @Transactional(readOnly = true)
  public List<CommonLookUp> invoicesFetchAll() {
    return inovoiceRepository.findAll().stream()
        .map(connection -> modelMapper.map(connection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp invoiceFetchById(UUID id) {
    CeInovoice invoice =
        inovoiceRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(invoice, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> invoiceMasterFetchAll() {
    return inovoiceMasterRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp invoiceMasterFetchById(UUID id) {
    CeInovoiceMaster entity =
        inovoiceMasterRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> kycDetailsFetchAll() {
    return ceKycDetailsRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp kycDetailsFetchById(UUID id) {
    CeKycDetails entity =
        ceKycDetailsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> locationMovementFetchAll() {
    return locationMovementRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp locationMovementFetchById(UUID id) {
    CeLocationMovement entity =
        locationMovementRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> locationRenewalHistoryFetchAll() {
    return locationRenewalHistoryRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp locationRenewalHistoryFetchById(UUID id) {
    CeLocationRenewalHistory entity =
        locationRenewalHistoryRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> locationsFetchAll() {
    return locationsRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp locationsFetchById(UUID id) {
    CeLocations entity =
        locationsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> onlineApplicationFetchAll() {
    return onlineApplicationRepository.findAll().stream()
        .map(
            onlineApplication -> {
              CommonLookUp lookup = modelMapper.map(onlineApplication, CommonLookUp.class);
              lookup.setId(onlineApplication.getApplicationId());
              return lookup;
            })
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp onlineApplicationFetchById(UUID id) {

    CeOnlineApplication entity =
        onlineApplicationRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));

    CommonLookUp lookup = modelMapper.map(entity, CommonLookUp.class);
    lookup.setId(entity.getApplicationId());

    return lookup;
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> otcInvoiceFetchAll() {
    return invoiceRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp otcInvoiceFetchById(UUID id) {
    CeOtcInvoice entity =
        invoiceRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Transactional(readOnly = true)
  public List<CommonLookUp> packageFetchAll() {
    return packageRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp packageFetchById(UUID id) {
    CePackage entity =
        packageRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> parentCustomersFetchAll() {
    return parentCustomersRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp parentCustomersFetchById(UUID id) {
    CeParentCustomers entity =
        parentCustomersRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> paymentHistoryFetchAll() {
    return paymentHistoryRepository.findAll().stream()
        .map(
            paymentHistory -> {
              CommonLookUp lookup = modelMapper.map(paymentHistory, CommonLookUp.class);
              lookup.setId(paymentHistory.getHistoryId());
              return lookup;
            })
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp paymentHistoryFetchById(UUID id) {
    CePaymentHistory paymentHistory =
        paymentHistoryRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));

    CommonLookUp lookup = modelMapper.map(paymentHistory, CommonLookUp.class);
    lookup.setId(paymentHistory.getHistoryId());

    return lookup;
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> paymentKycDetailsFetchAll() {
    return paymentKycDetailsRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp paymentKycDetailsFetchById(UUID id) {
    CePaymentKycDetails entity =
        paymentKycDetailsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> poMovementFetchAll() {
    return poMovementRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp poMovementFetchById(UUID id) {
    CePoMovement entity =
        poMovementRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> quotationsFetchAll() {
    return quotationsRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp quotationsFetchById(UUID id) {
    CeQuotations entity =
        quotationsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> purchaseOrderFetchAll() {
    return purchaseOrderRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp purchaseOrderFetchById(UUID id) {
    CePurchaseOrder entity =
        purchaseOrderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> quotationsMovementFetchAll() {
    return quotationsMovementRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp quotationsMovementFetchById(UUID id) {
    CeQuotationsMovement entity =
        quotationsMovementRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> quotationsRevisionFetchAll() {
    return quotationsRevisionRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp quotationsRevisionFetchById(UUID id) {
    CeQuotationsRevision entity =
        quotationsRevisionRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> renewalDetailsFetchAll() {
    return renewalDetailsRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp renewalDetailsFetchById(UUID id) {
    CeRenewalDetails entity =
        renewalDetailsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> revisionConnectionBreakupFetchAll() {
    return revisionConnectionBreakupRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp revisionConnectionBreakupFetchById(UUID id) {
    CeRevisionConnectionBreakup entity =
        revisionConnectionBreakupRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> servicesListFetchAll() {
    return serviceListRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp servicesListFetchById(UUID id) {
    CeServiceList entity =
        serviceListRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> subCustomersFetchAll() {
    return subCustomersRepository.findAll().stream()
        .map(
            customers -> {
              CommonLookUp lookup = modelMapper.map(customers, CommonLookUp.class);
              lookup.setId(customers.getCustomersId());
              return lookup;
            })
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp subCustomersFetchById(UUID id) {
    CeSubCustomers customers =
        subCustomersRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));

    CommonLookUp lookup = modelMapper.map(customers, CommonLookUp.class);
    lookup.setId(customers.getCustomersId());

    return lookup;
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> subPackageFetchAll() {
    return subPackageRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp subPackageFetchById(UUID id) {
    CeSubPackage entity =
        subPackageRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> subPackageRenewalHistoryFetchAll() {
    return subPackageRenewalHistoryRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp subPackageRenewalHistoryFetchById(UUID id) {
    CeSubPackageRenewalHistory entity =
        subPackageRenewalHistoryRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }
}
