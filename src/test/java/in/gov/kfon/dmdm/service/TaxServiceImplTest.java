package in.gov.kfon.dmdm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.SampleTax;
import in.gov.kfon.dmdm.model.TaxCollection;
import in.gov.kfon.dmdm.model.TaxType;
import in.gov.kfon.dmdm.repository.SampleTaxRepository;
import in.gov.kfon.dmdm.repository.TaxCollectionRepository;
import in.gov.kfon.dmdm.repository.TaxTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

class TaxServiceImplTest {

  @Mock private SampleTaxRepository repository;

  @Mock private TaxCollectionRepository collectionRepository;
  @Mock private TaxTypeRepository taxTypeRepository;

  @Mock private ModelMapper modelMapper;

  @InjectMocks private TaxServiceImpl service;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFetchById_SampleTax_Success() {
    UUID sampleTaxId = UUID.randomUUID();
    SampleTax sampleTax = new SampleTax();
    sampleTax.setTaxId(sampleTaxId);
    sampleTax.setCode("TAX001");
    sampleTax.setName("Service Tax");
    sampleTax.setNameInLocal("സർവീസ് ടാക്‌സ്");
    sampleTax.setIsActive(true);
    sampleTax.setAmount(BigDecimal.valueOf(18.00));

    CommonLookUp sampleLookUp = new CommonLookUp();
    sampleLookUp.setId(sampleTaxId);
    sampleLookUp.setCode("TAX001");
    sampleLookUp.setName("Service Tax");
    sampleLookUp.setNameInLocal("സർവീസ് ടാക്‌സ്");
    sampleLookUp.setIsActive(true);

    when(repository.findById(sampleTaxId)).thenReturn(Optional.of(sampleTax));
    when(modelMapper.map(sampleTax, CommonLookUp.class)).thenReturn(sampleLookUp);

    CommonLookUp result = service.fetchById(sampleTaxId);

    assertNotNull(result);
    assertEquals(sampleTaxId, result.getId());
    assertEquals("Service Tax", result.getName());

    verify(repository, times(1)).findById(sampleTaxId);
    verify(modelMapper, times(1)).map(sampleTax, CommonLookUp.class);
  }

