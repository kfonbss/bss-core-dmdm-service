package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.DfPopList;
import in.gov.kfon.dmdm.model.PopMaster;
import in.gov.kfon.dmdm.model.PopMasterBackup;
import in.gov.kfon.dmdm.repository.DfPopListRepository;
import in.gov.kfon.dmdm.repository.PopMasterBackupRepository;
import in.gov.kfon.dmdm.repository.PopMasterRepository;
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
public class PopServiceImpl implements PopService {

  private final PopMasterRepository popMasterRepository;
  private final PopMasterBackupRepository popMasterBackupRepository;
  private final DfPopListRepository dfPopListRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPopMasters() {
    return popMasterRepository.findAll().stream()
        .map(pm -> modelMapper.map(pm, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPopMasterById(UUID id) {
    PopMaster popMaster =
        popMasterRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PopMaster not found with id: " + id));
    return modelMapper.map(popMaster, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPopMasterBackups() {
    return popMasterBackupRepository.findAll().stream()
        .map(pb -> modelMapper.map(pb, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPopMasterBackupById(UUID id) {
    PopMasterBackup popMasterBackup =
        popMasterBackupRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("PopMasterBackup not found with id: " + id));
    return modelMapper.map(popMasterBackup, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllDfPopLists() {
    return dfPopListRepository.findAll().stream()
        .map(df -> modelMapper.map(df, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchDfPopById(UUID id) {
    DfPopList dfPop =
        dfPopListRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("DfPopList not found with id: " + id));
    return modelMapper.map(dfPop, CommonLookUp.class);
  }
}
