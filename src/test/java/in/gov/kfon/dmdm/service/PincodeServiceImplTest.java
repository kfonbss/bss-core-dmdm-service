package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.District;
import in.gov.kfon.dmdm.model.PincodeDetails;
import in.gov.kfon.dmdm.model.Pincodes;
import in.gov.kfon.dmdm.repository.PincodeDetailsRepository;
import in.gov.kfon.dmdm.repository.PincodesRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

public class PincodeServiceImplTest {

  @Mock private PincodesRepository pincodesRepository;
  @Mock private PincodeDetailsRepository pincodeDetailsRepository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private PincodeServiceImpl service;

  private UUID id;
  private Pincodes pincodes;
  private PincodeDetails pincodeDetails;
  private CommonLookUp commonLookUp;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    id = UUID.randomUUID();

    pincodes = new Pincodes();
    pincodes.setId(id);
    pincodes.setName("Pincode Sample");

    pincodeDetails = new PincodeDetails();
    pincodeDetails.setId(id);
    pincodeDetails.setName("Pincode Detail Sample");

    commonLookUp = new CommonLookUp();
    commonLookUp.setId(id);
    commonLookUp.setName("TestName");
  }

  @Test
  void testFetchAllPincodes() {
    when(pincodesRepository.findAll()).thenReturn(List.of(pincodes));
    when(modelMapper.map(pincodes, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllPincodes();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(pincodesRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(pincodes, CommonLookUp.class);
  }

  @Test
  void testFetchPincodeById_Success() {
    when(pincodesRepository.findById(id)).thenReturn(Optional.of(pincodes));
    when(modelMapper.map(pincodes, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchPincodeById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(pincodesRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(pincodes, CommonLookUp.class);
  }

  @Test
  void testFetchPincodeById_NotFound() {
    when(pincodesRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchPincodeById(id));

    assertEquals("Pincode not found with id: " + id, exception.getMessage());

    verify(pincodesRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAllPincodeDetails() {

    UUID id = UUID.randomUUID();

    UUID districtId = UUID.randomUUID();
    District district = District.builder().districtId(districtId).build();

    PincodeDetails pincodeDetails =
        PincodeDetails.builder()
            .id(id)
            .details_id(101L)
            .code("TVM001")
            .postOfficeName("Trivandrum GPO")
            .nameInLocal("തിരുവനന്തപുരം")
            .district("Thiruvananthapuram")
            .districtCode(695001)
            .districtMaster(district)
            .isActive(true)
            .build();

    when(pincodeDetailsRepository.findAll()).thenReturn(List.of(pincodeDetails));

    List<CommonLookUp> result = service.fetchAllPincodeDetails();

    assertNotNull(result);
    assertEquals(1, result.size());

    CommonLookUp response = result.get(0);

    assertEquals(id, response.getId());
    assertEquals("TVM001", response.getCode());
    assertEquals("Trivandrum GPO", response.getName());
    assertEquals("തിരുവനന്തപുരം", response.getNameInLocal());
    assertEquals("Thiruvananthapuram", response.getDistrict());
    assertEquals(695001, response.getDistrictCode());
    assertEquals(districtId, response.getDistrictId());
    assertTrue(response.getIsActive());

    verify(pincodeDetailsRepository, times(1)).findAll();
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchPincodeDetailById_Success() {
    when(pincodeDetailsRepository.findById(id)).thenReturn(Optional.of(pincodeDetails));
    when(modelMapper.map(pincodeDetails, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchPincodeDetailsById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());

    verify(pincodeDetailsRepository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(pincodeDetails, CommonLookUp.class);
  }

  @Test
  void testFetchPincodeDetailById_NotFound() {
    when(pincodeDetailsRepository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchPincodeDetailsById(id));

    assertEquals("PincodeDetails not found with id: " + id, exception.getMessage());

    verify(pincodeDetailsRepository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchPostOfficeByPincode_Success() {
    String pincodeValue = "682001";

    pincodes.setId(id);
    pincodes.setPincode(pincodeValue);
    pincodes.setPostOfficeName("Ernakulam Head Post Office");

    List<Pincodes> pincodesList = List.of(pincodes);

    when(pincodesRepository.findAllByPincodeAndIsActiveTrue(pincodeValue)).thenReturn(pincodesList);

    List<CommonLookUp> result = service.fetchPostOfficeByPincode(pincodeValue);

    assertNotNull(result);
    assertEquals(1, result.size());

    CommonLookUp lookup = result.get(0);
    assertEquals(pincodeValue, lookup.getCode());
    assertEquals("Ernakulam Head Post Office", lookup.getName());

    verify(pincodesRepository, times(1)).findAllByPincodeAndIsActiveTrue(pincodeValue);
  }

  @Test
  void testFetchPostOfficeByPincode_NotFound() {
    String pincodeValue = "999999";

    when(pincodesRepository.findAllByPincodeAndIsActiveTrue(pincodeValue))
        .thenReturn(Collections.emptyList());

    EntityNotFoundException exception =
        assertThrows(
            EntityNotFoundException.class, () -> service.fetchPostOfficeByPincode(pincodeValue));

    assertEquals("Post office not found for pincode: " + pincodeValue, exception.getMessage());

    verify(pincodesRepository, times(1)).findAllByPincodeAndIsActiveTrue(pincodeValue);
  }

  @Test
  void testFetchPostOfficeDetailsByPincode_Success() {

    Integer pincodeValue = 695001;

    UUID districtId = UUID.randomUUID();
    District district = new District();
    district.setDistrictId(districtId);
    district.setName("Thiruvananthapuram");

    PincodeDetails details = new PincodeDetails();
    details.setId(id);
    details.setPincode(pincodeValue);
    details.setPostOfficeName("Thiruvananthapuram GPO");
    details.setNameInLocal("തിരുവനന്തപുരം ജിപിഒ");
    details.setIsActive(true);
    details.setDistrictCode(1);
    details.setDistrict("Thiruvananthapuram");
    details.setDistrictMaster(district);

    when(pincodeDetailsRepository.findAllByPincodeAndIsActiveTrue(pincodeValue))
        .thenReturn(List.of(details));

    List<CommonLookUp> result = service.fetchPostOfficeDetailsByPincode(pincodeValue);

    assertNotNull(result);
    assertEquals(1, result.size());

    CommonLookUp lookup = result.get(0);

    assertEquals(id, lookup.getId());
    assertEquals("695001", lookup.getCode());
    assertEquals("Thiruvananthapuram GPO", lookup.getName());
    assertEquals("തിരുവനന്തപുരം ജിപിഒ", lookup.getNameInLocal());
    assertTrue(lookup.getIsActive());
    assertEquals("Thiruvananthapuram", lookup.getDistrict());
    assertEquals(districtId, lookup.getDistrictId());
    assertEquals(1, lookup.getDistrictCode());

    verify(pincodeDetailsRepository, times(1)).findAllByPincodeAndIsActiveTrue(pincodeValue);
  }

  @Test
  void testFetchPostOfficeDetailsByPincode_NotFound() {

    Integer pincodeValue = 999999;

    when(pincodeDetailsRepository.findAllByPincodeAndIsActiveTrue(pincodeValue))
        .thenReturn(Collections.emptyList());

    EntityNotFoundException exception =
        assertThrows(
            EntityNotFoundException.class,
            () -> service.fetchPostOfficeDetailsByPincode(pincodeValue));

    assertEquals("No post offices found for pincode: " + pincodeValue, exception.getMessage());

    verify(pincodeDetailsRepository, times(1)).findAllByPincodeAndIsActiveTrue(pincodeValue);
  }
}
