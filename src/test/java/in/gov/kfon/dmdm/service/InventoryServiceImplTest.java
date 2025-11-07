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
  @Mock private InvDeviceReturnTooemRepository invDeviceReturnTooemRepository;
  @Mock private InvDeviceStatusRepository invDeviceStatusRepository;
  @Mock private InvDeviceDetailsRepository deviceDetailsRepository;
  @Mock private InvDeviceDetailsAuditRepository deviceDetailsAuditRepository;
  @Mock private InvDeviceTypeRepository invDeviceTypeRepository;
  @Mock private InvDeviceVendorRepository invDeviceVendorRepository;
  @Mock private InvDtransferRequestRepository invDtransferRequestRepository;
  @Mock private InvDtransferRmovementRepository invDtransferRmovementRepository;
  @Mock private InvPoDetailsRepository invPoDetailsRepository;
  @Mock private InvPoDocumentsRepository invPoDocumentsRepository;
  @Mock private InvLnpDeviceRequestRepository invLnpDeviceRequestRepository;
  @Mock private InvLnpDeviceRequestMovementRepository invLnpDeviceRequestMovementRepository;
  @InjectMocks private InventoryServiceImpl inventoryService;

  private InvDeviceMake invDeviceMake;
  private InvDeviceModel invDeviceModel;
  private CommonLookUp lookup;
  private UUID id;
  private InvCreditNotes invCreditNotes;
  private InvDcCreditNotes invDcCreditNotes;
  private InvDeviceAcknowledgement invDeviceAck;
  private InvDeviceCat invDeviceCat;
  private InvDeviceReturnTooem invDeviceReturnTooem;
  private InvDeviceStatus invDeviceStatus;
  private InvDeviceDetails invDeviceDetails;
  private InvDeviceDetailsAudit invDeviceDetailsAudit;
  private InvDeviceType invDeviceType;
  private InvDeviceVendor invDeviceVendor;
  private InvDtransferRequest invDtransferRequest;
  private InvDtransferRmovement invDtransferRmovement;
  private InvPoDetails poDetailsEntity;
  private InvPoDocuments poDocumentEntity;
  private InvLnpDeviceRequest invLnpDeviceRequest;
  private InvLnpDeviceRequestMovement invLnpDeviceRequestMovement;

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

    invDeviceReturnTooem = new InvDeviceReturnTooem();
    invDeviceReturnTooem.setInvDeviceReturnTooemId(id);
    invDeviceReturnTooem.setCode("RET001");
    invDeviceReturnTooem.setName("Device Return Batch");
    invDeviceReturnTooem.setNameInLocal("ഡിവൈസ് റിട്ടേൺ ബാച്ച്");

    invDeviceStatus = new InvDeviceStatus();
    invDeviceStatus.setInvDeviceStatusId(id);
    invDeviceStatus.setCode("STAT001");
    invDeviceStatus.setName("Working");
    invDeviceStatus.setNameInLocal("പ്രവർത്തനം");

    invDeviceDetails = new InvDeviceDetails();
    invDeviceDetails.setDetailsId(id);
    invDeviceDetails.setName("Device Details Test");

    invDeviceDetailsAudit = new InvDeviceDetailsAudit();
    invDeviceDetailsAudit.setAuditId(id);
    invDeviceDetailsAudit.setName("Device Details Audit Test");
    invDeviceType = new InvDeviceType();
    invDeviceType.setInvDeviceTypeId(id);
    invDeviceType.setDtName("OLT Device");
    invDeviceType.setDtDesc("Optical Line Terminal");

    invDeviceVendor = new InvDeviceVendor();
    invDeviceVendor.setInvDeviceVendorId(id);
    invDeviceVendor.setDveName("Cisco");
    invDeviceVendor.setDveDesc("Network Vendor");

    invDtransferRequest = new InvDtransferRequest();
    invDtransferRequest.setInvDtransferRequestId(id);
    invDtransferRequest.setCode("REQ001");
    invDtransferRequest.setName("Device Transfer Request");
    invDtransferRequest.setNameInLocal("ഡിവൈസ് ട്രാൻസ്ഫർ റിക്വസ്റ്റ്");
    invDtransferRequest.setIsActive(true);

    invDtransferRmovement = new InvDtransferRmovement();
    invDtransferRmovement.setInvDtransferRmovementId(id);
    invDtransferRmovement.setCode("MOV001");
    invDtransferRmovement.setName("Device Transfer Movement");
    invDtransferRmovement.setNameInLocal("ഡിവൈസ് ട്രാൻസ്ഫർ മൂവ്മെന്റ്");
    invDtransferRmovement.setIsActive(true);

    poDetailsEntity = new InvPoDetails();
    poDetailsEntity.setInvPoDetailsId(id);
    poDetailsEntity.setCode("PO001");
    poDetailsEntity.setName("Router Purchase");
    poDetailsEntity.setNameInLocal("റൗട്ടർ വാങ്ങൽ");
    poDetailsEntity.setIsActive(true);

    poDocumentEntity = new InvPoDocuments();
    poDocumentEntity.setInvPoDocumnetsId(id);
    poDocumentEntity.setCode("DOC001");
    poDocumentEntity.setName("Invoice Copy");
    poDocumentEntity.setNameInLocal("ഇൻവോയ്സ് പകർപ്പ്");
    poDocumentEntity.setIsActive(true);

    invLnpDeviceRequest = new InvLnpDeviceRequest();
    invLnpDeviceRequest.setInvLnpDeviceRequestId(id);
    invLnpDeviceRequest.setCode("LNPREQ001");
    invLnpDeviceRequest.setName("LNP Device Request");
    invLnpDeviceRequest.setNameInLocal("എൽ.എൻ.പി ഡിവൈസ് റിക്വസ്റ്റ്");
    invLnpDeviceRequest.setIsActive(true);

    invLnpDeviceRequestMovement = new InvLnpDeviceRequestMovement();
    invLnpDeviceRequestMovement.setInvLnpDeviceRequestMovementId(id);
    invLnpDeviceRequestMovement.setCode("LNPMOV001");
    invLnpDeviceRequestMovement.setName("LNP Device Request Movement");
    invLnpDeviceRequestMovement.setNameInLocal("എൽ.എൻ.പി ഡിവൈസ് മൂവ്മെന്റ്");
    invLnpDeviceRequestMovement.setIsActive(true);

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

  @Test
  void testFetchAllDeviceReturnTooem_Success() {
    when(invDeviceReturnTooemRepository.findAll()).thenReturn(List.of(invDeviceReturnTooem));
    when(modelMapper.map(invDeviceReturnTooem, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllDeviceReturns();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invDeviceReturnTooemRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invDeviceReturnTooem, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceReturnTooemById_Success() {
    when(invDeviceReturnTooemRepository.findById(id)).thenReturn(Optional.of(invDeviceReturnTooem));
    when(modelMapper.map(invDeviceReturnTooem, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchDeviceReturnById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(invDeviceReturnTooemRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invDeviceReturnTooem, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceReturnTooemById_NotFound() {
    when(invDeviceReturnTooemRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> inventoryService.fetchDeviceReturnById(id));
    assertEquals("Device Return not found with id: " + id, exception.getMessage());

    verify(invDeviceReturnTooemRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllDeviceStatus_Success() {
    when(invDeviceStatusRepository.findAll()).thenReturn(List.of(invDeviceStatus));
    when(modelMapper.map(invDeviceStatus, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllDeviceStatuses();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invDeviceStatusRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invDeviceStatus, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceStatusById_Success() {
    when(invDeviceStatusRepository.findById(id)).thenReturn(Optional.of(invDeviceStatus));
    when(modelMapper.map(invDeviceStatus, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchDeviceStatusById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    assertEquals("Test Name", result.getName());
    verify(invDeviceStatusRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invDeviceStatus, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceStatusById_NotFound() {
    when(invDeviceStatusRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> inventoryService.fetchDeviceStatusById(id));
    assertEquals("Device Status not found with id: " + id, exception.getMessage());

    verify(invDeviceStatusRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testDeviceDetailsFetchAll() {
    when(deviceDetailsRepository.findAll()).thenReturn(List.of(invDeviceDetails));
    when(modelMapper.map(invDeviceDetails, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.deviceDetailsFetchAll();

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getName()).isEqualTo("Test Name");
    assertThat(result.get(0).getCode()).isEqualTo("T001");
  }

  @Test
  void testDeviceDetailsFetchById() {
    when(deviceDetailsRepository.findById(id)).thenReturn(Optional.of(invDeviceDetails));
    when(modelMapper.map(invDeviceDetails, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.deviceDetailsFetchById(id);

    assertThat(result.getId()).isEqualTo(id);
    assertThat(result.getNameInLocal()).isEqualTo("ടെസ്റ്റ് നെയിം");
  }

  @Test
  void testDeviceDetailsFetchById_NotFound() {
    when(deviceDetailsRepository.findById(id)).thenReturn(Optional.empty());
    assertThrows(EntityNotFoundException.class, () -> inventoryService.deviceDetailsFetchById(id));
  }

  @Test
  void testDeviceDetailsAuditsFetchAll() {
    when(deviceDetailsAuditRepository.findAll()).thenReturn(List.of(invDeviceDetailsAudit));
    when(modelMapper.map(invDeviceDetailsAudit, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.deviceDetailsAuditsFetchAll();

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getName()).isEqualTo("Test Name");
    assertThat(result.get(0).getCode()).isEqualTo("T001");
  }

  @Test
  void testDeviceDetailsAuditsFetchById() {
    when(deviceDetailsAuditRepository.findById(id)).thenReturn(Optional.of(invDeviceDetailsAudit));
    when(modelMapper.map(invDeviceDetailsAudit, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.deviceDetailsAuditsFetchById(id);

    assertThat(result.getId()).isEqualTo(id);
    assertThat(result.getCode()).isEqualTo("T001");
  }

  @Test
  void testDeviceDetailsAuditsFetchById_NotFound() {
    when(deviceDetailsAuditRepository.findById(id)).thenReturn(Optional.empty());
    assertThrows(
        EntityNotFoundException.class, () -> inventoryService.deviceDetailsAuditsFetchById(id));
  }

  @Test
  void testFetchAllDeviceTypes_Success() {
    when(invDeviceTypeRepository.findAll()).thenReturn(List.of(invDeviceType));
    when(modelMapper.map(invDeviceType, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllDeviceTypes();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invDeviceTypeRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invDeviceType, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceTypeById_Success() {
    when(invDeviceTypeRepository.findById(id)).thenReturn(Optional.of(invDeviceType));
    when(modelMapper.map(invDeviceType, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchDeviceTypeById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(invDeviceTypeRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invDeviceType, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceTypeById_NotFound() {
    when(invDeviceTypeRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> inventoryService.fetchDeviceTypeById(id));
    assertEquals("Device Type not found with id: " + id, exception.getMessage());
    verify(invDeviceTypeRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllDeviceVendors_Success() {
    when(invDeviceVendorRepository.findAll()).thenReturn(List.of(invDeviceVendor));
    when(modelMapper.map(invDeviceVendor, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllDeviceVendors();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invDeviceVendorRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invDeviceVendor, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceVendorById_Success() {
    when(invDeviceVendorRepository.findById(id)).thenReturn(Optional.of(invDeviceVendor));
    when(modelMapper.map(invDeviceVendor, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchDeviceVendorById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(invDeviceVendorRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invDeviceVendor, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceVendorById_NotFound() {
    when(invDeviceVendorRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> inventoryService.fetchDeviceVendorById(id));
    assertEquals("Device Vendor not found with id: " + id, exception.getMessage());
    verify(invDeviceVendorRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllDeviceTransferRequests_Success() {
    when(invDtransferRequestRepository.findAll()).thenReturn(List.of(invDtransferRequest));
    when(modelMapper.map(invDtransferRequest, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllDeviceTransferRequests();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invDtransferRequestRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invDtransferRequest, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceTransferRequestById_Success() {
    when(invDtransferRequestRepository.findById(id)).thenReturn(Optional.of(invDtransferRequest));
    when(modelMapper.map(invDtransferRequest, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchDeviceTransferRequestById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    assertEquals("Test Name", result.getName());
    verify(invDtransferRequestRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invDtransferRequest, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceTransferRequestById_NotFound() {
    when(invDtransferRequestRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(
            EntityNotFoundException.class,
            () -> inventoryService.fetchDeviceTransferRequestById(id));
    assertEquals("Not found with id: " + id, exception.getMessage());

    verify(invDtransferRequestRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllDeviceTransferMovements_Success() {
    when(invDtransferRmovementRepository.findAll()).thenReturn(List.of(invDtransferRmovement));
    when(modelMapper.map(invDtransferRmovement, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllDeviceTransferMovements();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invDtransferRmovementRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invDtransferRmovement, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceTransferMovementById_Success() {
    when(invDtransferRmovementRepository.findById(id))
        .thenReturn(Optional.of(invDtransferRmovement));
    when(modelMapper.map(invDtransferRmovement, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchDeviceTransferMovementById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    assertEquals("Test Name", result.getName());
    verify(invDtransferRmovementRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invDtransferRmovement, CommonLookUp.class);
  }

  @Test
  void testFetchDeviceTransferMovementById_NotFound() {
    when(invDtransferRmovementRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(
            EntityNotFoundException.class,
            () -> inventoryService.fetchDeviceTransferMovementById(id));
    assertEquals("Not found with id: " + id, exception.getMessage());

    verify(invDtransferRmovementRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllPoDetails_Success() {
    when(invPoDetailsRepository.findAll()).thenReturn(List.of(poDetailsEntity));
    when(modelMapper.map(poDetailsEntity, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllPoDetails();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invPoDetailsRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(poDetailsEntity, CommonLookUp.class);
  }

  @Test
  void testFetchPoDetailById_Success() {
    when(invPoDetailsRepository.findById(id)).thenReturn(Optional.of(poDetailsEntity));
    when(modelMapper.map(poDetailsEntity, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchPoDetailsById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(invPoDetailsRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(poDetailsEntity, CommonLookUp.class);
  }

  @Test
  void testFetchPoDetailById_NotFound() {
    when(invPoDetailsRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> inventoryService.fetchPoDetailsById(id));
    assertEquals("Not found with id: " + id, exception.getMessage());

    verify(invPoDetailsRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllPoDocuments_Success() {
    when(invPoDocumentsRepository.findAll()).thenReturn(List.of(poDocumentEntity));
    when(modelMapper.map(poDocumentEntity, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllPoDocuments();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invPoDocumentsRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(poDocumentEntity, CommonLookUp.class);
  }

  @Test
  void testFetchPoDocumentById_Success() {
    when(invPoDocumentsRepository.findById(id)).thenReturn(Optional.of(poDocumentEntity));
    when(modelMapper.map(poDocumentEntity, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchPoDocumentById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(invPoDocumentsRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(poDocumentEntity, CommonLookUp.class);
  }

  @Test
  void testFetchPoDocumentById_NotFound() {
    when(invPoDocumentsRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> inventoryService.fetchPoDocumentById(id));
    assertEquals("Not found with id: " + id, exception.getMessage());

    verify(invPoDocumentsRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllLnpDeviceRequests_Success() {
    when(invLnpDeviceRequestRepository.findAll()).thenReturn(List.of(invLnpDeviceRequest));
    when(modelMapper.map(invLnpDeviceRequest, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllLnpDeviceRequests();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invLnpDeviceRequestRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invLnpDeviceRequest, CommonLookUp.class);
  }

  @Test
  void testFetchLnpDeviceRequestById_Success() {
    when(invLnpDeviceRequestRepository.findById(id)).thenReturn(Optional.of(invLnpDeviceRequest));
    when(modelMapper.map(invLnpDeviceRequest, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchLnpDeviceRequestById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(invLnpDeviceRequestRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invLnpDeviceRequest, CommonLookUp.class);
  }

  @Test
  void testFetchLnpDeviceRequestById_NotFound() {
    when(invLnpDeviceRequestRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(RuntimeException.class, () -> inventoryService.fetchLnpDeviceRequestById(id));
    assertEquals("LNP Device Request not found with id: " + id, exception.getMessage());

    verify(invLnpDeviceRequestRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllLnpDeviceRequestMovements_Success() {
    when(invLnpDeviceRequestMovementRepository.findAll())
        .thenReturn(List.of(invLnpDeviceRequestMovement));
    when(modelMapper.map(invLnpDeviceRequestMovement, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = inventoryService.fetchAllLnpDeviceRequestMovements();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("Test Name", result.get(0).getName());
    verify(invLnpDeviceRequestMovementRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(invLnpDeviceRequestMovement, CommonLookUp.class);
  }

  @Test
  void testFetchLnpDeviceRequestMovementById_Success() {
    when(invLnpDeviceRequestMovementRepository.findById(id))
        .thenReturn(Optional.of(invLnpDeviceRequestMovement));
    when(modelMapper.map(invLnpDeviceRequestMovement, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = inventoryService.fetchLnpDeviceRequestMovementById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(invLnpDeviceRequestMovementRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(invLnpDeviceRequestMovement, CommonLookUp.class);
  }

  @Test
  void testFetchLnpDeviceRequestMovementById_NotFound() {
    when(invLnpDeviceRequestMovementRepository.findById(id)).thenReturn(Optional.empty());

    RuntimeException exception =
        assertThrows(
            RuntimeException.class, () -> inventoryService.fetchLnpDeviceRequestMovementById(id));
    assertEquals("LNP Device Request Movement not found with id: " + id, exception.getMessage());

    verify(invLnpDeviceRequestMovementRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }
}
