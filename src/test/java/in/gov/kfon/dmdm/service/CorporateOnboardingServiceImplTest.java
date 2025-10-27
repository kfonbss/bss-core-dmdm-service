package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.CorpLocationList;
import in.gov.kfon.dmdm.model.CorporateEnquiry;
import in.gov.kfon.dmdm.repository.CorpLocationListRepository;
import in.gov.kfon.dmdm.repository.CorporateEnquiryRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@ExtendWith(MockitoExtension.class)
class CorporateOnboardingServiceImplTest {

  @Mock private CorporateEnquiryRepository enquiryRepository;

  @Mock private CorpLocationListRepository locationRepository;

  @Mock private ModelMapper modelMapper;

  @InjectMocks private CorporateOnboardingServiceImpl service;

  @Test
  void testSetupMapper_ShouldAddMappingsWithoutException() {

    when(modelMapper.addMappings(any(PropertyMap.class))).thenReturn(null);

    assertDoesNotThrow(() -> service.setupMapper());

    verify(modelMapper, times(2)).addMappings(any(PropertyMap.class));
  }

  @Test
  void testFetchAll_ShouldReturnListOfCommonLookUp() {
    UUID id = UUID.randomUUID();

    CorporateEnquiry enquiry = new CorporateEnquiry();
    enquiry.setEnquiriesId(id);
    enquiry.setName("Tech Innovations Pvt Ltd");
    enquiry.setCode("CORP001");
    enquiry.setIsActive(true);

    CommonLookUp lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setName("Tech Innovations Pvt Ltd");
    lookup.setCode("CORP001");
    lookup.setIsActive(true);

    when(enquiryRepository.findAll()).thenReturn(List.of(enquiry));
    when(modelMapper.map(enquiry, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = service.fetchAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("CORP001", result.get(0).getCode());
    verify(enquiryRepository).findAll();
    verify(modelMapper).map(enquiry, CommonLookUp.class);
  }

  @Test
  void testFetchById_ShouldReturnCommonLookUp_WhenFound() {
    UUID id = UUID.randomUUID();

    CorporateEnquiry enquiry = new CorporateEnquiry();
    enquiry.setEnquiriesId(id);
    enquiry.setName("GreenTech Solutions");
    enquiry.setCode("GTX001");
    enquiry.setIsActive(true);

    CommonLookUp lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setName("GreenTech Solutions");
    lookup.setCode("GTX001");
    lookup.setIsActive(true);

    when(enquiryRepository.findByEnquiriesId(id)).thenReturn(Optional.of(enquiry));
    when(modelMapper.map(enquiry, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = service.fetchById(id);

    assertNotNull(result);
    assertEquals("GTX001", result.getCode());
    assertEquals("GreenTech Solutions", result.getName());
    verify(enquiryRepository).findByEnquiriesId(id);
  }

  @Test
  void testFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(enquiryRepository.findByEnquiriesId(id)).thenReturn(Optional.empty());

    EntityNotFoundException ex =
        assertThrows(EntityNotFoundException.class, () -> service.fetchById(id));

    assertEquals("Corporate Enquiry not found with id: " + id, ex.getMessage());
    verify(enquiryRepository).findByEnquiriesId(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testLocationFetchAll_ShouldReturnListOfCommonLookUp() {
    UUID id = UUID.randomUUID();

    CorpLocationList location = new CorpLocationList();
    location.setListId(id);
    location.setName("Corporate HQ");
    location.setCode("LOC001");
    location.setIsActive(true);

    CommonLookUp lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setName("Corporate HQ");
    lookup.setCode("LOC001");
    lookup.setIsActive(true);

    when(locationRepository.findAll()).thenReturn(List.of(location));
    when(modelMapper.map(location, CommonLookUp.class)).thenReturn(lookup);

    List<CommonLookUp> result = service.locationFetchAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("LOC001", result.get(0).getCode());
    verify(locationRepository).findAll();
  }

  @Test
  void testLocationFetchById_ShouldReturnCommonLookUp_WhenFound() {
    UUID id = UUID.randomUUID();

    CorpLocationList location = new CorpLocationList();
    location.setListId(id);
    location.setName("Regional Office");
    location.setCode("LOC100");
    location.setIsActive(true);

    CommonLookUp lookup = new CommonLookUp();
    lookup.setId(id);
    lookup.setName("Regional Office");
    lookup.setCode("LOC100");
    lookup.setIsActive(true);

    when(locationRepository.findByListId(id)).thenReturn(Optional.of(location));
    when(modelMapper.map(location, CommonLookUp.class)).thenReturn(lookup);

    CommonLookUp result = service.locationFetchById(id);

    assertNotNull(result);
    assertEquals("Regional Office", result.getName());
    assertEquals("LOC100", result.getCode());
    verify(locationRepository).findByListId(id);
  }

  @Test
  void testLocationFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();

    when(locationRepository.findByListId(id)).thenReturn(Optional.empty());

    EntityNotFoundException ex =
        assertThrows(EntityNotFoundException.class, () -> service.locationFetchById(id));

    assertEquals("Corporate Location List not found with id: " + id, ex.getMessage());
    verify(locationRepository).findByListId(id);
    verifyNoInteractions(modelMapper);
  }
}
