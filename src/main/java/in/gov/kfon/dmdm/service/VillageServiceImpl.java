package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.Village;
import in.gov.kfon.dmdm.repository.VillageRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VillageServiceImpl implements VillageService {

  private final VillageRepository repository;

  /** Active villages of the sub-district, sorted by name, for the village dropdown. */
  @Override
  @Cacheable(cacheNames = CacheNames.VILLAGES_BY_SUB_DISTRICT, key = "#subDistrictId")
  public List<CommonLookUp> fetchBySubDistrictId(UUID subDistrictId) {
    return repository
        .findBySubDistrictSubDistrictIdAndIsActiveTrueOrderByNameAsc(subDistrictId)
        .stream()
        .map(village -> toLookUp(village, subDistrictId))
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.VILLAGE_BY_ID, key = "#id")
  public CommonLookUp fetchById(UUID id) {
    Village village =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("village not found with id: " + id));
    return toLookUp(village, village.getSubDistrict().getSubDistrictId());
  }

  private CommonLookUp toLookUp(Village village, UUID subDistrictId) {
    return CommonLookUp.builder()
        .id(village.getVillageId())
        .code(village.getCode())
        .name(village.getName())
        .nameInLocal(village.getNameInLocal())
        .isActive(village.getIsActive())
        .subDistrictId(subDistrictId)
        .build();
  }
}
