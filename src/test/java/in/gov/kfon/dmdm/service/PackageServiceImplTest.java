package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.Package;
import in.gov.kfon.dmdm.model.PackageCategory;
import in.gov.kfon.dmdm.model.PackageChangeRequests;
import in.gov.kfon.dmdm.model.PackageMap;
import in.gov.kfon.dmdm.model.Packages;
import in.gov.kfon.dmdm.repository.*;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

public class PackageServiceImplTest {

  @Mock private PackageMapRepository mapRepository;
  @Mock private PackageCategoryRepository categoryRepository;
  @Mock private PackageChangeRequestsRepository changeRequestRepository;
  @Mock private PackagesRepository packagesRepository;
  @Mock private PackageRepository packageRepository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private PackageServiceImpl service;

  private UUID idMap;
  private UUID idCategory;
  private UUID idChangeRequest;
  private UUID idPackages;
  private UUID idPackage;
  private PackageMap packageMap;
  private PackageCategory packageCategory;
  private PackageChangeRequests changeRequest;
  private Packages packages;
  private Package packageEntity;
  private CommonLookUp lookupMap;
  private CommonLookUp lookupCategory;
  private CommonLookUp lookupChangeRequest;
  private CommonLookUp lookupPackages;
  private CommonLookUp lookupPackage;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    idMap = UUID.randomUUID();
    idCategory = UUID.randomUUID();
    idChangeRequest = UUID.randomUUID();

    packageMap = new PackageMap();
    packageMap.setId(idMap);
    packageMap.setName("Basic Package Map");

    packageCategory = new PackageCategory();
    packageCategory.setId(idCategory);
    packageCategory.setName("Internet Packages");

    lookupMap = new CommonLookUp();
    lookupMap.setId(idMap);
    lookupMap.setName("Basic Package Map");

    lookupCategory = new CommonLookUp();
    lookupCategory.setId(idCategory);
    lookupCategory.setName("Internet Packages");

    changeRequest = new PackageChangeRequests();
    changeRequest.setId(idChangeRequest);
    changeRequest.setName("Change Request 1");

    lookupChangeRequest = new CommonLookUp();
    lookupChangeRequest.setId(idChangeRequest);
    lookupChangeRequest.setName("Change Request 1");

    packages = new Packages();
    packages.setId(idPackages);
    packages.setName("Internet Pack 1");

    packageEntity = new Package();
    packageEntity.setId(idPackage);
    packageEntity.setName("Regular Pack 1");

    lookupPackages = new CommonLookUp();
    lookupPackages.setId(idPackages);
    lookupPackages.setName("Internet Pack 1");

