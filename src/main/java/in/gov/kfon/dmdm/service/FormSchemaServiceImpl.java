package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.constant.FieldType;
import in.gov.kfon.dmdm.constant.FormStatus;
import in.gov.kfon.dmdm.constant.FormType;
import in.gov.kfon.dmdm.contract.FormFieldDto;
import in.gov.kfon.dmdm.contract.FormSchemaResponse;
import in.gov.kfon.dmdm.contract.FormSectionDto;
import in.gov.kfon.dmdm.model.ApplicationFieldConfig;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.FormDefinitionField;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import in.gov.kfon.dmdm.model.OnboardingFormDefinition;
import in.gov.kfon.dmdm.model.TenantCustomField;
import in.gov.kfon.dmdm.model.TenantFieldConfig;
import in.gov.kfon.dmdm.repository.ApplicationFieldConfigRepository;
import in.gov.kfon.dmdm.repository.ClientApplicationRepository;
import in.gov.kfon.dmdm.repository.FormDefinitionFieldRepository;
import in.gov.kfon.dmdm.repository.OnboardingFormDefinitionRepository;
import in.gov.kfon.dmdm.repository.TenantCustomFieldRepository;
import in.gov.kfon.dmdm.repository.TenantFieldConfigRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FormSchemaServiceImpl implements FormSchemaService {

  private final ClientApplicationRepository applicationRepository;
  private final ApplicationFieldConfigRepository appFieldConfigRepository;
  private final TenantFieldConfigRepository tenantFieldConfigRepository;
  private final TenantCustomFieldRepository tenantCustomFieldRepository;
  private final OnboardingFormDefinitionRepository definitionRepository;
  private final FormDefinitionFieldRepository fieldRepository;

  @Override
  public FormSchemaResponse resolveFormSchema(String appCode, String tenantId, String formTypeStr) {

    ClientApplication app =
        applicationRepository
            .findByAppCodeAndIsActive(appCode.toUpperCase(), true)
            .orElseThrow(
                () -> new EntityNotFoundException("Application not found: " + appCode));

    // Resolve formType — default to PARTNER_ONBOARDING when not provided
    FormType formType;
    try {
      formType = formTypeStr != null && !formTypeStr.isBlank()
          ? FormType.valueOf(formTypeStr.toUpperCase())
          : FormType.PARTNER_ONBOARDING;
    } catch (IllegalArgumentException e) {
      formType = FormType.PARTNER_ONBOARDING;
    }

    // ── Step 1: Try DFG model ─────────────────────────────────────────────────
    // Prefer tenant-level active definition; fall back to app-level active definition.
    Optional<OnboardingFormDefinition> dfgDef = Optional.empty();
    if (tenantId != null && !tenantId.isBlank()) {
      dfgDef = definitionRepository.findByApplicationAndTenantIdAndFormTypeAndStatus(
          app, tenantId, formType, FormStatus.ACTIVE);
    }
    if (dfgDef.isEmpty()) {
      dfgDef = definitionRepository.findByApplicationAndTenantIdIsNullAndFormTypeAndStatus(
          app, formType, FormStatus.ACTIVE);
    }

    if (dfgDef.isPresent()) {
      return buildDfgSchema(appCode, tenantId, dfgDef.get());
    }

    // ── Step 2: Fall back to legacy application_field_config model ────────────
    return buildLegacySchema(appCode, tenantId, app);
  }

  // ── DFG-based schema builder ─────────────────────────────────────────────────

  private FormSchemaResponse buildDfgSchema(
      String appCode, String tenantId, OnboardingFormDefinition definition) {

    List<FormDefinitionField> fields =
        fieldRepository.findByFormDefinitionOrderByDisplayOrderAsc(definition);

    // Group by section, preserving display order
    Map<String, List<FormFieldDto>> sectionMap = new LinkedHashMap<>();
    for (FormDefinitionField f : fields) {
      if (Boolean.FALSE.equals(f.getIsVisible())) continue;

      String sectionLabel = f.getSection() != null
          ? f.getSection().getSectionLabel()
          : "GENERAL";

      FormFieldDto dto = toDfgFieldDto(f);
      if (dto != null) {
        sectionMap.computeIfAbsent(sectionLabel, k -> new ArrayList<>()).add(dto);
      }
    }

    List<FormSectionDto> sections = sectionMap.entrySet().stream()
        .map(e -> FormSectionDto.builder().sectionName(e.getKey()).fields(e.getValue()).build())
        .toList();

    return FormSchemaResponse.builder()
        .appCode(appCode.toUpperCase())
        .tenantId(tenantId)
        .sections(sections)
        .build();
  }

  private FormFieldDto toDfgFieldDto(FormDefinitionField f) {
    FormFieldMaster master = f.getField();

    String fieldKey = master != null ? master.getFieldKey() : f.getFieldKey();
    if (fieldKey == null) return null;

    String fieldLabel = f.getCustomLabel() != null
        ? f.getCustomLabel()
        : (master != null ? master.getFieldLabel() : fieldKey);

    FieldType fieldType = master != null ? master.getFieldType() : f.getFieldType();
    String metadata = master != null ? master.getMetadata() : null;

    return FormFieldDto.builder()
        .fieldKey(fieldKey)
        .fieldLabel(fieldLabel)
        .fieldType(fieldType)
        .fieldCategory(master != null ? master.getFieldCategory() : null)
        .required(Boolean.TRUE.equals(f.getIsRequired()))
        .displayOrder(f.getDisplayOrder())
        .section(f.getSection() != null ? f.getSection().getSectionLabel() : null)
        .validations(f.getCustomValidations())
        .metadata(metadata)
        .source("DFG")
        .build();
  }

  // ── Legacy application_field_config schema builder ────────────────────────────

  private FormSchemaResponse buildLegacySchema(
      String appCode, String tenantId, ClientApplication app) {

    List<ApplicationFieldConfig> appConfigs =
        appFieldConfigRepository.findByApplicationAndIsIncluded(app, true);

    Map<UUID, TenantFieldConfig> tenantOverrideMap = new java.util.HashMap<>();
    if (tenantId != null && !tenantId.isBlank()) {
      tenantFieldConfigRepository
          .findByTenantIdAndApplication(tenantId, app)
          .forEach(tc -> tenantOverrideMap.put(tc.getField().getId(), tc));
    }

    List<FormFieldDto> fields =
        appConfigs.stream()
            .map(appConfig -> buildMergedField(appConfig, tenantOverrideMap))
            .filter(Objects::nonNull)
            .collect(Collectors.toCollection(ArrayList::new));

    if (tenantId != null && !tenantId.isBlank()) {
      tenantCustomFieldRepository
          .findByTenantIdAndApplicationAndIsActive(tenantId, app, true)
          .stream()
          .map(this::buildCustomField)
          .forEach(fields::add);
    }

    Map<String, List<FormFieldDto>> sectionMap =
        fields.stream()
            .sorted(
                Comparator.comparingInt(
                    f -> f.getDisplayOrder() != null ? f.getDisplayOrder() : Integer.MAX_VALUE))
            .collect(
                Collectors.groupingBy(
                    f -> f.getSection() != null ? f.getSection() : "GENERAL",
                    LinkedHashMap::new,
                    Collectors.toList()));

    List<FormSectionDto> sections =
        sectionMap.entrySet().stream()
            .map(e -> FormSectionDto.builder().sectionName(e.getKey()).fields(e.getValue()).build())
            .toList();

    return FormSchemaResponse.builder()
        .appCode(appCode.toUpperCase())
        .tenantId(tenantId)
        .sections(sections)
        .build();
  }

  private FormFieldDto buildMergedField(
      ApplicationFieldConfig appConfig, Map<UUID, TenantFieldConfig> tenantOverrideMap) {

    FormFieldMaster master = appConfig.getField();
    TenantFieldConfig override = tenantOverrideMap.get(master.getId());

    if (override != null && Boolean.FALSE.equals(override.getIsVisible())) {
      return null;
    }

    String resolvedLabel =
        override != null && override.getCustomLabel() != null
            ? override.getCustomLabel()
            : (appConfig.getCustomLabel() != null
                ? appConfig.getCustomLabel()
                : master.getFieldLabel());

    boolean resolvedRequired =
        override != null && override.getIsRequired() != null
            ? override.getIsRequired()
            : Boolean.TRUE.equals(appConfig.getIsRequired());

    Integer resolvedOrder =
        override != null && override.getDisplayOrder() != null
            ? override.getDisplayOrder()
            : appConfig.getDisplayOrder();

    String resolvedValidations =
        override != null && override.getCustomValidations() != null
            ? override.getCustomValidations()
            : (appConfig.getCustomValidations() != null
                ? appConfig.getCustomValidations()
                : master.getDefaultValidations());

    return FormFieldDto.builder()
        .fieldKey(master.getFieldKey())
        .fieldLabel(resolvedLabel)
        .fieldType(master.getFieldType())
        .fieldCategory(master.getFieldCategory())
        .required(resolvedRequired)
        .displayOrder(resolvedOrder)
        .section(appConfig.getSection())
        .validations(resolvedValidations)
        .metadata(master.getMetadata())
        .source("MASTER")
        .build();
  }

  private FormFieldDto buildCustomField(TenantCustomField cf) {
    return FormFieldDto.builder()
        .fieldKey(cf.getFieldKey())
        .fieldLabel(cf.getFieldLabel())
        .fieldType(cf.getFieldType())
        .required(Boolean.TRUE.equals(cf.getIsRequired()))
        .displayOrder(cf.getDisplayOrder())
        .section(cf.getSection())
        .validations(cf.getValidations())
        .metadata(cf.getMetadata())
        .source("TENANT_CUSTOM")
        .build();
  }
}
