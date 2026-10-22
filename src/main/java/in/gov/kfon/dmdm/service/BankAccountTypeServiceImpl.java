package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.BankAccountType;
import in.gov.kfon.dmdm.repository.BankAccountTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountTypeServiceImpl implements BankAccountTypeService {

  private static final String KFON_TENANT = "KFON";
  private static final Set<String> KFON_CODES = Set.of("CA", "CB");
  private static final Set<String> NON_KFON_CODES = Set.of("CA", "SB");

  private final BankAccountTypeRepository bankAccountTypeRepository;

  @Override
  public List<CommonLookUp> fetchAll() {
    return bankAccountTypeRepository.findByIsActiveTrueOrderByDisplayOrderAsc().stream()
        .map(this::toLookUp)
        .toList();
  }

  @Override
  public List<CommonLookUp> fetchAll(String tenantId) {
    Set<String> allowedCodes =
        tenantId != null && KFON_TENANT.equalsIgnoreCase(tenantId.trim())
            ? KFON_CODES
            : NON_KFON_CODES;
    return bankAccountTypeRepository.findByIsActiveTrueOrderByDisplayOrderAsc().stream()
        .filter(entity -> allowedCodes.contains(entity.getCode()))
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
