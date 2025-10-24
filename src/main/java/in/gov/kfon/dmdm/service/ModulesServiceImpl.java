package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.Modules;
import in.gov.kfon.dmdm.repository.ModulesRepository;
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
public class ModulesServiceImpl implements ModulesService {

  private final ModulesRepository repository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAll() {
    return repository.findAll().stream()
        .map(modules -> modelMapper.map(modules, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchById(UUID id) {
    Modules modules =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Modules not found with id: " + id));
    return modelMapper.map(modules, CommonLookUp.class);
  }
}
