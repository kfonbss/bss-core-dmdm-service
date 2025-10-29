package in.gov.kfon.dmdm.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.service.PopService;
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
@ContextConfiguration(classes = {PopController.class})
class PopControllerTest {

  private MockMvc mockMvc;

  @MockBean private PopService service;

  @Autowired private PopController controller;

  private UUID id;
  private CommonLookUp lookup;
  private UUID dfPopListId;
  private CommonLookUp dfPopLookup;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    id = UUID.randomUUID();
    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setCode("001");
    lookup.setName("POP Sample");
    lookup.setNameInLocal("പോപ് സാമ്പിൾ");
    lookup.setIsActive(true);

    dfPopListId = UUID.randomUUID();
    dfPopLookup = new CommonLookUp();
    dfPopLookup.setId(dfPopListId);
    dfPopLookup.setCode("POP01");
    dfPopLookup.setName("Thiruvananthapuram POP");
    dfPopLookup.setNameInLocal("തിരുവനന്തപുരം POP");
    dfPopLookup.setIsActive(true);
  }

  @Test
  void testFetchAllPopMaster() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllPopMasters()).thenReturn(list);

    mockMvc
        .perform(get("/api/pop/masters"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()))
        .andExpect(jsonPath("$.data[0].name").value("POP Sample"))
        .andExpect(jsonPath("$.data[0].nameInLocal").value("പോപ് സാമ്പിൾ"))
        .andExpect(jsonPath("$.data[0].code").value("001"))
        .andExpect(jsonPath("$.data[0].isActive").value(true));
  }

  @Test
  void testFetchPopMasterById() throws Exception {
    when(service.fetchPopMasterById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/pop/master/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.name").value("POP Sample"))
        .andExpect(jsonPath("$.data.nameInLocal").value("പോപ് സാമ്പിൾ"))
        .andExpect(jsonPath("$.data.code").value("001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }

  @Test
  void testFetchAllPopBackup() throws Exception {
    List<CommonLookUp> list = List.of(lookup);
    when(service.fetchAllPopMasterBackups()).thenReturn(list);

    mockMvc
        .perform(get("/api/pop/master-backups"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(id.toString()))
        .andExpect(jsonPath("$.data[0].name").value("POP Sample"))
        .andExpect(jsonPath("$.data[0].nameInLocal").value("പോപ് സാമ്പിൾ"))
        .andExpect(jsonPath("$.data[0].code").value("001"))
        .andExpect(jsonPath("$.data[0].isActive").value(true));
  }

  @Test
  void testFetchPopBackupById() throws Exception {
    when(service.fetchPopMasterBackupById(id)).thenReturn(lookup);

    mockMvc
        .perform(get("/api/pop/master-backup/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.id").value(id.toString()))
        .andExpect(jsonPath("$.data.name").value("POP Sample"))
        .andExpect(jsonPath("$.data.nameInLocal").value("പോപ് സാമ്പിൾ"))
        .andExpect(jsonPath("$.data.code").value("001"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }

  @Test
  void testFetchAllDfPopList() throws Exception {
    List<CommonLookUp> list = List.of(dfPopLookup);
    when(service.fetchAllDfPopLists()).thenReturn(list);

    mockMvc
        .perform(get("/api/pop/df-pop-lists"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.length()").value(1))
        .andExpect(jsonPath("$.data[0].id").value(dfPopListId.toString()))
        .andExpect(jsonPath("$.data[0].name").value("Thiruvananthapuram POP"))
        .andExpect(jsonPath("$.data[0].nameInLocal").value("തിരുവനന്തപുരം POP"))
        .andExpect(jsonPath("$.data[0].code").value("POP01"))
        .andExpect(jsonPath("$.data[0].isActive").value(true));
  }

  @Test
  void testFetchDfPopListById() throws Exception {
    when(service.fetchDfPopById(dfPopListId)).thenReturn(dfPopLookup);

    mockMvc
        .perform(get("/api/pop/df-pop-list/{id}", dfPopListId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.id").value(dfPopListId.toString()))
        .andExpect(jsonPath("$.data.name").value("Thiruvananthapuram POP"))
        .andExpect(jsonPath("$.data.nameInLocal").value("തിരുവനന്തപുരം POP"))
        .andExpect(jsonPath("$.data.code").value("POP01"))
        .andExpect(jsonPath("$.data.isActive").value(true));
  }
}
