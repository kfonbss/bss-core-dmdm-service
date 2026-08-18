package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.StateResponse;
import in.gov.kfon.dmdm.model.State;
import in.gov.kfon.dmdm.repository.StateRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
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
  @Cacheable(cacheNames = CacheNames.ALL_STATES)
  public List<CommonLookUp> fetchAll() {
    return repository.findByIsActive(true).stream()
        .map(state -> modelMapper.map(state, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.STATE_BY_ID, key = "#id")
  public CommonLookUp fetchById(UUID id) {
    State state =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("State not found with id: " + id));
    return modelMapper.map(state, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(
      cacheNames = CacheNames.STATES_BY_CODES,
      key = "T(in.gov.kfon.dmdm.Config.CacheKeyUtil).sortedStrings(#codes)")
  public List<StateResponse> fetchStatesByCodes(List<String> codes) {
    return repository.findByCodeInAndIsActive(codes, true).stream()
        .map(
            state ->
                StateResponse.builder()
                    .id(state.getId())
                    .code(state.getCode())
                    .name(state.getName())
                    .build())
        .toList();
  }
}
