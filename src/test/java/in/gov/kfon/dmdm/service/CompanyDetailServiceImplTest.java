package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.CompanyDetail;
import in.gov.kfon.dmdm.repository.CompanyDetailRepository;
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

public class CompanyDetailServiceImplTest {

  @Mock private CompanyDetailRepository repository;
  @Mock private ModelMapper modelMapper;

  @InjectMocks private CompanyDetailServiceImpl service;

  private UUID id;
  private CompanyDetail companyDetail;
  private CommonLookUp commonLookUp;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    id = UUID.randomUUID();

    companyDetail = new CompanyDetail();
    companyDetail.setId(id);
    companyDetail.setCode("COMP001");
    companyDetail.setName("ABC Pvt Ltd");
    companyDetail.setNameInLocal("എബിസി പ്രൈവറ്റ് ലിമിറ്റഡ്");
    companyDetail.setIsActive(true);

    commonLookUp = new CommonLookUp();
    commonLookUp.setId(id);
    commonLookUp.setCode("COMP001");
    commonLookUp.setName("ABC Pvt Ltd");
    commonLookUp.setNameInLocal("എബിസി പ്രൈവറ്റ് ലിമിറ്റഡ്");
    commonLookUp.setIsActive(true);
  }

  @Test
  void testFetchAllCompanyDetails() {
    when(repository.findAll()).thenReturn(List.of(companyDetail));
    when(modelMapper.map(companyDetail, CommonLookUp.class)).thenReturn(commonLookUp);

    List<CommonLookUp> result = service.fetchAllCompanyDetails();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(id, result.get(0).getId());

    verify(repository, times(1)).findAll();
    verify(modelMapper, times(1)).map(companyDetail, CommonLookUp.class);
  }

  @Test
  void testFetchCompanyDetailById_Success() {
    when(repository.findById(id)).thenReturn(Optional.of(companyDetail));
    when(modelMapper.map(companyDetail, CommonLookUp.class)).thenReturn(commonLookUp);

    CommonLookUp result = service.fetchCompanyDetailById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
    assertEquals("COMP001", result.getCode());

    verify(repository, times(1)).findById(id);
    verify(modelMapper, times(1)).map(companyDetail, CommonLookUp.class);
  }

  @Test
  void testFetchCompanyDetailById_NotFound() {
    when(repository.findById(id)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchCompanyDetailById(id));

    assertEquals("CompanyDetail not found with id: " + id, exception.getMessage());

    verify(repository, times(1)).findById(id);
    verifyNoInteractions(modelMapper);
  }
}
