package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.repository.RegionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegionServiceImpl implements RegionService {

  private final RegionRepository repository;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_REGIONS, unless = "#result == null || #result.isEmpty()")
  public List<CommonLookUp> fetchAll() {
    return repository.findByStatus(0).stream()
        .map(
            region ->
                CommonLookUp.builder()
                    .id(region.getId())
                    .masterId(region.getRegionId())
                    .code(region.getStateCode())
                    .stCode(region.getStCode())
                    .name(region.getName())
                    .nameInLocal(region.getRegion())
                    .isActive(true)
                    .build())
        .toList();
  }
}
