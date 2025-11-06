package in.gov.kfon.dmdm.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.repository.*;
import jakarta.persistence.EntityNotFoundException;
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
  @Mock private InvCreditNotesRepository creditNotesRepository;
  @Mock private InvDcCreditNotesRepository dcCreditNotesRepository;
  @Mock private InvDeviceAcknowledgementRepository deviceAcknowledgementRepository;
  @Mock private InvDeviceCatRepository deviceCatRepository;
  @InjectMocks private InventoryServiceImpl inventoryService;

  private InvDeviceMake invDeviceMake;
  private InvDeviceModel invDeviceModel;
  private CommonLookUp lookup;
  private UUID id;
  private InvCreditNotes invCreditNotes;
  private InvDcCreditNotes invDcCreditNotes;
  private InvDeviceAcknowledgement invDeviceAck;
  private InvDeviceCat invDeviceCat;

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
    invCreditNotes = new InvCreditNotes();
    invCreditNotes.setNotesId(id);
    invCreditNotes.setName("Test Credit Note");

    invDcCreditNotes = new InvDcCreditNotes();
    invDcCreditNotes.setNotesId(id);
    invDcCreditNotes.setName("Test DC Credit Note");

    invDeviceAck = new InvDeviceAcknowledgement();
    invDeviceAck.setAckId(id);
    invDeviceAck.setName("Device Ack Test");

    invDeviceCat = new InvDeviceCat();
    invDeviceCat.setCatId(id);
    invDeviceCat.setName("Device Category Test");

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

  @Test
  void testCreditNotesFetchAll() {
    when(creditNotesRepository.findAll()).thenReturn(List.of(invCreditNotes));
    when(modelMapper.map(invCreditNotes, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.creditNotesFetchAll();

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getName()).isEqualTo("Test Name");
  }

  @Test
  void testCreditNotesFetchById() {
    when(creditNotesRepository.findById(id)).thenReturn(Optional.of(invCreditNotes));
    when(modelMapper.map(invCreditNotes, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.creditNotesFetchById(id);

    assertThat(result.getCode()).isEqualTo("T001");
    assertThat(result.getNameInLocal()).isEqualTo("ടെസ്റ്റ് നെയിം");
  }

  @Test
  void testCreditNotesFetchById_NotFound() {
    when(creditNotesRepository.findById(id)).thenReturn(Optional.empty());
    assertThrows(EntityNotFoundException.class, () -> inventoryService.creditNotesFetchById(id));
  }

  @Test
  void testDcCreditNotesFetchAll() {
    when(dcCreditNotesRepository.findAll()).thenReturn(List.of(invDcCreditNotes));
    when(modelMapper.map(invDcCreditNotes, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.dcCreditNotesFetchAll();

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getName()).isEqualTo("Test Name");
  }

  @Test
  void testDcCreditNotesFetchById() {
    when(dcCreditNotesRepository.findById(id)).thenReturn(Optional.of(invDcCreditNotes));
    when(modelMapper.map(invDcCreditNotes, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.dcCreditNotesFetchById(id);

    assertThat(result.getCode()).isEqualTo("T001");
  }

  @Test
  void testDcCreditNotesFetchById_NotFound() {
    when(dcCreditNotesRepository.findById(id)).thenReturn(Optional.empty());
    assertThrows(EntityNotFoundException.class, () -> inventoryService.dcCreditNotesFetchById(id));
  }

  @Test
  void testDeviceAcknowledgementFetchById() {
    when(deviceAcknowledgementRepository.findById(id)).thenReturn(Optional.of(invDeviceAck));
    when(modelMapper.map(invDeviceAck, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.deviceAcknowledgementFetchById(id);

    assertThat(result.getId()).isEqualTo(id);
    assertThat(result.getCode()).isEqualTo("T001");
  }

  @Test
  void testDeviceAcknowledgementFetchById_NotFound() {
    when(deviceAcknowledgementRepository.findById(id)).thenReturn(Optional.empty());
    assertThrows(
        EntityNotFoundException.class, () -> inventoryService.deviceAcknowledgementFetchById(id));
  }

  @Test
  void testDeviceCatFetchAll() {
    when(deviceCatRepository.findAll()).thenReturn(List.of(invDeviceCat));
    when(modelMapper.map(invDeviceCat, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.deviceCatFetchAll();

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getName()).isEqualTo("Test Name");
  }

  @Test
  void testDeviceCatFetchById() {
    when(deviceCatRepository.findById(id)).thenReturn(Optional.of(invDeviceCat));
    when(modelMapper.map(invDeviceCat, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.deviceCatFetchById(id);

    assertThat(result.getCode()).isEqualTo("T001");
    assertThat(result.getNameInLocal()).isEqualTo("ടെസ്റ്റ് നെയിം");
  }

  @Test
  void testDeviceCatFetchById_NotFound() {
    when(deviceCatRepository.findById(id)).thenReturn(Optional.empty());
    assertThrows(EntityNotFoundException.class, () -> inventoryService.deviceCatFetchById(id));
  }

  @Test
  void testDeviceAcknowledgementFetchAll() {

    when(deviceAcknowledgementRepository.findAll()).thenReturn(List.of(invDeviceAck));
    when(modelMapper.map(invDeviceAck, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.deviceAcknowledgementFetchAll();

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getId()).isEqualTo(id);
    assertThat(result.get(0).getName()).isEqualTo("Test Name");
    assertThat(result.get(0).getCode()).isEqualTo("T001");
  }
}
