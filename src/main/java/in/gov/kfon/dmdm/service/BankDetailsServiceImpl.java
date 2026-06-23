package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.BankDetailsResponse;
import in.gov.kfon.dmdm.model.BankDetails;
import in.gov.kfon.dmdm.repository.BankDetailsRepository;
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
public class BankDetailsServiceImpl implements BankDetailsService {
  private final BankDetailsRepository repository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_BANK_DETAILS)
  public List<BankDetailsResponse> fetchAll() {
    List<BankDetails> entities = repository.findAll();
    return entities.stream().map(bank -> modelMapper.map(bank, BankDetailsResponse.class)).toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.BANK_DETAILS_BY_ID, key = "#id")
  public BankDetailsResponse fetchById(UUID id) {
    return repository
        .findById(id)
        .map(bank -> modelMapper.map(bank, BankDetailsResponse.class))
        .orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.BANK_DETAILS_BY_IFSC, key = "#ifsc")
  public BankDetailsResponse fetchByIfsc(String ifsc) {
    return repository
        .findByBankIfscCode(ifsc)
        .map(bank -> modelMapper.map(bank, BankDetailsResponse.class))
        .orElse(null);
  }
}
