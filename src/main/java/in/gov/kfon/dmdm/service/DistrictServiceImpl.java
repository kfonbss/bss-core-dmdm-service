package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.District;
import in.gov.kfon.dmdm.repository.DistrictRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DistrictServiceImpl implements DistrictService {

  private final DistrictRepository repository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_DISTRICTS)
  public List<CommonLookUp> fetchAll() {
    return repository.findAll().stream()
        .map(district -> modelMapper.map(district, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.DISTRICT_BY_ID, key = "#id")
  public CommonLookUp fetchById(UUID id) {
    District district =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("district not found with id: " + id));
    return modelMapper.map(district, CommonLookUp.class);
  }
}
