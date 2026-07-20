package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.OltProviderRequest;
import in.gov.kfon.dmdm.contract.OltProviderResponse;
import in.gov.kfon.dmdm.model.OltProvider;
import in.gov.kfon.dmdm.repository.OltProviderRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OltProviderServiceImpl implements OltProviderService {

  private final OltProviderRepository oltProviderRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<OltProviderResponse> fetchAll() {
    return oltProviderRepository.findAll().stream()
        .map(oltProvider -> modelMapper.map(oltProvider, OltProviderResponse.class))
        .toList();
  }

  @Override
  public OltProviderResponse fetchById(UUID id) {
    var entity =
        oltProviderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("OltProvider not found: " + id));
    return modelMapper.map(entity, OltProviderResponse.class);
  }

  @Override
  public OltProviderResponse create(OltProviderRequest request) {
    OltProvider oltProvider = modelMapper.map(request, OltProvider.class);
    oltProvider.setId(null);
    OltProvider saved = oltProviderRepository.save(oltProvider);
    return modelMapper.map(saved, OltProviderResponse.class);
  }

  @Override
  public OltProviderResponse update(UUID id, OltProviderRequest request) {
    OltProvider oltProvider =
        oltProviderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("OltProvider not found: " + id));
    oltProvider.setName(request.getName());
    oltProvider.setDescription(request.getDescription());
    oltProvider.setIsActive(request.getIsActive());
    OltProvider saved = oltProviderRepository.save(oltProvider);
    return modelMapper.map(saved, OltProviderResponse.class);
  }
}
