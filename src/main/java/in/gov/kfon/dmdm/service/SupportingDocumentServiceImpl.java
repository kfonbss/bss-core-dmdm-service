package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.DocumentCategoryResponse;
import in.gov.kfon.dmdm.contract.DocumentTypeResponse;
import in.gov.kfon.dmdm.repository.DocumentCategoryMappingRepository;
import in.gov.kfon.dmdm.repository.DocumentCategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SupportingDocumentServiceImpl implements SupportingDocumentService {

  private final DocumentCategoryMappingRepository mappingRepository;
  private final DocumentCategoryRepository categoryRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(
      cacheNames = CacheNames.SUPPORTING_DOCS_BY_CATEGORY,
      key = "#categoryCode",
      unless = "#result == null || #result.isEmpty()")
  public List<DocumentTypeResponse> fetchDocumentsByCategory(String categoryCode) {
    return mappingRepository
        .findByCategory_CategoryCodeAndDocumentType_IsActiveTrue(categoryCode.toUpperCase())
        .stream()
        .map(mapping -> modelMapper.map(mapping.getDocumentType(), DocumentTypeResponse.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_DOCUMENT_CATEGORIES, unless = "#result == null")
  public List<DocumentCategoryResponse> fetchAllCategories() {
    return categoryRepository.findByIsActiveTrue().stream()
        .map(cat -> modelMapper.map(cat, DocumentCategoryResponse.class))
        .toList();
  }
}
