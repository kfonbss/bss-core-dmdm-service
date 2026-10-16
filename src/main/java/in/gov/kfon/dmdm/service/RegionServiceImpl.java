package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.Region;
import in.gov.kfon.dmdm.repository.RegionRepository;
import jakarta.persistence.EntityNotFoundException;
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
    return repository.findByStatus(0).stream().map(this::toLookUp).toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.REGION_BY_STATE_CODE, key = "#stateCode.trim().toUpperCase()")
  public CommonLookUp fetchByStateCode(String stateCode) {
    return repository.findByStateCodeIgnoreCase(stateCode.trim()).stream()
        .findFirst()
        .map(this::toLookUp)
        .orElseThrow(
            () -> new EntityNotFoundException("Region not found for state code: " + stateCode));
  }

  private CommonLookUp toLookUp(Region region) {
    return CommonLookUp.builder()
        .id(region.getId())
        .masterId(region.getRegionId())
        .code(region.getStateCode())
        .stCode(region.getStCode())
        .name(region.getName())
        .nameInLocal(region.getRegion())
        .isActive(true)
        .build();
  }
}
