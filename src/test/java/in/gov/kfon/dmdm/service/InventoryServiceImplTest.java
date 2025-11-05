package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.repository.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

class InventoryServiceImplTest {

  @Mock private InvDeviceMakeRepository invDeviceMakeRepository;
  @Mock private InvDeviceModelRepository invDeviceModelRepository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private InventoryServiceImpl inventoryService;

  private InvDeviceMake invDeviceMake;
  private InvDeviceModel invDeviceModel;
  private CommonLookUp lookup;
  private UUID id;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    id = UUID.randomUUID();

    invDeviceMake = new InvDeviceMake();
    invDeviceMake.setInvDeviceMakeId(id);
    invDeviceMake.setDmName("Test Device Make");
    invDeviceMake.setDmDesc("Sample Description");

    invDeviceModel = new InvDeviceModel();
    invDeviceModel.setInvDeviceModelId(id);
    invDeviceModel.setDmoName("Test Device Model");
    invDeviceModel.setDmoDesc("Sample Model Description");

    lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setName("Test Name");
    lookup.setCode("T001");
    lookup.setNameInLocal("ടെസ്റ്റ് നെയിം");
  }

  @Test
  void testFetchAllDeviceMakes_Success() {
    when(invDeviceMakeRepository.findAll()).thenReturn(List.of(invDeviceMake));
    when(modelMapper.map(invDeviceMake, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllDeviceMakes();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invDeviceMakeRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invDeviceMake, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceMakeById_Success() {
    when(invDeviceMakeRepository.findById(id)).thenReturn(Optional.of(invDeviceMake));
    when(modelMapper.map(invDeviceMake, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchDeviceMakeById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(invDeviceMakeRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invDeviceMake, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceMakeById_NotFound() {
    when(invDeviceMakeRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> inventoryService.fetchDeviceMakeById(id));
    assertEquals("Device Make not found with id: " + id, exception.getMessage());

    verify(invDeviceMakeRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllDeviceModels_Success() {
    when(invDeviceModelRepository.findAll()).thenReturn(List.of(invDeviceModel));
    when(modelMapper.map(invDeviceModel, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllDeviceModels();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invDeviceModelRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invDeviceModel, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceModelById_Success() {
    when(invDeviceModelRepository.findById(id)).thenReturn(Optional.of(invDeviceModel));
    when(modelMapper.map(invDeviceModel, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchDeviceModelById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    assertEquals("Test Name", result.getName());
    verify(invDeviceModelRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invDeviceModel, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceModelById_NotFound() {
    when(invDeviceModelRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> inventoryService.fetchDeviceModelById(id));
    assertEquals("Device Model not found with id: " + id, exception.getMessage());

    verify(invDeviceModelRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }
}
