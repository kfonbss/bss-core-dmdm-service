package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.FormSectionRequest;
import in.gov.kfon.dmdm.contract.FormSectionResponse;
import in.gov.kfon.dmdm.model.FormSection;
import in.gov.kfon.dmdm.model.OnboardingFormDefinition;
import in.gov.kfon.dmdm.repository.FormSectionRepository;
import in.gov.kfon.dmdm.repository.OnboardingFormDefinitionRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FormSectionServiceImpl implements FormSectionService {

  private final FormSectionRepository repository;
  private final OnboardingFormDefinitionRepository definitionRepository;

  @Override
  public FormSectionResponse create(UUID definitionId, FormSectionRequest request) {
    OnboardingFormDefinition definition = resolveDefinition(definitionId);

    FormSection section =
        FormSection.builder()
            .formDefinition(definition)
            .sectionKey(request.getSectionKey())
            .sectionLabel(request.getSectionLabel())
            .displayOrder(request.getDisplayOrder())
            .isVisible(request.getIsVisible() == null ? Boolean.TRUE : request.getIsVisible())
            .build();

    return toResponse(repository.save(section));
  }

  @Override
  public FormSectionResponse update(UUID definitionId, UUID sectionId, FormSectionRequest request) {
    FormSection section =
        repository
            .findById(sectionId)
            .orElseThrow(() -> new EntityNotFoundException("Section not found: " + sectionId));

    section.setSectionLabel(request.getSectionLabel());
    section.setDisplayOrder(request.getDisplayOrder());
    if (request.getIsVisible() != null) {
      section.setIsVisible(request.getIsVisible());
    }
    return toResponse(repository.save(section));
  }

  @Override
  public void delete(UUID definitionId, UUID sectionId) {
    FormSection section =
        repository
            .findById(sectionId)
            .orElseThrow(() -> new EntityNotFoundException("Section not found: " + sectionId));
    repository.delete(section);
  }

  @Override
  @Transactional(readOnly = true)
  public List<FormSectionResponse> fetchByDefinition(UUID definitionId) {
    OnboardingFormDefinition definition = resolveDefinition(definitionId);
    return repository.findByFormDefinitionOrderByDisplayOrderAsc(definition).stream()
        .map(this::toResponse)
        .toList();
  }

  private OnboardingFormDefinition resolveDefinition(UUID definitionId) {
    return definitionRepository
        .findById(definitionId)
        .orElseThrow(
            () -> new EntityNotFoundException("Form definition not found: " + definitionId));
  }

  private FormSectionResponse toResponse(FormSection s) {
    return FormSectionResponse.builder()
        .id(s.getId())
        .formDefinitionId(s.getFormDefinition().getId())
        .sectionKey(s.getSectionKey())
        .sectionLabel(s.getSectionLabel())
        .displayOrder(s.getDisplayOrder())
        .isVisible(s.getIsVisible())
        .build();
  }
}
