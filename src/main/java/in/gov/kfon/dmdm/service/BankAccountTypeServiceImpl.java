package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.BankAccountType;
import in.gov.kfon.dmdm.repository.BankAccountTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountTypeServiceImpl implements BankAccountTypeService {

  private final BankAccountTypeRepository bankAccountTypeRepository;

  @Override
  public List<CommonLookUp> fetchAll() {
    return bankAccountTypeRepository.findByIsActiveTrueOrderByDisplayOrderAsc().stream()
        .map(this::toLookUp)
        .toList();
  }

  @Override
  public CommonLookUp fetchById(UUID id) {
    return bankAccountTypeRepository
        .findById(id)
        .map(this::toLookUp)
        .orElseThrow(() -> new EntityNotFoundException("Bank Account Type not found: " + id));
  }

  private CommonLookUp toLookUp(BankAccountType entity) {
    return CommonLookUp.builder()
        .id(entity.getId())
        .code(entity.getCode())
        .name(entity.getName())
        .isActive(entity.getIsActive())
        .build();
  }
}
