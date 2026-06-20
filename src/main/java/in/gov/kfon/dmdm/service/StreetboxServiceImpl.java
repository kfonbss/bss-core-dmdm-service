package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.StreetboxDto;
import in.gov.kfon.dmdm.model.StreetboxLocation;
import in.gov.kfon.dmdm.repository.StreetboxLocationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StreetboxServiceImpl implements StreetboxService {

  private final StreetboxLocationRepository streetboxLocationRepository;

  @Override
  @Cacheable(cacheNames = CacheNames.ALL_STREETBOXES)
  public List<StreetboxDto> fetchAllStreetboxes() {
    return streetboxLocationRepository.findAll().stream()
        .filter(s -> s.getLatitude() != null && s.getLongitude() != null)
        .map(this::mapToDto)
        .toList();
  }

  private StreetboxDto mapToDto(StreetboxLocation s) {
    return StreetboxDto.builder()
        .equipmentName(s.getEquipmentName())
        .popName(s.getPopName())
        .district(s.getDistrict())
        .popType(s.getPopType())
        .latitude(s.getLatitude())
        .longitude(s.getLongitude())
        .type(s.getType())
        .category(s.getCategory())
        .build();
  }
}
