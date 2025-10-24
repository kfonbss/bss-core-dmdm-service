package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.SampleTax;
import in.gov.kfon.dmdm.model.TaxCollection;
import in.gov.kfon.dmdm.repository.SampleTaxRepository;
import in.gov.kfon.dmdm.repository.TaxCollectionRepository;
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
public class TaxServiceImpl implements TaxService {

  private final SampleTaxRepository repository;
  private final ModelMapper modelMapper;
  private final TaxCollectionRepository collectionRepository;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAll() {
    return repository.findAll().stream()
        .map(sampleTax -> modelMapper.map(sampleTax, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchById(UUID id) {
    SampleTax sampleTax =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Sample Tax not found with id: " + id));
    return modelMapper.map(sampleTax, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> collectionFetchAll() {
    return collectionRepository.findAll().stream()
        .map(taxCollection -> modelMapper.map(taxCollection, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp collectionFetchById(UUID id) {
    TaxCollection taxCollection =
        collectionRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tax not found with id: " + id));
    return modelMapper.map(taxCollection, CommonLookUp.class);
  }
}
