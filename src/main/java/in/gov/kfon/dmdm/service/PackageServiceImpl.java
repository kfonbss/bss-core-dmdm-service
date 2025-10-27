package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.Package;
import in.gov.kfon.dmdm.model.PackageCategory;
import in.gov.kfon.dmdm.model.PackageChangeRequests;
import in.gov.kfon.dmdm.model.PackageMap;
import in.gov.kfon.dmdm.model.Packages;
import in.gov.kfon.dmdm.repository.*;
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
  private final PackageChangeRequestsRepository changeRequestsRepository;
  private final PackageRepository packageRepository;
  private final PackagesRepository packagesRepository;
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

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllChangeRequests() {
    return changeRequestsRepository.findAll().stream()
        .map(cr -> modelMapper.map(cr, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchChangeRequestById(UUID id) {
    PackageChangeRequests cr =
        changeRequestsRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("ChangeRequest not found with id: " + id));
    return modelMapper.map(cr, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPackages() {
    return packagesRepository.findAll().stream()
        .map(p -> modelMapper.map(p, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPackagesById(UUID id) {
    Packages p =
        packagesRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Packages not found with id: " + id));
    return modelMapper.map(p, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPackage() {
    return packageRepository.findAll().stream()
        .map(p -> modelMapper.map(p, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPackageById(UUID id) {
    Package p =
        packageRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Package not found with id: " + id));
    return modelMapper.map(p, CommonLookUp.class);
  }
}
