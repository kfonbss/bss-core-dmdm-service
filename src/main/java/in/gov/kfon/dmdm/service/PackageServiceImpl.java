package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.PackageCategory;
import in.gov.kfon.dmdm.model.PackageMap;
import in.gov.kfon.dmdm.repository.PackageCategoryRepository;
import in.gov.kfon.dmdm.repository.PackageMapRepository;
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
public class PackageServiceImpl implements PackageService {

  private final PackageMapRepository packageMapRepository;
  private final PackageCategoryRepository packageCategoryRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPackageMaps() {
    return packageMapRepository.findAll().stream()
        .map(pm -> modelMapper.map(pm, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPackageMapById(UUID id) {
    PackageMap pm =
        packageMapRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PackageMap not found with id: " + id));
    return modelMapper.map(pm, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPackageCategories() {
    return packageCategoryRepository.findAll().stream()
        .map(pc -> modelMapper.map(pc, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPackageCategoryById(UUID id) {
    PackageCategory pc =
        packageCategoryRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("PackageCategory not found with id: " + id));
    return modelMapper.map(pc, CommonLookUp.class);
  }
}
