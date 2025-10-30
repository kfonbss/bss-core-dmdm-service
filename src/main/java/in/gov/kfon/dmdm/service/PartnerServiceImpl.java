package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
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

  private final PartnerFinance2Repository partnerFinance2Repository;
  private final PartnerTaxpayerLogsRepository taxpayerLogsRepository;
  private final PartnerGroupRepository partnerGroupRepository;
  private final PartnerGstDetailRepository partnerGstDetailRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<CommonLookUp> fetchAllFinanceDetails() {
    return partnerFinance2Repository.findAll().stream()
        .map(f -> modelMapper.map(f, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchFinanceDetailsById(UUID id) {
    var entity =
        partnerFinance2Repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Finance2 not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllTaxpayerLogs() {
    return taxpayerLogsRepository.findAll().stream()
        .map(t -> modelMapper.map(t, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchTaxpayerLogById(UUID id) {
    var entity =
        taxpayerLogsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("TaxpayerLog not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerGroups() {
    return partnerGroupRepository.findAll().stream()
        .map(g -> modelMapper.map(g, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerGroupById(UUID id) {
    var entity =
        partnerGroupRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PartnerGroup not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerGstDetails() {
    return partnerGstDetailRepository.findAll().stream()
        .map(g -> modelMapper.map(g, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerGstDetailById(UUID id) {
    var entity =
        partnerGstDetailRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PartnerGstDetail not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }
}