    lookupPackage = new CommonLookUp();
    lookupPackage.setId(idPackage);
    lookupPackage.setName("Regular Pack 1");
  }

  @Test
  void testFetchAllPackageMaps() {
    when(mapRepository.findAll()).thenReturn(List.of(packageMap));
    when(modelMapper.map(packageMap, CommonLookUp.class)).thenReturn(lookupMap);

    List<CommonLookUp> result = service.fetchAllPackageMaps();
    assertEquals(1, result.size());
    assertEquals(idMap, result.get(0).getId());
  }

  @Test
  void testFetchPackageMapById_Success() {
    when(mapRepository.findById(idMap)).thenReturn(Optional.of(packageMap));
    when(modelMapper.map(packageMap, CommonLookUp.class)).thenReturn(lookupMap);

    CommonLookUp result = service.fetchPackageMapById(idMap);
    assertEquals(idMap, result.getId());
  }

  @Test
  void testFetchPackageMapById_NotFound() {
    when(mapRepository.findById(idMap)).thenReturn(Optional.empty());
    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchPackageMapById(idMap));
    assertEquals("PackageMap not found with id: " + idMap, exception.getMessage());
  }

  @Test
  void testFetchAllPackageCategories() {
    when(categoryRepository.findAll()).thenReturn(List.of(packageCategory));
    when(modelMapper.map(packageCategory, CommonLookUp.class)).thenReturn(lookupCategory);

    List<CommonLookUp> result = service.fetchAllPackageCategories();
    assertEquals(1, result.size());
    assertEquals(idCategory, result.get(0).getId());
  }

  @Test
  void testFetchPackageCategoryById_Success() {
    when(categoryRepository.findById(idCategory)).thenReturn(Optional.of(packageCategory));
    when(modelMapper.map(packageCategory, CommonLookUp.class)).thenReturn(lookupCategory);

    CommonLookUp result = service.fetchPackageCategoryById(idCategory);
    assertEquals(idCategory, result.getId());
  }

  @Test
  void testFetchPackageCategoryById_NotFound() {
    when(categoryRepository.findById(idCategory)).thenReturn(Optional.empty());
    EntityNotFoundException exception =
        assertThrows(
            EntityNotFoundException.class, () -> service.fetchPackageCategoryById(idCategory));
    assertEquals("PackageCategory not found with id: " + idCategory, exception.getMessage());
  }

  @Test
  void testFetchAllPackageChangeRequests() {
    when(changeRequestRepository.findAll()).thenReturn(List.of(changeRequest));
    when(modelMapper.map(changeRequest, CommonLookUp.class)).thenReturn(lookupChangeRequest);

    List<CommonLookUp> result = service.fetchAllChangeRequests();
    assertEquals(1, result.size());
    assertEquals(idChangeRequest, result.get(0).getId());
  }

  @Test
  void testFetchPackageChangeRequestById_Success() {
    when(changeRequestRepository.findById(idChangeRequest)).thenReturn(Optional.of(changeRequest));
    when(modelMapper.map(changeRequest, CommonLookUp.class)).thenReturn(lookupChangeRequest);

    CommonLookUp result = service.fetchChangeRequestById(idChangeRequest);
    assertEquals(idChangeRequest, result.getId());
  }

  @Test
  void testFetchById_NotFound() {
    when(changeRequestRepository.findById(idChangeRequest)).thenReturn(Optional.empty());
    EntityNotFoundException exception =
        assertThrows(
            EntityNotFoundException.class, () -> service.fetchChangeRequestById(idChangeRequest));
    assertEquals("ChangeRequest not found with id: " + idChangeRequest, exception.getMessage());
    verify(changeRequestRepository, times(1)).findById(idChangeRequest);
  }

  @Test
  void testFetchAllPackages() {
    when(packagesRepository.findAll()).thenReturn(List.of(packages));
    when(modelMapper.map(packages, CommonLookUp.class)).thenReturn(lookupPackages);

    List<CommonLookUp> result = service.fetchAllPackages();
    assertEquals(1, result.size());
    assertEquals(idPackages, result.get(0).getId());
  }

  @Test
  void testFetchPackagesById_Success() {
    when(packagesRepository.findById(idPackages)).thenReturn(Optional.of(packages));
    when(modelMapper.map(packages, CommonLookUp.class)).thenReturn(lookupPackages);

    CommonLookUp result = service.fetchPackagesById(idPackages);
    assertEquals(idPackages, result.getId());
  }

  @Test
  void testFetchPackagesById_NotFound() {
    when(packagesRepository.findById(idPackages)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchPackagesById(idPackages));

    assertEquals("Packages not found with id: " + idPackages, exception.getMessage());
  }

  @Test
  void testFetchAllPackageEntities() {
    when(packageRepository.findAll()).thenReturn(List.of(packageEntity));
    when(modelMapper.map(packageEntity, CommonLookUp.class)).thenReturn(lookupPackage);

    List<CommonLookUp> result = service.fetchAllPackage();
    assertEquals(1, result.size());
    assertEquals(idPackage, result.get(0).getId());
  }

  @Test
  void testFetchPackageEntityById_Success() {
    when(packageRepository.findById(idPackage)).thenReturn(Optional.of(packageEntity));
    when(modelMapper.map(packageEntity, CommonLookUp.class)).thenReturn(lookupPackage);

    CommonLookUp result = service.fetchPackageById(idPackage);
    assertEquals(idPackage, result.getId());
  }

  @Test
  void testFetchPackageEntityById_NotFound() {
    when(packageRepository.findById(idPackage)).thenReturn(Optional.empty());
    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchPackageById(idPackage));

    assertEquals("Package not found with id: " + idPackage, exception.getMessage());
  }
}
