package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.ServiceType;
import in.gov.kfon.dmdm.repository.ServiceTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ServiceTypeServiceImpl implements ServiceTypeService {

  private final ServiceTypeRepository serviceTypeRepository;
  private final ModelMapper mapper;

  @Override
  public List<CommonLookUp> fetchAllServiceTypes() {
    return serviceTypeRepository.findAll().stream()
        .map(st -> mapper.map(st, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchServiceTypeById(UUID id) {
    ServiceType entity =
        serviceTypeRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("ServiceType not found with id: " + id));
    return mapper.map(entity, CommonLookUp.class);
  }
}
