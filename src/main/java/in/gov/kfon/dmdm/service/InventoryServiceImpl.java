package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.model.InvDeviceMake;
import in.gov.kfon.dmdm.model.InvDeviceModel;
import in.gov.kfon.dmdm.model.InvDeviceReturnTooem;
import in.gov.kfon.dmdm.model.InvDeviceStatus;
import in.gov.kfon.dmdm.repository.*;
import in.gov.kfon.dmdm.repository.InvDeviceMakeRepository;
import in.gov.kfon.dmdm.repository.InvDeviceModelRepository;
import in.gov.kfon.dmdm.repository.InvDeviceReturnTooemRepository;
import in.gov.kfon.dmdm.repository.InvDeviceStatusRepository;
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
public class InventoryServiceImpl implements InventoryService {

  private final InvDeviceMakeRepository invDeviceMakeRepository;
  private final InvDeviceModelRepository invDeviceModelRepository;
  private final InvDeviceReturnTooemRepository invDeviceReturnTooemRepository;
  private final InvDeviceStatusRepository invDeviceStatusRepository;
  private final ModelMapper modelMapper;
  private final InvCreditNotesRepository creditNotesRepository;
  private final InvDcCreditNotesRepository dcCreditNotesRepository;
  private static final String NOT_FOUND = "Not found with id: ";
  private final InvDeviceAcknowledgementRepository deviceAcknowledgementRepository;
  private final InvDeviceCatRepository deviceCatRepository;
  private final InvDeviceDetailsRepository deviceDetailsRepository;
  private final InvDeviceDetailsAuditRepository deviceDetailsAuditRepository;
  private final InvDeviceTypeRepository invDeviceTypeRepository;
  private final InvDeviceVendorRepository invDeviceVendorRepository;

  @Override
  public List<CommonLookUp> fetchAllDeviceMakes() {
    return invDeviceMakeRepository.findAll().stream()
        .map(deviceMake -> modelMapper.map(deviceMake, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDeviceMakeById(UUID id) {
    InvDeviceMake deviceMake =
        invDeviceMakeRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Device Make not found with id: " + id));
    return modelMapper.map(deviceMake, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllDeviceModels() {
    return invDeviceModelRepository.findAll().stream()
        .map(model -> modelMapper.map(model, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDeviceModelById(UUID id) {
    InvDeviceModel deviceModel =
        invDeviceModelRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Device Model not found with id: " + id));
    return modelMapper.map(deviceModel, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> creditNotesFetchAll() {
    return creditNotesRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp creditNotesFetchById(UUID id) {
    InvCreditNotes entity =
        creditNotesRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> dcCreditNotesFetchAll() {
    return dcCreditNotesRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp dcCreditNotesFetchById(UUID id) {
    InvDcCreditNotes entity =
        dcCreditNotesRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> deviceAcknowledgementFetchAll() {
    return deviceAcknowledgementRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp deviceAcknowledgementFetchById(UUID id) {
    InvDeviceAcknowledgement entity =
        deviceAcknowledgementRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> deviceCatFetchAll() {
    return deviceCatRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp deviceCatFetchById(UUID id) {
    InvDeviceCat entity =
        deviceCatRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllDeviceReturns() {
    return invDeviceReturnTooemRepository.findAll().stream()
        .map(deviceReturn -> modelMapper.map(deviceReturn, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDeviceReturnById(UUID id) {
    InvDeviceReturnTooem deviceReturn =
        invDeviceReturnTooemRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Device Return not found with id: " + id));
    return modelMapper.map(deviceReturn, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllDeviceStatuses() {
    return invDeviceStatusRepository.findAll().stream()
        .map(deviceStatus -> modelMapper.map(deviceStatus, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDeviceStatusById(UUID id) {
    InvDeviceStatus deviceStatus =
        invDeviceStatusRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Device Status not found with id: " + id));
    return modelMapper.map(deviceStatus, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> deviceDetailsFetchAll() {
    return deviceDetailsRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp deviceDetailsFetchById(UUID id) {
    InvDeviceDetails entity =
        deviceDetailsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> deviceDetailsAuditsFetchAll() {
    return deviceDetailsAuditRepository.findAll().stream()
        .map(e -> modelMapper.map(e, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp deviceDetailsAuditsFetchById(UUID id) {
    InvDeviceDetailsAudit entity =
        deviceDetailsAuditRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllDeviceTypes() {
    return invDeviceTypeRepository.findAll().stream()
        .map(deviceType -> modelMapper.map(deviceType, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDeviceTypeById(UUID id) {
    var deviceType =
        invDeviceTypeRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Device Type not found with id: " + id));
    return modelMapper.map(deviceType, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllDeviceVendors() {
    return invDeviceVendorRepository.findAll().stream()
        .map(vendor -> modelMapper.map(vendor, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDeviceVendorById(UUID id) {
    var vendor =
        invDeviceVendorRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Device Vendor not found with id: " + id));
    return modelMapper.map(vendor, CommonLookUp.class);
  }
}
