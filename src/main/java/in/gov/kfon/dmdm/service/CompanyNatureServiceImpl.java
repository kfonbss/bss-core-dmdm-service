package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.CompanyNature;
import in.gov.kfon.dmdm.repository.CompanyNatureRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyNatureServiceImpl implements CompanyNatureService {

  private final CompanyNatureRepository companyNatureRepository;

  @Override
  public List<CommonLookUp> fetchAll() {
    return companyNatureRepository.findByIsActiveTrueOrderByDisplayOrderAsc().stream()
        .map(this::toLookUp)
        .toList();
  }

  @Override
  public CommonLookUp fetchById(UUID id) {
    return companyNatureRepository
        .findById(id)
        .map(this::toLookUp)
        .orElseThrow(() -> new EntityNotFoundException("Company Nature not found: " + id));
  }

  private CommonLookUp toLookUp(CompanyNature entity) {
    return CommonLookUp.builder()
        .id(entity.getId())
        .code(entity.getCode())
        .name(entity.getName())
        .isActive(entity.getIsActive())
        .build();
  }
}
