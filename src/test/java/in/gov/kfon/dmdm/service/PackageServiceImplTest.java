package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.PackageCategory;
import in.gov.kfon.dmdm.model.PackageMap;
import in.gov.kfon.dmdm.repository.PackageCategoryRepository;
import in.gov.kfon.dmdm.repository.PackageMapRepository;
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
  @Mock private ModelMapper modelMapper;

  @InjectMocks private PackageServiceImpl service;

  private UUID idMap;
  private UUID idCategory;
  private PackageMap packageMap;
  private PackageCategory packageCategory;
  private CommonLookUp lookupMap;
  private CommonLookUp lookupCategory;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    idMap = UUID.randomUUID();
    idCategory = UUID.randomUUID();

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
}
