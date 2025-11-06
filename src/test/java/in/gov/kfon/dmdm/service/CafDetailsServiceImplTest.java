package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.CafDetails;
import in.gov.kfon.dmdm.repository.*;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class CafDetailsServiceImplTest {
  private ModelMapper modelMapper;
  private CafDetailsRepository detailsRepository;
  private CafDetailsServiceImpl service;

  @BeforeEach
  void setUp() {
    modelMapper = spy(new ModelMapper());
    detailsRepository = mock(CafDetailsRepository.class);

    service = new CafDetailsServiceImpl(modelMapper, detailsRepository);
  }

  @Test
  void testDetailsFetchAll_ShouldReturnMappedList() {
    CafDetails details = new CafDetails();
    details.setDetailsId(UUID.randomUUID());

    when(detailsRepository.findAll()).thenReturn(List.of(details));

    List<CommonLookUp> result = service.detailsFetchAll();

    assertEquals(1, result.size());
    verify(detailsRepository, times(1)).findAll();
  }

  @Test
  void testDetailsFetchById_ShouldReturnMappedObject() {
    UUID id = UUID.randomUUID();
    CafDetails details = new CafDetails();
    details.setDetailsId(id);

    when(detailsRepository.findById(id)).thenReturn(Optional.of(details));

    CommonLookUp result = service.detailsFetchById(id);

    assertNotNull(result);
    verify(detailsRepository, times(1)).findById(id);
  }

  @Test
  void testDetailsFetchById_ShouldThrowException_WhenNotFound() {
    UUID id = UUID.randomUUID();
    when(detailsRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.detailsFetchById(id));
  }
}
