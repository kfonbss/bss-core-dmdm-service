package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.repository.*;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

  private final PartnerFinance2Repository financeRepo;
  private final PartnerTaxpayerLogsRepository taxRepo;
  private final ModelMapper modelMapper;

  @Override
  public List<CommonLookUp> fetchAllFinanceDetails() {
    return financeRepo.findAll().stream().map(f -> modelMapper.map(f, CommonLookUp.class)).toList();
  }

  @Override
  public CommonLookUp fetchFinanceDetailsById(UUID id) {
    var entity =
        financeRepo
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Finance2 not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllTaxpayerLogs() {
    return taxRepo.findAll().stream().map(t -> modelMapper.map(t, CommonLookUp.class)).toList();
  }

  @Override
  public CommonLookUp fetchTaxpayerLogById(UUID id) {
    var entity =
        taxRepo
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("TaxpayerLog not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }
}
