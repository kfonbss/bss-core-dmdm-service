package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.District;
import in.gov.kfon.dmdm.repository.DistrictRepository;
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

class DistrictServiceImplTest {

  @Mock private DistrictRepository repository;

  @Mock private ModelMapper modelMapper;

  @InjectMocks private DistrictServiceImpl service;

  private District district;
  private CommonLookUp commonLookUp;
  private UUID districtId;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    districtId = UUID.randomUUID();

    district = new District();
    district.setDistrictId(districtId);
    district.setCode("001");
    district.setName("Thiruvananthapuram");
    district.setNameInLocal("തിരുവനന്തപുരം");
    district.setIsActive(true);
    district.setShortName("TVM");

    commonLookUp = new CommonLookUp();
    commonLookUp.setId(districtId);
    commonLookUp.setCode("001");
    commonLookUp.setName("Thiruvananthapuram");
    commonLookUp.setNameInLocal("തിരുവനന്തപുരം");
    commonLookUp.setIsActive(true);
  }

  @Test
  void testFetchAll() {
    List<District> districts = List.of(district);

    when(repository.findAll()).thenReturn(districts);
    when(modelMapper.map(district, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(districtId, result.get(0).getId());

    verify(repository, times(1)).findAll();
    verify(modelMapper, times(1)).map(district, CommonLookUp.class);
  }

  @Test
  void testFetchById_Success() {
    when(repository.findById(districtId)).thenReturn(Optional.of(district));
    when(modelMapper.map(district, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchById(districtId);

    assertNotNull(result);
    assertEquals(districtId, result.getId());
    assertEquals("Thiruvananthapuram", result.getName());
    assertEquals("തിരുവനന്തപുരം", result.getNameInLocal());

    verify(repository, times(1)).findById(districtId);
    verify(modelMapper, times(1)).map(district, CommonLookUp.class);
  }

  @Test
  void testFetchById_NotFound() {
    when(repository.findById(districtId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchById(districtId));

    assertEquals("district not found with id: " + districtId, exception.getMessage());

    verify(repository, times(1)).findById(districtId);
    verifyNoInteractions(modelMapper);
  }
}