  @Test
  void testFetchById_SampleTax_NotFound() {
    UUID sampleTaxId = UUID.randomUUID();
    when(repository.findById(sampleTaxId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.fetchById(sampleTaxId));

    assertEquals("Sample Tax not found with id: " + sampleTaxId, exception.getMessage());
    verify(repository, times(1)).findById(sampleTaxId);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testCollectionFetchAll() {
    UUID collectionTaxId = UUID.randomUUID();

    TaxCollection taxCollection = mock(TaxCollection.class);
    when(taxCollection.getId()).thenReturn(collectionTaxId);
    when(taxCollection.getCode()).thenReturn("TAXCOL001");
    when(taxCollection.getName()).thenReturn("Property Tax");
    when(taxCollection.getNameInLocal()).thenReturn("പ്രോപ്പർട്ടി ടാക്‌സ്");
    when(taxCollection.getIsActive()).thenReturn(true);
    when(taxCollection.getTaxAmount()).thenReturn(BigDecimal.valueOf(2500.75));

    CommonLookUp collectionLookUp = new CommonLookUp();
    collectionLookUp.setId(collectionTaxId);
    collectionLookUp.setCode("TAXCOL001");
    collectionLookUp.setName("Property Tax");
    collectionLookUp.setNameInLocal("പ്രോപ്പർട്ടി ടാക്‌സ്");
    collectionLookUp.setIsActive(true);

    when(collectionRepository.findAll()).thenReturn(List.of(taxCollection));
    when(modelMapper.map(taxCollection, CommonLookUp.class)).thenReturn(collectionLookUp);

    List<CommonLookUp> result = service.collectionFetchAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(collectionTaxId, result.get(0).getId());

    verify(collectionRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(taxCollection, CommonLookUp.class);
  }

  @Test
  void testCollectionFetchById_Success() {
    UUID collectionTaxId = UUID.randomUUID();

    TaxCollection taxCollection = mock(TaxCollection.class);
    when(taxCollection.getId()).thenReturn(collectionTaxId);
    when(taxCollection.getCode()).thenReturn("TAXCOL001");
    when(taxCollection.getName()).thenReturn("Property Tax");
    when(taxCollection.getNameInLocal()).thenReturn("പ്രോപ്പർട്ടി ടാക്‌സ്");
    when(taxCollection.getIsActive()).thenReturn(true);
    when(taxCollection.getTaxAmount()).thenReturn(BigDecimal.valueOf(2500.75));

    CommonLookUp collectionLookUp = new CommonLookUp();
    collectionLookUp.setId(collectionTaxId);
    collectionLookUp.setCode("TAXCOL001");
    collectionLookUp.setName("Property Tax");
    collectionLookUp.setNameInLocal("പ്രോപ്പർട്ടി ടാക്‌സ്");
    collectionLookUp.setIsActive(true);

    when(collectionRepository.findById(collectionTaxId)).thenReturn(Optional.of(taxCollection));
    when(modelMapper.map(taxCollection, CommonLookUp.class)).thenReturn(collectionLookUp);

    CommonLookUp result = service.collectionFetchById(collectionTaxId);

    assertNotNull(result);
    assertEquals(collectionTaxId, result.getId());
    assertEquals("Property Tax", result.getName());

    verify(collectionRepository, times(1)).findById(collectionTaxId);
    verify(modelMapper, times(1)).map(taxCollection, CommonLookUp.class);
  }

  @Test
  void testCollectionFetchById_NotFound() {
    UUID collectionTaxId = UUID.randomUUID();
    when(collectionRepository.findById(collectionTaxId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(
            EntityNotFoundException.class, () -> service.collectionFetchById(collectionTaxId));

    assertEquals("Tax not found with id: " + collectionTaxId, exception.getMessage());
    verify(collectionRepository, times(1)).findById(collectionTaxId);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testTypesFetchAll_Success() {
    UUID typeId = UUID.randomUUID();

    TaxType taxType = new TaxType();
    taxType.setId(typeId);
    taxType.setCode("TAX01");
    taxType.setName("Goods and Services Tax");
    taxType.setNameInLocal("സാധന സേവന നികുതി");
    taxType.setIsActive(true);
    taxType.setTaxValuePercent(BigDecimal.valueOf(18.00));

    CommonLookUp lookUp = new CommonLookUp();
    lookUp.setId(typeId);
    lookUp.setCode("TAX01");
    lookUp.setName("Goods and Services Tax");
    lookUp.setNameInLocal("സാധന സേവന നികുതി");
    lookUp.setIsActive(true);

    when(taxTypeRepository.findAll()).thenReturn(List.of(taxType));
    when(modelMapper.map(taxType, CommonLookUp.class)).thenReturn(lookUp);

    List<CommonLookUp> result = service.typesFetchAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(typeId, result.get(0).getId());
    assertEquals("Goods and Services Tax", result.get(0).getName());

    verify(taxTypeRepository, times(1)).findAll();
    verify(modelMapper, times(1)).map(taxType, CommonLookUp.class);
  }

  @Test
  void testTypeFetchById_Success() {
    UUID typeId = UUID.randomUUID();

    TaxType taxType = new TaxType();
    taxType.setId(typeId);
    taxType.setCode("TAX01");
    taxType.setName("Goods and Services Tax");
    taxType.setNameInLocal("സാധന സേവന നികുതി");
    taxType.setIsActive(true);
    taxType.setTaxValuePercent(BigDecimal.valueOf(18.00));

    CommonLookUp lookUp = new CommonLookUp();
    lookUp.setId(typeId);
    lookUp.setCode("TAX01");
    lookUp.setName("Goods and Services Tax");
    lookUp.setNameInLocal("സാധന സേവന നികുതി");
    lookUp.setIsActive(true);

    when(taxTypeRepository.findById(typeId)).thenReturn(Optional.of(taxType));
    when(modelMapper.map(taxType, CommonLookUp.class)).thenReturn(lookUp);

    CommonLookUp result = service.typeFetchById(typeId);

    assertNotNull(result);
    assertEquals(typeId, result.getId());
    assertEquals("Goods and Services Tax", result.getName());
    assertTrue(result.getIsActive());

    verify(taxTypeRepository, times(1)).findById(typeId);
    verify(modelMapper, times(1)).map(taxType, CommonLookUp.class);
  }

  @Test
  void testTypeFetchById_NotFound() {
    UUID typeId = UUID.randomUUID();

    when(taxTypeRepository.findById(typeId)).thenReturn(Optional.empty());

    EntityNotFoundException exception =
        assertThrows(EntityNotFoundException.class, () -> service.typeFetchById(typeId));

    assertEquals("Tax not found with id: " + typeId, exception.getMessage());

    verify(taxTypeRepository, times(1)).findById(typeId);
    verifyNoInteractions(modelMapper);
  }

  @Test
  void testFetchAll_Success() {

    UUID sampleTaxId = UUID.randomUUID();

    SampleTax sampleTax = new SampleTax();
    sampleTax.setTaxId(sampleTaxId);
    sampleTax.setCode("STX001");
    sampleTax.setName("Service Tax");
    sampleTax.setNameInLocal("സർവീസ് നികുതി");
    sampleTax.setIsActive(true);
    sampleTax.setAmount(BigDecimal.valueOf(1000.50));

    CommonLookUp lookUp = new CommonLookUp();
    lookUp.setId(sampleTaxId);
    lookUp.setCode("STX001");
    lookUp.setName("Service Tax");
    lookUp.setNameInLocal("സർവീസ് നികുതി");
    lookUp.setIsActive(true);

    when(repository.findAll()).thenReturn(List.of(sampleTax));
    when(modelMapper.map(sampleTax, CommonLookUp.class)).thenReturn(lookUp);

    List<CommonLookUp> result = service.fetchAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(sampleTaxId, result.get(0).getId());
    assertEquals("Service Tax", result.get(0).getName());
    assertTrue(result.get(0).getIsActive());

    verify(repository, times(1)).findAll();
    verify(modelMapper, times(1)).map(sampleTax, CommonLookUp.class);
  }

  @Test
  void testFetchAll_EmptyList() {

    when(repository.findAll()).thenReturn(List.of());

    List<CommonLookUp> result = service.fetchAll();

    assertNotNull(result);
    assertTrue(result.isEmpty());

    verify(repository, times(1)).findAll();
    verifyNoInteractions(modelMapper);
  }
}
