package in.gov.kfon.dmdm.service;

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
import org.modelmapper.ModelMapper;

class CorporateOnboardingServiceImplTest {

  private ModelMapper modelMapper;
  private CorporateEnquiryRepository enquiryRepository;
  private CorpLocationListRepository locationListRepository;
  private CeConnectionBreakupRepository connectionBreakupRepository;
  private CeConnectionBreakupMovementRepository movementRepository;
  private CeConnectionBreakupRevisionRepository breakupRevisionRepository;

  private CorporateOnboardingServiceImpl service;

  @BeforeEach
  void setUp() {
    modelMapper = spy(new ModelMapper());
    enquiryRepository = mock(CorporateEnquiryRepository.class);
    locationListRepository = mock(CorpLocationListRepository.class);
    connectionBreakupRepository = mock(CeConnectionBreakupRepository.class);
    movementRepository = mock(CeConnectionBreakupMovementRepository.class);
    breakupRevisionRepository = mock(CeConnectionBreakupRevisionRepository.class);

    service =
        new CorporateOnboardingServiceImpl(
            modelMapper,
            enquiryRepository,
            locationListRepository,
            connectionBreakupRepository,
            movementRepository,
            breakupRevisionRepository);

    service.setupMapper();
  }

  @Test
  void testFetchAll_ShouldReturnMappedList() {
    UUID id = UUID.randomUUID();
    CorporateEnquiry enquiry = new CorporateEnquiry();
    enquiry.setEnquiriesId(id);
    enquiry.setEmailId("test@example.com");

    when(enquiryRepository.findAll()).thenReturn(List.of(enquiry));

    List<CommonLookUp> result = service.fetchAll();

    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());
    verify(enquiryRepository, times(1)).findAll();
  }

  @Test
  void testFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CorporateEnquiry enquiry = new CorporateEnquiry();
    enquiry.setEnquiriesId(id);
    enquiry.setEmailId("test@example.com");

    when(enquiryRepository.findByEnquiriesId(id)).thenReturn(Optional.of(enquiry));

    CommonLookUp result = service.fetchById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(enquiryRepository, times(1)).findByEnquiriesId(id);
  }

  @Test
  void testFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(enquiryRepository.findByEnquiriesId(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchById(id));
  }

  @Test
  void testLocationFetchAll_ShouldReturnMappedList() {
    UUID id = UUID.randomUUID();
    CorpLocationList list = new CorpLocationList();
    list.setListId(id);
    list.setName("Location A");

    when(locationListRepository.findAll()).thenReturn(List.of(list));

    List<CommonLookUp> result = service.locationFetchAll();

    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());
    verify(locationListRepository, times(1)).findAll();
  }

  @Test
  void testLocationFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CorpLocationList list = new CorpLocationList();
    list.setListId(id);
    list.setName("HQ");

    when(locationListRepository.findByListId(id)).thenReturn(Optional.of(list));

    CommonLookUp result = service.locationFetchById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    verify(locationListRepository, times(1)).findByListId(id);
  }

  @Test
  void testLocationFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(locationListRepository.findByListId(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.locationFetchById(id));
  }

  @Test
  void testConnectionsFetchAll_ShouldReturnMappedList() {
    CeConnectionBreakup breakup = new CeConnectionBreakup();
    breakup.setBreakupId(UUID.randomUUID());
    breakup.setCode("CON001");

    when(connectionBreakupRepository.findAll()).thenReturn(List.of(breakup));

    List<CommonLookUp> result = service.connectionsFetchAll();

    assertEquals(1, result.size());
    verify(connectionBreakupRepository, times(1)).findAll();
  }

  @Test
  void testConnectionFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeConnectionBreakup breakup = new CeConnectionBreakup();
    breakup.setBreakupId(id);

    when(connectionBreakupRepository.findById(id)).thenReturn(Optional.of(breakup));

    CommonLookUp result = service.connectionFetchById(id);

    assertNotNull(result);
    verify(connectionBreakupRepository, times(1)).findById(id);
  }

  @Test
  void testConnectionFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(connectionBreakupRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.connectionFetchById(id));
  }

  @Test
  void testMovementsFetchAll_ShouldReturnMappedList() {
    CeConnectionBreakupMovement movement = new CeConnectionBreakupMovement();
    movement.setMovementId(UUID.randomUUID());
    movement.setCode("MOV001");

    when(movementRepository.findAll()).thenReturn(List.of(movement));

    List<CommonLookUp> result = service.movementsFetchAll();

    assertEquals(1, result.size());
    verify(movementRepository, times(1)).findAll();
  }

  @Test
  void testMovementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeConnectionBreakupMovement movement = new CeConnectionBreakupMovement();
    movement.setMovementId(id);

    when(movementRepository.findById(id)).thenReturn(Optional.of(movement));

    CommonLookUp result = service.movementFetchById(id);

    assertNotNull(result);
    verify(movementRepository, times(1)).findById(id);
  }

  @Test
  void testMovementFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(movementRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.movementFetchById(id));
  }

  @Test
  void testCMovementsFetchAll_ShouldReturnMappedList() {
    CeConnectionBreakupMovementRevision movement = new CeConnectionBreakupMovementRevision();
    movement.setRevisionId(UUID.randomUUID());

    when(breakupRevisionRepository.findAll()).thenReturn(List.of(movement));

    List<CommonLookUp> result = service.cMovementsFetchAll();

    assertEquals(1, result.size());
    verify(breakupRevisionRepository, times(1)).findAll();
  }

  @Test
  void testCMovementFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CeConnectionBreakupMovementRevision movement = new CeConnectionBreakupMovementRevision();
    movement.setRevisionId(id);

    when(breakupRevisionRepository.findById(id)).thenReturn(Optional.of(movement));

    CommonLookUp result = service.cMovementFetchById(id);

    assertNotNull(result);
    verify(breakupRevisionRepository, times(1)).findById(id);
  }

  @Test
  void testCMovementFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(breakupRevisionRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.movementFetchById(id));
  }
}
