package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.OltProviderRequest;
import in.gov.kfon.dmdm.contract.OltProviderResponse;
import in.gov.kfon.dmdm.model.OltProvider;
import in.gov.kfon.dmdm.repository.OltProviderRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OltProviderServiceImpl implements OltProviderService {

  private final OltProviderRepository oltProviderRepository;
  private final ModelMapper modelMapper;

  private static final Set<String> KFON_PROVIDERS = Set.of("LNP", "KFON");
  private static final Set<String> BNU_PROVIDERS = Set.of("BNU", "ANP");

  /** KFON tenant sees LNP/KFON, BNU tenants (BNU, BNU-KA) see BNU/ANP, any other tenant none. */
  @Override
  public List<OltProviderResponse> fetchAll(String tenantId) {
    Set<String> allowed = allowedProviders(tenantId);
    if (allowed.isEmpty()) return List.of();
    return oltProviderRepository.findAll().stream()
        .filter(
            oltProvider ->
                oltProvider.getName() != null
                    && allowed.contains(oltProvider.getName().trim().toUpperCase()))
        .map(oltProvider -> modelMapper.map(oltProvider, OltProviderResponse.class))
        .toList();
  }

  private static Set<String> allowedProviders(String tenantId) {
    if (tenantId == null || tenantId.isBlank()) return Set.of();
    String tenant = tenantId.trim().toUpperCase();
    if ("KFON".equals(tenant)) return KFON_PROVIDERS;
    if (tenant.startsWith("BNU")) return BNU_PROVIDERS;
    return Set.of();
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
