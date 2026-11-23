package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.SubDistrict;
import in.gov.kfon.dmdm.repository.SubDistrictRepository;
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
public class SubDistrictServiceImpl implements SubDistrictService {

  private final SubDistrictRepository repository;

  /** Active sub-districts of the district, sorted by name, for the sub-district dropdown. */
  @Override
  @Cacheable(cacheNames = CacheNames.SUB_DISTRICTS_BY_DISTRICT, key = "#districtId")
  public List<CommonLookUp> fetchByDistrictId(UUID districtId) {
    return repository.findByDistrictDistrictIdAndIsActiveTrueOrderByNameAsc(districtId).stream()
        .map(subDistrict -> toLookUp(subDistrict, districtId))
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.SUB_DISTRICT_BY_ID, key = "#id")
  public CommonLookUp fetchById(UUID id) {
    SubDistrict subDistrict =
        repository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("sub-district not found with id: " + id));
    return toLookUp(subDistrict, subDistrict.getDistrict().getDistrictId());
  }

  private CommonLookUp toLookUp(SubDistrict subDistrict, UUID districtId) {
    return CommonLookUp.builder()
        .id(subDistrict.getSubDistrictId())
        .code(subDistrict.getCode())
        .name(subDistrict.getName())
        .nameInLocal(subDistrict.getNameInLocal())
        .isActive(subDistrict.getIsActive())
        .districtId(districtId)
        .build();
  }
}
