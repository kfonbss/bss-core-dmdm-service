package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.DfGroupDetails;
import in.gov.kfon.dmdm.model.DfGroupDetailsMovent;
import in.gov.kfon.dmdm.model.DfGroupInvoice;
import in.gov.kfon.dmdm.model.DfGroupInvoiceMaster;
import in.gov.kfon.dmdm.repository.DfGroupDetailsMoventRepository;
import in.gov.kfon.dmdm.repository.DfGroupDetailsRepository;
import in.gov.kfon.dmdm.repository.DfGroupInvoiceMasterRepository;
import in.gov.kfon.dmdm.repository.DfGroupInvoiceRepository;
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
public class DarkFiberServiceImpl implements DarkFiberService {

  private final DfGroupDetailsRepository dfGroupDetailsRepository;
  private final DfGroupDetailsMoventRepository dfGroupDetailsMoventRepository;
  private final DfGroupInvoiceRepository dfGroupInvoiceRepository;
  private final DfGroupInvoiceMasterRepository dfGroupInvoiceMasterRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllGroupDetails() {
    return dfGroupDetailsRepository.findAll().stream()
        .map(entity -> modelMapper.map(entity, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchGroupDetailsById(UUID id) {
    DfGroupDetails details =
        dfGroupDetailsRepository
            .findByDetailsId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Group Details not found with id: " + id));
    return modelMapper.map(details, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllGroupMovements() {
    return dfGroupDetailsMoventRepository.findAll().stream()
        .map(entity -> modelMapper.map(entity, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchGroupMovementById(UUID id) {
    DfGroupDetailsMovent movent =
        dfGroupDetailsMoventRepository
            .findByMoventId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Group Movement not found with id: " + id));
    return modelMapper.map(movent, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllGroupInvoices() {
    return dfGroupInvoiceRepository.findAll().stream()
        .map(dfGroupInvoice -> modelMapper.map(dfGroupInvoice, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchGroupInvoiceById(UUID id) {
    DfGroupInvoice invoice =
        dfGroupInvoiceRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Group Invoice not found with id: " + id));
    return modelMapper.map(invoice, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllGroupInvoiceMasters() {
    return dfGroupInvoiceMasterRepository.findAll().stream()
        .map(dfGroupInvoiceMaster -> modelMapper.map(dfGroupInvoiceMaster, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchGroupInvoiceMasterById(UUID id) {
    DfGroupInvoiceMaster master =
        dfGroupInvoiceMasterRepository
            .findByMasterId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Group Invoice Master not found with id: " + id));
    return modelMapper.map(master, CommonLookUp.class);
  }
}
