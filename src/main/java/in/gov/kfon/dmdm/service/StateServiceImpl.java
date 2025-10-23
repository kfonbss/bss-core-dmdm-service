package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.State;
import in.gov.kfon.dmdm.repository.StateRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StateServiceImpl implements StateService {

  private final StateRepository repository;

  @Override
  public List<CommonLookUp> fetchAll() {
    return repository.findAll().stream().map(this::convertToResponse).toList();
  }

  @Override
  public CommonLookUp fetchById(UUID id) {
    return repository.findById(id).map(this::convertToResponse).orElse(null);
  }

  private CommonLookUp convertToResponse(State state) {
    CommonLookUp response = new CommonLookUp();
    response.setId(state.getId());
    response.setCode(state.getCode());
    response.setName(state.getName());
    response.setNameInLocal(state.getNameInLocal());
    response.setIsActive(state.getIsActive());
    return response;
  }
}
