package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.PartnerService;
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
@ContextConfiguration(classes = {PartnerController.class})
public class PartnerControllerTest {

  private MockMvc mockMvc;

  @MockBean private PartnerService service;

  @Autowired private PartnerController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("P001");
    lookup.setName("Partner Test");
    lookup.setNameInLocal("പാർട്ണർ ടെസ്റ്റ്");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllPartnerFinance() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllFinanceDetails()).thenReturn(list);

    mockMvc
        .perform(get("/api/partner/finances"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner financial details"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerFinanceById() throws Exception {
    when(service.fetchFinanceDetailsById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/finance/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner finance detail"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerTaxLogs() throws Exception {
    when(service.fetchAllTaxpayerLogs()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/taxpayer-logs"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner taxpayer logs"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerTaxLogById() throws Exception {
    when(service.fetchTaxpayerLogById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/taxpayer-log/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner taxpayer log"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerGroups() throws Exception {
    when(service.fetchAllPartnerGroups()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/groups"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner groups"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerGroupById() throws Exception {
    when(service.fetchPartnerGroupById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/group/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner group by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }

  @Test
  void testFetchAllPartnerGstDetails() throws Exception {
    when(service.fetchAllPartnerGstDetails()).thenReturn(List.of(lookup));

    mockMvc
        .perform(get("/api/partner/gst-details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all partner GST details"))
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPartnerGstDetailById() throws Exception {
    when(service.fetchPartnerGstDetailById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/partner/gst-detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched partner GST detail by id"))
        .andExpect(jsonPath("$.data.id").value(id.toString()));
  }
}
