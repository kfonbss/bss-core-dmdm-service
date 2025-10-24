package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.TaxService;
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
@ContextConfiguration(classes = {TaxController.class})
class TaxControllerTest {

  private MockMvc mockMvc;

  @MockBean private TaxService service;

  @Autowired private TaxController controller;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  void testFetchAll() throws Exception {
    CommonLookUp tax1 = new CommonLookUp();
    tax1.setId(UUID.randomUUID());
    tax1.setCode("TAX001");
    tax1.setName("Service Tax");
    tax1.setNameInLocal("സർവീസ് ടാക്‌സ്");
    tax1.setIsActive(true);

    CommonLookUp tax2 = new CommonLookUp();
    tax2.setId(UUID.randomUUID());
    tax2.setCode("TAX002");
    tax2.setName("Tax");
    tax2.setNameInLocal("ടാക്‌സ്");
    tax2.setIsActive(true);

    List<CommonLookUp> responseList = List.of(tax1, tax2);

    when(service.fetchAll()).thenReturn(responseList);

    mockMvc
        .perform(get("/api/tax/sample/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(2));
  }

  @Test
  void testFetchById() throws Exception {
    UUID taxId = UUID.randomUUID();

    CommonLookUp tax = new CommonLookUp();
    tax.setId(taxId);
    tax.setCode("TAX001");
    tax.setName("Service Tax");
    tax.setNameInLocal("സർവീസ് ടാക്‌സ്");
    tax.setIsActive(true);

    when(service.fetchById(taxId)).thenReturn(tax);

    mockMvc
        .perform(get("/api/tax/sample/{id}", taxId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(taxId.toString()))
        .andExpect(jsonPath("$.data.code").value("TAX001"))
        .andExpect(jsonPath("$.data.name").value("Service Tax"))
        .andExpect(jsonPath("$.data.nameInLocal").value("സർവീസ് ടാക്‌സ്"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }

  @Test
  void testCollectionFetchAll() throws Exception {
    CommonLookUp tax1 = new CommonLookUp();
    tax1.setId(UUID.randomUUID());
    tax1.setCode("TAXCOL001");
    tax1.setName("Property Tax");
    tax1.setNameInLocal("പ്രോപ്പർട്ടി ടാക്‌സ്");
    tax1.setIsActive(true);

    CommonLookUp tax2 = new CommonLookUp();
    tax2.setId(UUID.randomUUID());
    tax2.setCode("TAXCOL002");
    tax2.setName("Service Tax");
    tax2.setNameInLocal("സർവീസ് ടാക്‌സ്");
    tax2.setIsActive(true);

    List<CommonLookUp> responseList = List.of(tax1, tax2);

    when(service.collectionFetchAll()).thenReturn(responseList);

    mockMvc
        .perform(get("/api/tax/collection/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(2));
  }

  @Test
  void testCollectionFetchById() throws Exception {
    UUID taxId = UUID.randomUUID();

    CommonLookUp tax = new CommonLookUp();
    tax.setId(taxId);
    tax.setCode("TAXCOL001");
    tax.setName("Property Tax");
    tax.setNameInLocal("പ്രോപ്പർട്ടി ടാക്‌സ്");
    tax.setIsActive(true);

    when(service.collectionFetchById(taxId)).thenReturn(tax);

    mockMvc
        .perform(get("/api/tax/collection/{id}", taxId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(taxId.toString()))
        .andExpect(jsonPath("$.data.code").value("TAXCOL001"))
        .andExpect(jsonPath("$.data.name").value("Property Tax"))
        .andExpect(jsonPath("$.data.nameInLocal").value("പ്രോപ്പർട്ടി ടാക്‌സ്"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }
}
