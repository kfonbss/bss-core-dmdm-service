package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.constant.FormStatus;
import in.gov.kfon.dmdm.constant.FormType;
import in.gov.kfon.dmdm.contract.ResolvedFieldDto;
import in.gov.kfon.dmdm.contract.ResolvedFormResponse;
import in.gov.kfon.dmdm.contract.ResolvedSectionDto;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.FormDefinitionField;
import in.gov.kfon.dmdm.model.FormSection;
import in.gov.kfon.dmdm.model.OnboardingFormDefinition;
import in.gov.kfon.dmdm.repository.ClientApplicationRepository;
import in.gov.kfon.dmdm.repository.FormDefinitionFieldRepository;
import in.gov.kfon.dmdm.repository.FormSectionRepository;
import in.gov.kfon.dmdm.repository.OnboardingFormDefinitionRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FormResolverServiceImpl implements FormResolverService {

  private final OnboardingFormDefinitionRepository definitionRepository;
  private final FormSectionRepository sectionRepository;
  private final FormDefinitionFieldRepository fieldRepository;
  private final ClientApplicationRepository applicationRepository;

  @Override
  public ResolvedFormResponse resolve(String appCode, String tenantId, String formType) {
    ClientApplication application =
        applicationRepository
            .findByAppCodeAndIsActive(appCode.toUpperCase(), true)
            .orElseThrow(() -> new EntityNotFoundException("Application not found: " + appCode));

    FormType type = FormType.valueOf(formType.toUpperCase());

    // Step 1: Get the active app-level baseline (tenant_id IS NULL)
    OnboardingFormDefinition baseDefinition =
        definitionRepository
            .findByApplicationAndTenantIdIsNullAndFormTypeAndStatus(
                application, type, FormStatus.ACTIVE)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "No active form definition found for formType=" + formType
                            + " appCode=" + appCode));

    // Step 2: Build a map of tenant-level overrides keyed by fieldKey
    Map<String, FormDefinitionField> tenantOverrides = new HashMap<>();
    if (tenantId != null) {
      definitionRepository
          .findByApplicationAndTenantIdAndFormTypeAndStatus(
              application, tenantId, type, FormStatus.ACTIVE)
          .ifPresent(
              tenantDef ->
                  fieldRepository
                      .findByFormDefinitionOrderByDisplayOrderAsc(tenantDef)
                      .forEach(
                          f -> {
                            String key =
                                f.getField() != null
                                    ? f.getField().getId().toString()
                                    : f.getFieldKey();
                            tenantOverrides.put(key, f);
                          }));
    }

    // Step 3: Resolve sections and merge fields
    List<FormSection> baseSections =
        sectionRepository.findByFormDefinitionOrderByDisplayOrderAsc(baseDefinition);

    List<ResolvedSectionDto> resolvedSections =
        baseSections.stream()
            .map(
                section -> {
                  List<FormDefinitionField> baseFields =
                      fieldRepository.findBySectionOrderByDisplayOrderAsc(section);

                  List<ResolvedFieldDto> resolvedFields =
                      baseFields.stream()
                          .map(baseField -> mergeField(baseField, tenantOverrides))
                          .filter(ResolvedFieldDto::getIsVisible)
                          .sorted(
                              Comparator.comparing(
                                  ResolvedFieldDto::getDisplayOrder,
                                  Comparator.nullsLast(Integer::compare)))
                          .toList();

                  return ResolvedSectionDto.builder()
                      .sectionKey(section.getSectionKey())
                      .sectionLabel(section.getSectionLabel())
                      .displayOrder(section.getDisplayOrder())
                      .fields(resolvedFields)
                      .build();
                })
            .toList();

    return ResolvedFormResponse.builder()
        .appCode(appCode)
        .tenantId(tenantId)
        .formType(formType)
        .version(baseDefinition.getVersion())
        .sections(resolvedSections)
        .build();
  }

  private ResolvedFieldDto mergeField(
      FormDefinitionField base, Map<String, FormDefinitionField> overrides) {
    String overrideKey =
        base.getField() != null ? base.getField().getId().toString() : base.getFieldKey();
    FormDefinitionField override = overrides.get(overrideKey);

    String fieldKey =
        base.getField() != null ? base.getField().getFieldKey() : base.getFieldKey();
    String fieldType =
        base.getField() != null ? base.getField().getFieldType().name() : null;

    // Label priority: tenant customLabel > base customLabel > master label
    String label =
        override != null && override.getCustomLabel() != null
            ? override.getCustomLabel()
            : base.getCustomLabel() != null
                ? base.getCustomLabel()
                : base.getField() != null
                    ? base.getField().getFieldLabel()
                    : base.getFieldKey();

    // Validations priority: tenant customValidations > base customValidations > master defaults
    String validations =
        override != null && override.getCustomValidations() != null
            ? override.getCustomValidations()
            : base.getCustomValidations() != null
                ? base.getCustomValidations()
                : base.getField() != null
                    ? base.getField().getDefaultValidations()
                    : null;

    return ResolvedFieldDto.builder()
        .fieldKey(fieldKey)
        .label(label)
        .fieldType(fieldType)
        .isRequired(
            override != null && override.getIsRequired() != null
                ? override.getIsRequired()
                : base.getIsRequired())
        .isVisible(
            override != null && override.getIsVisible() != null
                ? override.getIsVisible()
                : base.getIsVisible())
        .isReadonly(
            override != null && override.getIsReadonly() != null
                ? override.getIsReadonly()
                : base.getIsReadonly())
        .displayOrder(
            override != null && override.getDisplayOrder() != null
                ? override.getDisplayOrder()
                : base.getDisplayOrder())
        .placeholder(base.getPlaceholder())
        .defaultValue(base.getDefaultValue())
        .validations(validations)
        .lookupType(base.getLookupType())
        .build();
  }
}
