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
public class SpecialEventsServiceImpl implements SpecialEventsService {
  private static final String NOT_FOUND = "Not found with id: ";
  private final SeCustomersRepository customersRepository;
  private final SeDisbursementRepository disbursementRepository;
  private final ModelMapper modelMapper;
  private final SeInvoiceMasterRepository invoiceMasterRepository;
  private final SeInvoiceRepository invoiceRepository;
  private final SeKycDetailsRepository kycDetailsRepository;
  private final SeLocationMovementRepository locationMovementRepository;
  private final SeLocationsRepository locationsRepository;
  private final SeLocFinanceRepository locFinanceRepository;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> customersFetchAll() {
    return customersRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp customersFetchById(UUID id) {
    SeCustomers entity =
        customersRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> disbursementFetchAll() {
    return disbursementRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp disbursementFetchById(UUID id) {
    SeDisbursement entity =
        disbursementRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> invoiceMasterFetchAll() {
    return invoiceMasterRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp invoiceMasterFetchById(UUID id) {
    SeInvoiceMaster entity =
        invoiceMasterRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> invoiceFetchAll() {
    return invoiceRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp invoiceFetchById(UUID id) {
    SeInvoice entity =
        invoiceRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> kycDetailsFetchAll() {
    return kycDetailsRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp kycDetailsFetchById(UUID id) {
    SeKycDetails entity =
        kycDetailsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> locationMovementsFetchAll() {
    return locationMovementRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp locationMovementsFetchById(UUID id) {
    SeLocationMovement entity =
        locationMovementRepository
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
    SeLocations entity =
        locationsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> locFinanceFetchAll() {
    return locFinanceRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp locFinanceFetchById(UUID id) {
    SeLocFinance entity =
        locFinanceRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }
}
