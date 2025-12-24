package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.RevenueShare;
import in.gov.kfon.dmdm.repository.RevenueShareRepository;
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
public class RevenueServiceImpl implements RevenueService {
  private final RevenueShareRepository repository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchRevenue() {
    return repository.findAll().stream()
        .filter(RevenueShare::getIsActive)
        .map(pm -> modelMapper.map(pm, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchRevenueById(UUID id) {
    RevenueShare revenueShare =
        repository
            .findById(id)
            .filter(RevenueShare::getIsActive)
            .orElseThrow(
                () -> new EntityNotFoundException("Active record not found with id: " + id));

    return modelMapper.map(revenueShare, CommonLookUp.class);
  }
}
