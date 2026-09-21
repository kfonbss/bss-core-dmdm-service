package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.repository.RailTerritoryNameRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TerritoryServiceImpl implements TerritoryService {

  private final RailTerritoryNameRepository repository;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_TERRITORIES, key = "#tenantId")
  public List<CommonLookUp> fetchAll(String tenantId) {
    return repository.findByCCodeAndStatus(tenantId, 1).stream()
        .map(
            territory ->
                CommonLookUp.builder()
                    .id(territory.getRailId())
                    .masterId(territory.getId())
                    .code(territory.getCCode())
                    .name(territory.getTerritoryName())
                    .stCode(territory.getStcode())
                    .isActive(true)
                    .build())
        .toList();
  }
}
