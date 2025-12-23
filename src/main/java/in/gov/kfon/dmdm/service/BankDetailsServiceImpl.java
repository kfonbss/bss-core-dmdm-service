package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.BankDetailsResponse;
import in.gov.kfon.dmdm.model.BankDetails;
import in.gov.kfon.dmdm.repository.BankDetailsRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
  public List<BankDetailsResponse> fetchAll() {
    List<BankDetails> entities = repository.findAll();
    return entities.stream().map(bank -> modelMapper.map(bank, BankDetailsResponse.class)).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public BankDetailsResponse fetchById(UUID id) {
    return repository
        .findById(id)
        .map(bank -> modelMapper.map(bank, BankDetailsResponse.class))
        .orElse(null);
  }

  @Override
  @Transactional(readOnly = true)
  public BankDetailsResponse fetchByIfsc(String ifsc) {
    return repository
        .findByBankIfscCode(ifsc)
        .map(bank -> modelMapper.map(bank, BankDetailsResponse.class))
        .orElse(null);
  }
}
