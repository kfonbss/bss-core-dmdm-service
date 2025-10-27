package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.PackageService;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PackageController.class})
public class PackageControllerTest {

  private MockMvc mockMvc;

  @MockBean private PackageService service;

  @Autowired private PackageController controller;

  private UUID idMap;
  private UUID idCategory;
  private UUID idChangeRequest;
  private UUID idPackages;
  private UUID idPackage;
  private CommonLookUp lookupMap;
  private CommonLookUp lookupCategory;
  private CommonLookUp lookupChangeRequest;
  private CommonLookUp lookupPackages;
  private CommonLookUp lookupPackage;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    idMap = UUID.randomUUID();
    idCategory = UUID.randomUUID();
    idChangeRequest = UUID.randomUUID();
    idPackages = UUID.randomUUID();
    idPackage = UUID.randomUUID();

    lookupMap = new CommonLookUp();
    lookupMap.setId(idMap);
    lookupMap.setCode("PKGMAP001");
    lookupMap.setName("Basic Package Map");
    lookupMap.setNameInLocal("ബേസിക് പാക്കേജ് മാപ്പ്");
    lookupMap.setIsActive(true);

    lookupCategory = new CommonLookUp();
    lookupCategory.setId(idCategory);
    lookupCategory.setCode("PKGCTG001");
    lookupCategory.setName("Internet Packages");
    lookupCategory.setNameInLocal("ഇന്റർനെറ്റ്");
    lookupCategory.setIsActive(true);

    lookupChangeRequest = new CommonLookUp();
    lookupChangeRequest.setId(idChangeRequest);
    lookupChangeRequest.setCode("REQ001");
    lookupChangeRequest.setName("Change Request 1");
    lookupChangeRequest.setNameInLocal("ചേഞ്ച് റിക്വസ്റ്റ് 1");
    lookupChangeRequest.setIsActive(true);

    lookupPackages = new CommonLookUp();
    lookupPackages.setId(idPackages);
    lookupPackages.setCode("PKGS001");
    lookupPackages.setName("Internet Pack 1");
    lookupPackages.setNameInLocal("ഇന്റർനെറ്റ് പാക്ക് 1");
    lookupPackages.setIsActive(true);

    lookupPackage = new CommonLookUp();
    lookupPackage.setId(idPackage);
    lookupPackage.setCode("PKG001");
    lookupPackage.setName("Regular Pack 1");
    lookupPackage.setNameInLocal("റെഗുലർ പാക്ക് 1");
    lookupPackage.setIsActive(true);
  }

  @Test
  void testFetchAllPackageMaps() throws Exception {
    when(service.fetchAllPackageMaps()).thenReturn(List.of(lookupMap));

    mockMvc
        .perform(get("/api/package/maps"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all package maps"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idMap.toString()));
  }

  @Test
  void testFetchPackageMapById() throws Exception {
    when(service.fetchPackageMapById(idMap)).thenReturn(lookupMap);

    mockMvc
        .perform(get("/api/package/map/{id}", idMap))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched package map"))
        .andExpect(jsonPath("$.data.id").value(idMap.toString()))
        .andExpect(jsonPath("$.data.name").value("Basic Package Map"));
  }

  @Test
  void testFetchAllPackageCategories() throws Exception {
    when(service.fetchAllPackageCategories()).thenReturn(List.of(lookupCategory));

    mockMvc
        .perform(get("/api/package/categories"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all package categories"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idCategory.toString()));
  }

  @Test
  void testFetchPackageCategoryById() throws Exception {
    when(service.fetchPackageCategoryById(idCategory)).thenReturn(lookupCategory);

    mockMvc
        .perform(get("/api/package/category/{id}", idCategory))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched package category"))
        .andExpect(jsonPath("$.data.id").value(idCategory.toString()))
        .andExpect(jsonPath("$.data.name").value("Internet Packages"));
  }

  @Test
  void testFetchAllPackageChangeRequests() throws Exception {
    when(service.fetchAllChangeRequests()).thenReturn(List.of(lookupChangeRequest));

    mockMvc
        .perform(get("/api/package/change-requests"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all change requests"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idChangeRequest.toString()));
  }

  @Test
  void testFetchPackageChangeRequestById() throws Exception {
    when(service.fetchChangeRequestById(idChangeRequest)).thenReturn(lookupChangeRequest);

    mockMvc
        .perform(get("/api/package/change-request/{id}", idChangeRequest))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched change request"))
        .andExpect(jsonPath("$.data.id").value(idChangeRequest.toString()));
  }

  @Test
  void testFetchAllPackages() throws Exception {
    when(service.fetchAllPackages()).thenReturn(List.of(lookupPackages));

    mockMvc
        .perform(get("/api/package"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all packages"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idPackages.toString()));
  }

  @Test
  void testFetchPackageById() throws Exception {
    when(service.fetchPackagesById(idPackages)).thenReturn(lookupPackages);

    mockMvc
        .perform(get("/api/package/{id}", idPackages))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched package"))
        .andExpect(jsonPath("$.data.id").value(idPackages.toString()));
  }

  @Test
  void testFetchAllPackageEntities() throws Exception {
    when(service.fetchAllPackage()).thenReturn(List.of(lookupPackage));

    mockMvc
        .perform(get("/api/package/entities"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all package entities"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(idPackage.toString()));
  }

  @Test
  void testFetchPackageEntityById() throws Exception {
    when(service.fetchPackageById(idPackage)).thenReturn(lookupPackage);

    mockMvc
        .perform(get("/api/package/entity/{id}", idPackage))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched package entity"))
        .andExpect(jsonPath("$.data.id").value(idPackage.toString()));
  }
}
