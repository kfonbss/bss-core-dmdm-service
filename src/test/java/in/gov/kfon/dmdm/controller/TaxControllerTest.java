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
import org.springframework.http.MediaType;
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
        .perform(get("/api/tax/samples/fetch-all"))
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
        .perform(get("/api/tax/collections/fetch-all"))
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

  @Test
  void testTypesFetchAll_Success() throws Exception {
    UUID typeId = UUID.randomUUID();
    CommonLookUp typeLookUp = new CommonLookUp();
    typeLookUp.setId(typeId);
    typeLookUp.setCode("TAX01");
    typeLookUp.setName("Goods and Services Tax");
    typeLookUp.setNameInLocal("സാധന സേവന നികുതി");
    typeLookUp.setIsActive(true);

    when(service.typesFetchAll()).thenReturn(List.of(typeLookUp));

    mockMvc
        .perform(get("/api/tax/types/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].id").value(typeId.toString()))
        .andExpect(jsonPath("$.data[0].code").value("TAX01"))
        .andExpect(jsonPath("$.data[0].name").value("Goods and Services Tax"))
        .andExpect(jsonPath("$.data[0].isActive").value(true));
  }

  @Test
  void testTypeFetchById_Success() throws Exception {
    UUID typeId = UUID.randomUUID();
    CommonLookUp typeLookUp = new CommonLookUp();
    typeLookUp.setId(typeId);
    typeLookUp.setCode("TAX01");
    typeLookUp.setName("Goods and Services Tax");
    typeLookUp.setNameInLocal("സാധന സേവന നികുതി");
    typeLookUp.setIsActive(true);

    when(service.typeFetchById(typeId)).thenReturn(typeLookUp);

    mockMvc
        .perform(get("/api/tax/type/{id}", typeId).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(typeId.toString()))
        .andExpect(jsonPath("$.data.name").value("Goods and Services Tax"))
        .andExpect(jsonPath("$.data.nameInLocal").value("സാധന സേവന നികുതി"));
  }

  @Test
  void testDetailsFetchAll() throws Exception {

    UUID detailId = UUID.randomUUID();
    CommonLookUp lookUp = new CommonLookUp();
    lookUp.setId(detailId);
    lookUp.setCode("TXD001");
    lookUp.setName("Local Cable Operator Tax Detail");
    lookUp.setNameInLocal("ലോക്കൽ കേബിൾ ഓപ്പറേറ്റർ നികുതി വിശദാംശം");
    lookUp.setIsActive(true);

    when(service.detailsFetchAll()).thenReturn(List.of(lookUp));

    mockMvc
        .perform(get("/api/tax/details/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDetailFetchById() throws Exception {

    UUID detailId = UUID.randomUUID();
    CommonLookUp lookUp = new CommonLookUp();
    lookUp.setId(detailId);
    lookUp.setCode("TXD001");
    lookUp.setName("Local Cable Operator Tax Detail");
    lookUp.setNameInLocal("ലോക്കൽ കേബിൾ ഓപ്പറേറ്റർ നികുതി വിശദാംശം");
    lookUp.setIsActive(true);

    when(service.detailFetchById(detailId)).thenReturn(lookUp);

    mockMvc
        .perform(get("/api/tax/detail/{id}", detailId).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testPayersFetchAll() throws Exception {
    UUID payerId = UUID.randomUUID();
    CommonLookUp lookUp = new CommonLookUp();
    lookUp.setId(payerId);
    lookUp.setCode("TP001");
    lookUp.setName("Individual");
    lookUp.setNameInLocal("വ്യക്തി");
    lookUp.setIsActive(true);

    when(service.payersFetchAll()).thenReturn(List.of(lookUp));

    mockMvc
        .perform(get("/api/tax/payer-types/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data[0].id").value(payerId.toString()))
        .andExpect(jsonPath("$.data[0].code").value("TP001"))
        .andExpect(jsonPath("$.data[0].name").value("Individual"))
        .andExpect(jsonPath("$.data[0].nameInLocal").value("വ്യക്തി"));
  }

  @Test
  void testPayerFetchById() throws Exception {
    UUID payerId = UUID.randomUUID();
    CommonLookUp lookUp = new CommonLookUp();
    lookUp.setId(payerId);
    lookUp.setCode("TP002");
    lookUp.setName("Company");
    lookUp.setNameInLocal("കമ്പനി");
    lookUp.setIsActive(true);

    when(service.payerFetchAll(payerId)).thenReturn(lookUp);

    mockMvc
        .perform(get("/api/tax/payer-type/{id}", payerId).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(payerId.toString()))
        .andExpect(jsonPath("$.data.code").value("TP002"))
        .andExpect(jsonPath("$.data.name").value("Company"))
        .andExpect(jsonPath("$.data.nameInLocal").value("കമ്പനി"));
  }

  @Test
  void testTaxDisbursementFetchAll() throws Exception {
    UUID disbursementId = UUID.randomUUID();
    CommonLookUp disbursement = new CommonLookUp();
    disbursement.setId(disbursementId);
    disbursement.setCode("DISB001");
    disbursement.setName("Property Tax Disbursement");
    disbursement.setNameInLocal("പ്രോപ്പർട്ടി ടാക്‌സ് ഡിസ്ബർഷ്മെന്റ്");
    disbursement.setIsActive(true);

    when(service.disbursementFetchAll()).thenReturn(List.of(disbursement));

    mockMvc
        .perform(get("/api/tax/disbursements/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(disbursementId.toString()));
  }

  @Test
  void testTaxDisbursementFetchById() throws Exception {
    UUID disbursementId = UUID.randomUUID();
    CommonLookUp disbursement = new CommonLookUp();
    disbursement.setId(disbursementId);
    disbursement.setCode("DISB001");
    disbursement.setName("Property Tax Disbursement");
    disbursement.setNameInLocal("പ്രോപ്പർട്ടി ടാക്‌സ് ഡിസ്ബർഷ്മെന്റ്");
    disbursement.setIsActive(true);

    when(service.disbursementFetch(disbursementId)).thenReturn(disbursement);

    mockMvc
        .perform(get("/api/tax/disbursement/{id}", disbursementId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(disbursementId.toString()))
        .andExpect(jsonPath("$.data.name").value("Property Tax Disbursement"));
  }

  @Test
  void testDistributionFetchAll() throws Exception {
    UUID distributionId = UUID.randomUUID();
    CommonLookUp distribution = new CommonLookUp();
    distribution.setId(distributionId);
    distribution.setCode("DIST001");
    distribution.setName("Property Tax Distribution");
    distribution.setNameInLocal("പ്രോപ്പർട്ടി ടാക്‌സ് ഡിസ്റ്റ്രിബ്യൂഷൻ");
    distribution.setIsActive(true);

    when(service.distributionFetchAll()).thenReturn(List.of(distribution));

    mockMvc
        .perform(get("/api/tax/distributions/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(distributionId.toString()));
  }

  @Test
  void testDistributionFetchById() throws Exception {
    UUID distributionId = UUID.randomUUID();
    CommonLookUp distribution = new CommonLookUp();
    distribution.setId(distributionId);
    distribution.setCode("DIST001");
    distribution.setName("Property Tax Distribution");
    distribution.setNameInLocal("പ്രോപ്പർട്ടി ടാക്‌സ് ഡിസ്റ്റ്രിബ്യൂഷൻ");
    distribution.setIsActive(true);

    when(service.distributionFetch(distributionId)).thenReturn(distribution);

    mockMvc
        .perform(get("/api/tax/distribution/{id}", distributionId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(distributionId.toString()))
        .andExpect(jsonPath("$.data.name").value("Property Tax Distribution"));
  }
}
