package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.ServiceType;
import in.gov.kfon.dmdm.repository.ServiceTypeRepository;
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

public class ServiceTypeServiceImplTest {

  @Mock private ServiceTypeRepository repository;
  @Mock private ModelMapper mapper;

  @InjectMocks private ServiceTypeServiceImpl service;

  private UUID id;
  private ServiceType entity;
  private CommonLookUp dto;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    id = UUID.randomUUID();

    entity = new ServiceType();
    entity.setId(id);
    entity.setName("Internet");

    dto = new CommonLookUp();
    dto.setId(id);
    dto.setName("Internet");
  }

  @Test
  void fetchAllServiceTypes_Success() {
    when(repository.findAll()).thenReturn(List.of(entity));
    when(mapper.map(entity, CommonLookUp.class)).thenReturn(dto);

    List<CommonLookUp> result = service.fetchAllServiceTypes();

    assertEquals(1, result.size());
    verify(repository, times(1)).findAll();
  }

  @Test
  void fetchServiceTypeById_Success() {
    when(repository.findById(id)).thenReturn(Optional.of(entity));
    when(mapper.map(entity, CommonLookUp.class)).thenReturn(dto);

    CommonLookUp result = service.fetchServiceTypeById(id);

    assertNotNull(result);
    assertEquals(id, result.getId());
  }

  @Test
  void fetchServiceTypeById_NotFound() {
    when(repository.findById(id)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> service.fetchServiceTypeById(id));
  }
}
