package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.PincodeService;
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
@ContextConfiguration(classes = {PincodeController.class})
class PincodeControllerTest {

  private MockMvc mockMvc;

  @MockBean private PincodeService service;

  @Autowired private PincodeController controller;

  private UUID id;
  private CommonLookUp lookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("P001");
    lookup.setName("Pincode Sample");
    lookup.setNameInLocal("പിന്കോഡ് സാമ്പിൾ");
    lookup.setIsActive(true);
  }

  @Test
  void testFetchAllPincodes() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllPincodes()).thenReturn(list);

    mockMvc
        .perform(get("/api/pincode/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all pincodes"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()));
  }

  @Test
  void testFetchPincodeById() throws Exception {
    when(service.fetchPincodeById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/pincode/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched pincode"))
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.name").value("Pincode Sample"))
        .andExpect(jsonPath("$.data.nameInLocal").value("പിന്കോഡ് സാമ്പിൾ"))
        .andExpect(jsonPath("$.data.code").value("P001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }

  @Test
  void testFetchAllPincodeDetails() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllPincodeDetails()).thenReturn(list);

    mockMvc
        .perform(get("/api/pincode/details/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched all pincode details"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1));
  }

  @Test
  void testFetchPincodeDetailById() throws Exception {
    when(service.fetchPincodeDetailsById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/pincode/detail/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched pincode detail"))
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.name").value("Pincode Sample"))
        .andExpect(jsonPath("$.data.nameInLocal").value("പിന്കോഡ് സാമ്പിൾ"))
        .andExpect(jsonPath("$.data.code").value("P001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }

  @Test
  void testFetchPostOfficeByPincode() throws Exception {
    String pincode = "682001";

    CommonLookUp lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setName("Pincode Sample");
    lookup.setNameInLocal("പിന്കോഡ് സാമ്പിൾ");
    lookup.setCode("P001");
    lookup.setIsActive(true);

    List<CommonLookUp> lookups = List.of(lookup);

    when(service.fetchPostOfficeByPincode(pincode)).thenReturn(lookups);

    mockMvc
        .perform(get("/api/pincode/post-office/{pincode}", pincode))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched post office by pincode"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data").isNotEmpty())
        .andExpect(jsonPath("$.data[0].id").value(id.toString()))
        .andExpect(jsonPath("$.data[0].name").value("Pincode Sample"))
        .andExpect(jsonPath("$.data[0].nameInLocal").value("പിന്കോഡ് സാമ്പിൾ"))
        .andExpect(jsonPath("$.data[0].code").value("P001"))
        .andExpect(jsonPath("$.data[0].isActive").value(true));
  }

  @Test
  void testFetchPostOfficeDetailsByPincode() throws Exception {

    Integer pincode = 695001;
    UUID districtId = UUID.randomUUID();

    CommonLookUp lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("695001");
    lookup.setName("Thiruvananthapuram GPO");
    lookup.setNameInLocal("തിരുവനന്തപുരം ജിപിഒ");
    lookup.setIsActive(true);
    lookup.setDistrict("Thiruvananthapuram");
    lookup.setDistrictId(districtId);

    List<CommonLookUp> list = List.of(lookup);

    when(service.fetchPostOfficeDetailsByPincode(pincode)).thenReturn(list);

    mockMvc
        .perform(get("/api/pincode/post-office-details/{pincode}", pincode))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched post offices by pincode"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()))
        .andExpect(jsonPath("$.data[0].code").value("695001"))
        .andExpect(jsonPath("$.data[0].name").value("Thiruvananthapuram GPO"))
        .andExpect(jsonPath("$.data[0].nameInLocal").value("തിരുവനന്തപുരം ജിപിഒ"))
        .andExpect(jsonPath("$.data[0].district").value("Thiruvananthapuram"))
        .andExpect(jsonPath("$.data[0].districtId").value(districtId.toString()))
        .andExpect(jsonPath("$.data[0].isActive").value(true));
  }
}
