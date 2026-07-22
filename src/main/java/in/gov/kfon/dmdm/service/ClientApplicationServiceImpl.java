package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.ClientApplicationRequest;
import in.gov.kfon.dmdm.contract.ClientApplicationResponse;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.repository.ClientApplicationRepository;
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
public class ClientApplicationServiceImpl implements ClientApplicationService {

  private final ClientApplicationRepository repository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<ClientApplicationResponse> fetchAll() {
    return repository.findByIsActive(true).stream()
        .map(app -> modelMapper.map(app, ClientApplicationResponse.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public ClientApplicationResponse fetchById(UUID id) {
    ClientApplication app =
        repository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Application not found with id: " + id));
    return modelMapper.map(app, ClientApplicationResponse.class);
  }

  @Override
  public ClientApplicationResponse create(ClientApplicationRequest request) {
    ClientApplication app =
        ClientApplication.builder()
            .appCode(request.getAppCode().toUpperCase())
            .appName(request.getAppName())
            .description(request.getDescription())
            .isActive(Boolean.TRUE)
            .build();
    return modelMapper.map(repository.save(app), ClientApplicationResponse.class);
  }

  @Override
  public ClientApplicationResponse update(UUID id, ClientApplicationRequest request) {
    ClientApplication app =
        repository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Application not found with id: " + id));
    app.setAppName(request.getAppName());
    app.setDescription(request.getDescription());
    if (request.getIsActive() != null) {
      app.setIsActive(request.getIsActive());
    }
    return modelMapper.map(repository.save(app), ClientApplicationResponse.class);
  }
}
