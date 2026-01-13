package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.StateResponse;
import in.gov.kfon.dmdm.model.State;
import in.gov.kfon.dmdm.repository.StateRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StateServiceImpl implements StateService {

  private final StateRepository repository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAll() {
    return repository.findAll().stream()
        .map(state -> modelMapper.map(state, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchById(UUID id) {
    State state =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("State not found with id: " + id));
    return modelMapper.map(state, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public StateResponse fetchStateByCode(String code) {
    Optional<State> state = repository.findByCodeAndIsActive(code, true).stream().findFirst();
    if (state.isPresent()) {
      return StateResponse.builder()
              .id(state.get().getId())
              .code(state.get().getCode())
              .name(state.get().getName()).build();
    } return StateResponse.builder().build();
  }
}
