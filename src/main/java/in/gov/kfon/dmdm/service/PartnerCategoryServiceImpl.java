package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.PartnerCategoryRequest;
import in.gov.kfon.dmdm.contract.PartnerCategoryResponse;
import in.gov.kfon.dmdm.model.PartnerCategory;
import in.gov.kfon.dmdm.repository.PartnerCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerCategoryServiceImpl implements PartnerCategoryService {

  private static final List<String> YES_NO_OPTIONS = List.of("Yes", "No");

  private final PartnerCategoryRepository partnerCategoryRepository;
  private final ModelMapper modelMapper;

  private PartnerCategoryResponse toResponse(PartnerCategory entity) {
    PartnerCategoryResponse response = modelMapper.map(entity, PartnerCategoryResponse.class);
    response.setOptions(YES_NO_OPTIONS);
    return response;
  }

  @Override
  public List<PartnerCategoryResponse> fetchAll() {
    return partnerCategoryRepository.findAll().stream().map(this::toResponse).toList();
  }

  @Override
  public PartnerCategoryResponse fetchById(UUID id) {
    var entity =
        partnerCategoryRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PartnerCategory not found: " + id));
    return toResponse(entity);
  }

  @Override
  public PartnerCategoryResponse create(PartnerCategoryRequest request) {
    PartnerCategory partnerCategory = modelMapper.map(request, PartnerCategory.class);
    partnerCategory.setId(null);
    PartnerCategory saved = partnerCategoryRepository.save(partnerCategory);
    return toResponse(saved);
  }

  @Override
  public PartnerCategoryResponse update(UUID id, PartnerCategoryRequest request) {
    PartnerCategory partnerCategory =
        partnerCategoryRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PartnerCategory not found: " + id));
    partnerCategory.setName(request.getName());
    partnerCategory.setDescription(request.getDescription());
    partnerCategory.setIsActive(request.getIsActive());
    PartnerCategory saved = partnerCategoryRepository.save(partnerCategory);
    return toResponse(saved);
  }
}