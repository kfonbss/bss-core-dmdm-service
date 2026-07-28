package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.constant.FieldType;
import in.gov.kfon.dmdm.contract.FormDefinitionFieldRequest;
import in.gov.kfon.dmdm.contract.FormDefinitionFieldResponse;
import in.gov.kfon.dmdm.model.FormDefinitionField;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import in.gov.kfon.dmdm.model.FormSection;
import in.gov.kfon.dmdm.model.OnboardingFormDefinition;
import in.gov.kfon.dmdm.repository.FormDefinitionFieldRepository;
import in.gov.kfon.dmdm.repository.FormFieldMasterRepository;
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
public class FormDefinitionFieldServiceImpl implements FormDefinitionFieldService {

  private final FormDefinitionFieldRepository repository;
  private final OnboardingFormDefinitionRepository definitionRepository;
  private final FormSectionRepository sectionRepository;
  private final FormFieldMasterRepository fieldMasterRepository;

  @Override
  public FormDefinitionFieldResponse addField(
      UUID definitionId, FormDefinitionFieldRequest request) {
    FormDefinitionField field = buildField(definitionId, request);
    return toResponse(repository.save(field));
  }

  @Override
  public List<FormDefinitionFieldResponse> bulkAddFields(
      UUID definitionId, List<FormDefinitionFieldRequest> requests) {
    return requests.stream()
        .map(req -> toResponse(repository.save(buildField(definitionId, req))))
        .toList();
  }

  @Override
  public FormDefinitionFieldResponse updateField(
      UUID definitionId, UUID fieldId, FormDefinitionFieldRequest request) {
    FormDefinitionField existing =
        repository
            .findById(fieldId)
            .orElseThrow(() -> new EntityNotFoundException("Field not found: " + fieldId));

    if (request.getSectionId() != null) {
      FormSection section =
          sectionRepository
              .findById(request.getSectionId())
              .orElseThrow(
                  () ->
                      new EntityNotFoundException("Section not found: " + request.getSectionId()));
      existing.setSection(section);
    }
    existing.setCustomLabel(request.getCustomLabel());
    existing.setPlaceholder(request.getPlaceholder());
    existing.setDefaultValue(request.getDefaultValue());
    if (request.getIsRequired() != null) existing.setIsRequired(request.getIsRequired());
    if (request.getIsVisible() != null) existing.setIsVisible(request.getIsVisible());
    if (request.getIsReadonly() != null) existing.setIsReadonly(request.getIsReadonly());
    existing.setDisplayOrder(request.getDisplayOrder());
    existing.setCustomValidations(request.getCustomValidations());
    existing.setLookupType(request.getLookupType());
    if (existing.getField() == null && request.getFieldType() != null) {
      existing.setFieldType(FieldType.valueOf(request.getFieldType().toUpperCase()));
    }

    return toResponse(repository.save(existing));
  }

  @Override
  public void removeField(UUID definitionId, UUID fieldId) {
    FormDefinitionField field =
        repository
            .findById(fieldId)
            .orElseThrow(() -> new EntityNotFoundException("Field not found: " + fieldId));
    repository.delete(field);
  }

  @Override
  @Transactional(readOnly = true)
  public List<FormDefinitionFieldResponse> fetchByDefinition(UUID definitionId) {
    OnboardingFormDefinition definition =
        definitionRepository
            .findById(definitionId)
            .orElseThrow(
                () -> new EntityNotFoundException("Form definition not found: " + definitionId));
    return repository.findByFormDefinitionOrderByDisplayOrderAsc(definition).stream()
        .map(this::toResponse)
        .toList();
  }

  private FormDefinitionField buildField(UUID definitionId, FormDefinitionFieldRequest request) {
    OnboardingFormDefinition definition =
        definitionRepository
            .findById(definitionId)
            .orElseThrow(
                () -> new EntityNotFoundException("Form definition not found: " + definitionId));

    FormSection section = null;
    if (request.getSectionId() != null) {
      section =
          sectionRepository
              .findById(request.getSectionId())
              .orElseThrow(
                  () ->
                      new EntityNotFoundException("Section not found: " + request.getSectionId()));
    }

    FormFieldMaster master = null;
    if (request.getFieldId() != null) {
      master =
          fieldMasterRepository
              .findById(request.getFieldId())
              .orElseThrow(
                  () -> new EntityNotFoundException("Field master not found: " + request.getFieldId()));
    }

    FieldType customFieldType = null;
    if (master == null && request.getFieldType() != null) {
      customFieldType = FieldType.valueOf(request.getFieldType().toUpperCase());
    }

    return FormDefinitionField.builder()
        .formDefinition(definition)
        .section(section)
        .field(master)
        .fieldKey(master == null ? request.getFieldKey() : null)
        .fieldType(customFieldType)
        .customLabel(request.getCustomLabel())
        .placeholder(request.getPlaceholder())
        .defaultValue(request.getDefaultValue())
        .isRequired(request.getIsRequired() != null ? request.getIsRequired() : Boolean.FALSE)
        .isVisible(request.getIsVisible() != null ? request.getIsVisible() : Boolean.TRUE)
        .isReadonly(request.getIsReadonly() != null ? request.getIsReadonly() : Boolean.FALSE)
        .displayOrder(request.getDisplayOrder())
        .customValidations(request.getCustomValidations())
        .lookupType(request.getLookupType())
        .build();
  }

  private FormDefinitionFieldResponse toResponse(FormDefinitionField f) {
    return FormDefinitionFieldResponse.builder()
        .id(f.getId())
        .formDefinitionId(f.getFormDefinition().getId())
        .sectionId(f.getSection() != null ? f.getSection().getId() : null)
        .fieldId(f.getField() != null ? f.getField().getId() : null)
        .fieldKey(f.getField() != null ? f.getField().getFieldKey() : f.getFieldKey())
        .fieldLabel(f.getField() != null ? f.getField().getFieldLabel() : null)
        .fieldType(f.getField() != null ? f.getField().getFieldType().name()
            : (f.getFieldType() != null ? f.getFieldType().name() : null))
        .customLabel(f.getCustomLabel())
        .placeholder(f.getPlaceholder())
        .defaultValue(f.getDefaultValue())
        .isRequired(f.getIsRequired())
        .isVisible(f.getIsVisible())
        .isReadonly(f.getIsReadonly())
        .displayOrder(f.getDisplayOrder())
        .customValidations(f.getCustomValidations())
        .lookupType(f.getLookupType())
        .build();
  }
}
