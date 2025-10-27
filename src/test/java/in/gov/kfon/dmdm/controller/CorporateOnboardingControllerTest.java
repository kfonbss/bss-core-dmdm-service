package in.gov.kfon.dmdm.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.CorporateOnboardingService;
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
@ContextConfiguration(classes = {CorporateOnboardingController.class})
class CorporateOnboardingControllerTest {

  private MockMvc mockMvc;

  @MockBean private CorporateOnboardingService service;

  @Autowired private CorporateOnboardingController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("CORP001");
    lookup.setName("Tech Innovations Pvt Ltd");
    lookup.setNameInLocal("ടെക് ഇന്നവേഷൻസ് പ്രൈവറ്റ് ലിമിറ്റഡ്");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllCorporateEnquiries() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAll()).thenReturn(list);

    mockMvc
        .perform(get("/api/corporate/enquires/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()))
        .andExpect(jsonPath("$.data[0].code").value("CORP001"))
        .andExpect(jsonPath("$.data[0].name").value("Tech Innovations Pvt Ltd"))
        .andExpect(jsonPath("$.data[0].isActive").value(true));
  }

  @Test
  void testFetchCorporateEnquiryById() throws Exception {
    when(service.fetchById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/corporate/enquiry/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.code").value("CORP001"))
        .andExpect(jsonPath("$.data.name").value("Tech Innovations Pvt Ltd"))
        .andExpect(jsonPath("$.data.nameInLocal").value("ടെക് ഇന്നവേഷൻസ് പ്രൈവറ്റ് ലിമിറ്റഡ്"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }

  @Test
  void testLocationFetchAll() throws Exception {

    CommonLookUp location1 = new CommonLookUp();
    location1.setId(UUID.randomUUID());
    location1.setName("Head Office");

    CommonLookUp location2 = new CommonLookUp();
    location2.setId(UUID.randomUUID());
    location2.setName("Branch Office");

    when(service.locationFetchAll()).thenReturn(List.of(location1, location2));

    mockMvc
        .perform(
            get("/api/corporate/location-lists/fetch-all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data[0].name").value("Head Office"))
        .andExpect(jsonPath("$.data[1].name").value("Branch Office"));
  }

  @Test
  void testLocationFetchById() throws Exception {

    CommonLookUp locationLookup = new CommonLookUp();
    locationLookup.setId(UUID.randomUUID());
    locationLookup.setName("Corporate HQ");

    when(service.locationFetchById(any(UUID.class))).thenReturn(locationLookup);

    mockMvc
        .perform(
            get("/api/corporate/location-list/{id}", locationLookup.getId())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.name").value("Corporate HQ"));
  }
}
