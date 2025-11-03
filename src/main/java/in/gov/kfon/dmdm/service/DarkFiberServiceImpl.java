package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.DfGroupDetails;
import in.gov.kfon.dmdm.model.DfGroupDetailsMovent;
import in.gov.kfon.dmdm.repository.DfGroupDetailsMoventRepository;
import in.gov.kfon.dmdm.repository.DfGroupDetailsRepository;
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
}
