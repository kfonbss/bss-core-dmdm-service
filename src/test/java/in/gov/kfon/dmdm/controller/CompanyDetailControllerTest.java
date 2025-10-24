package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.CompanyDetailService;
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
@ContextConfiguration(classes = {CompanyDetailController.class})
public class CompanyDetailControllerTest {

  private MockMvc mockMvc;

  @MockBean private CompanyDetailService service;

  @Autowired private CompanyDetailController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("COMP001");
    lookup.setName("ABC Pvt Ltd");
    lookup.setNameInLocal("എബിസി പ്രൈവറ്റ് ലിമിറ്റഡ്");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllCompanyDetails() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllCompanyDetails()).thenReturn(list);

    mockMvc
        .perform(get("/api/company-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all company details"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchCompanyDetailById() throws Exception {
    when(service.fetchCompanyDetailById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/company-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched company detail"))
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.name").value("ABC Pvt Ltd"))
        .andExpect(jsonPath("$.data.nameInLocal").value("എബിസി പ്രൈവറ്റ് ലിമിറ്റഡ്"))
        .andExpect(jsonPath("$.data.code").value("COMP001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }
}
