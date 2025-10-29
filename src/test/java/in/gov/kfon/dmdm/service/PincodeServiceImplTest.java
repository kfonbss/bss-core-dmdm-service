package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.PincodeDetails;
import in.gov.kfon.dmdm.model.Pincodes;
import in.gov.kfon.dmdm.repository.PincodeDetailsRepository;
import in.gov.kfon.dmdm.repository.PincodesRepository;
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
    when(pincodeDetailsRepository.findAll()).thenReturn(List.of(pincodeDetails));
    when(modelMapper.map(pincodeDetails, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllPincodeDetails();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(pincodeDetailsRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(pincodeDetails, CommonLookUp.class);
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
}
