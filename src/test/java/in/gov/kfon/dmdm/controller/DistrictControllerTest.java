package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.DistrictService;
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
@ContextConfiguration(classes = {DistrictController.class})
class DistrictControllerTest {

  private MockMvc mockMvc;

  @MockBean private DistrictService service;

  @Autowired private DistrictController controller;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  void testFetchAll() throws Exception {

    CommonLookUp lookup1 = new CommonLookUp();
    lookup1.setId(UUID.randomUUID());
    lookup1.setCode("001");
    lookup1.setName("Thiruvananthapuram");
    lookup1.setNameInLocal("തിരുവനന്തപുരം");
    lookup1.setIsActive(true);

    CommonLookUp lookup2 = new CommonLookUp();
    lookup2.setId(UUID.randomUUID());
    lookup2.setCode("002");
    lookup2.setName("Kollam");
    lookup2.setNameInLocal("കൊല്ലം");
    lookup2.setIsActive(true);

    List<CommonLookUp> responseList = List.of(lookup1, lookup2);

    when(service.fetchAll()).thenReturn(responseList);

    mockMvc
        .perform(get("/api/district/fetch-all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data.length()").value(2));
  }

  @Test
  void testFetchById() throws Exception {
    UUID districtId = UUID.randomUUID();

    CommonLookUp lookup = new CommonLookUp();
    lookup.setId(districtId);
    lookup.setCode("001");
    lookup.setName("Thiruvananthapuram");
    lookup.setNameInLocal("തിരുവനന്തപുരം");
    lookup.setIsActive(true);

    when(service.fetchById(districtId)).thenReturn(lookup);

    // Perform GET request and validate response
    mockMvc
        .perform(get("/api/district/{id}", districtId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Fetched"))
        .andExpect(jsonPath("$.data.id").value(districtId.toString()))
        .andExpect(jsonPath("$.data.name").value("Thiruvananthapuram"))
        .andExpect(jsonPath("$.data.nameInLocal").value("തിരുവനന്തപുരം"))
        .andExpect(jsonPath("$.data.code").value("001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }
}
