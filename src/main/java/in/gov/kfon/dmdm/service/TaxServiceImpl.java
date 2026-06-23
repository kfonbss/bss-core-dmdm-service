package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.TaxDetailResponse;
import in.gov.kfon.dmdm.contract.TaxTypeResponse;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.repository.*;
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
public class TaxServiceImpl implements TaxService {

  private final SampleTaxRepository repository;
  private final ModelMapper modelMapper;
  private final TaxCollectionRepository collectionRepository;
  private final TaxTypeRepository taxTypeRepository;
  private final TaxDetailRepository detailRepository;
  private final TaxPayerRepository payerRepository;
  private final TaxDisbursementRepository disbursementRepository;
  private final TaxDistributionRepository distributionRepository;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_SAMPLE_TAX)
  public List<CommonLookUp> fetchAll() {
    return repository.findAll().stream()
        .map(sampleTax -> modelMapper.map(sampleTax, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.SAMPLE_TAX_BY_ID, key = "#id")
  public CommonLookUp fetchById(UUID id) {
    SampleTax sampleTax =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Sample Tax not found with id: " + id));
    return modelMapper.map(sampleTax, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_TAX_COLLECTIONS)
  public List<CommonLookUp> collectionFetchAll() {
    return collectionRepository.findAll().stream()
        .map(taxCollection -> modelMapper.map(taxCollection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.TAX_COLLECTION_BY_ID, key = "#id")
  public CommonLookUp collectionFetchById(UUID id) {
    TaxCollection taxCollection =
        collectionRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tax not found with id: " + id));
    return modelMapper.map(taxCollection, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_TAX_TYPES)
  public List<CommonLookUp> typesFetchAll() {
    return taxTypeRepository.findAll().stream()
        .map(taxCollection -> modelMapper.map(taxCollection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.TAX_TYPES_BY_TYPE_ID, key = "#taxTypeId")
  public List<TaxTypeResponse> fetchByTaxTypeId(int taxTypeId) {
    return taxTypeRepository.findByTaxTypeId(taxTypeId).stream()
        .map(taxCollection -> modelMapper.map(taxCollection, TaxTypeResponse.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public List<TaxTypeResponse> taxTypeFetchAll() {
    return taxTypeRepository.findAll().stream()
            .map(taxCollection -> modelMapper.map(taxCollection, TaxTypeResponse.class))
            .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.TAX_TYPE_BY_ID, key = "#id")
  public CommonLookUp typeFetchById(UUID id) {
    TaxType taxType =
        taxTypeRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tax not found with id: " + id));
    return modelMapper.map(taxType, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_TAX_DETAILS)
  public List<CommonLookUp> detailsFetchAll() {
    return detailRepository.findAll().stream()
        .map(taxCollection -> modelMapper.map(taxCollection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.TAX_DETAIL_BY_ID, key = "#id")
  public CommonLookUp detailFetchById(UUID id) {
    TaxDetail taxDetail =
        detailRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tax not found with id: " + id));
    return modelMapper.map(taxDetail, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_TAX_PAYERS)
  public List<CommonLookUp> payersFetchAll() {
    return payerRepository.findAll().stream()
        .map(taxCollection -> modelMapper.map(taxCollection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.TAX_PAYER_BY_ID, key = "#id")
  public CommonLookUp payerFetchAll(UUID id) {
    TaxPayerType taxPayerType =
        payerRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tax not found with id: " + id));
    return modelMapper.map(taxPayerType, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_TAX_DISBURSEMENTS)
  public List<CommonLookUp> disbursementFetchAll() {
    return disbursementRepository.findAll().stream()
        .map(taxCollection -> modelMapper.map(taxCollection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.TAX_DISBURSEMENT_BY_ID, key = "#id")
  public CommonLookUp disbursementFetch(UUID id) {
    TaxDisbursement tax =
        disbursementRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tax not found with id: " + id));
    return modelMapper.map(tax, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_TAX_DISTRIBUTIONS)
  public List<CommonLookUp> distributionFetchAll() {
    return distributionRepository.findAll().stream()
        .map(taxCollection -> modelMapper.map(taxCollection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.TAX_DISTRIBUTION_BY_ID, key = "#id")
  public CommonLookUp distributionFetch(UUID id) {
    TaxDistribution tax =
        distributionRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tax not found with id: " + id));
    return modelMapper.map(tax, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ACTIVE_TAX_DETAIL)
  public TaxDetailResponse detailsFetchAllActive() {
    TaxDetail taxDetail = detailRepository.findFirstByIsActive(true).getFirst();
    return modelMapper.map(taxDetail, TaxDetailResponse.class);
  }
}
