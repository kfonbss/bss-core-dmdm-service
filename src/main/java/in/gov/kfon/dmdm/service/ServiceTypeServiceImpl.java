package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.ServiceType;
import in.gov.kfon.dmdm.repository.ServiceRepository;
import in.gov.kfon.dmdm.repository.ServiceTypeRepository;
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
public class ServiceTypeServiceImpl implements ServiceTypeService {

  private final ServiceTypeRepository serviceTypeRepository;
  private final ServiceRepository serviceRepository;
  private final ModelMapper mapper;

  @Override
  @Cacheable(cacheNames = CacheNames.ALL_SERVICE_TYPES)
  public List<CommonLookUp> fetchAllServiceTypes() {
    return serviceTypeRepository.findAll().stream()
        .map(st -> mapper.map(st, CommonLookUp.class))
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.SERVICE_TYPE_BY_ID, key = "#id")
  public CommonLookUp fetchServiceTypeById(UUID id) {
    ServiceType entity =
        serviceTypeRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("ServiceType not found with id: " + id));
    return mapper.map(entity, CommonLookUp.class);
  }

  @Override
  @Cacheable(cacheNames = CacheNames.ALL_SERVICES)
  public List<CommonLookUp> fetchAllServices() {
    return serviceRepository.findAll().stream()
        .map(s -> mapper.map(s, CommonLookUp.class))
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.SERVICE_BY_ID, key = "#id")
  public CommonLookUp fetchServiceById(UUID id) {
    var entity =
        serviceRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Service not found with id: " + id));
    return mapper.map(entity, CommonLookUp.class);
  }
}
