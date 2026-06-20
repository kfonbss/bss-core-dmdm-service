package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.CompanyDetail;
import in.gov.kfon.dmdm.repository.CompanyDetailRepository;
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
public class CompanyDetailServiceImpl implements CompanyDetailService {

  private final CompanyDetailRepository companyDetailRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_COMPANY_DETAILS)
  public List<CommonLookUp> fetchAllCompanyDetails() {
    return companyDetailRepository.findAll().stream()
        .map(cd -> modelMapper.map(cd, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.COMPANY_DETAIL_BY_ID, key = "#id")
  public CommonLookUp fetchCompanyDetailById(UUID id) {
    CompanyDetail companyDetail =
        companyDetailRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("CompanyDetail not found with id: " + id));
    return modelMapper.map(companyDetail, CommonLookUp.class);
  }
}
