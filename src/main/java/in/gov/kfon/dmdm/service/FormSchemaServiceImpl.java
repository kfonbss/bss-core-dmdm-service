package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.FormFieldDto;
import in.gov.kfon.dmdm.contract.FormSchemaResponse;
import in.gov.kfon.dmdm.contract.FormSectionDto;
import in.gov.kfon.dmdm.model.ApplicationFieldConfig;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import in.gov.kfon.dmdm.model.TenantCustomField;
import in.gov.kfon.dmdm.model.TenantFieldConfig;
import in.gov.kfon.dmdm.repository.ApplicationFieldConfigRepository;
import in.gov.kfon.dmdm.repository.ClientApplicationRepository;
import in.gov.kfon.dmdm.repository.TenantCustomFieldRepository;
import in.gov.kfon.dmdm.repository.TenantFieldConfigRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

  @Override
  public FormSchemaResponse resolveFormSchema(String appCode, String tenantId) {

    // Step 1: Load application
    ClientApplication app =
        applicationRepository
            .findByAppCodeAndIsActive(appCode.toUpperCase(), true)
            .orElseThrow(
                () -> new EntityNotFoundException("Application not found: " + appCode));

    // Step 2: Load all fields included for this application
    List<ApplicationFieldConfig> appConfigs =
        appFieldConfigRepository.findByApplicationAndIsIncluded(app, true);

    // Step 3: Load tenant overrides into a map keyed by field UUID
    Map<UUID, TenantFieldConfig> tenantOverrideMap = new java.util.HashMap<>();
    if (tenantId != null && !tenantId.isBlank()) {
      tenantFieldConfigRepository
          .findByTenantIdAndApplication(tenantId, app)
          .forEach(tc -> tenantOverrideMap.put(tc.getField().getId(), tc));
    }

    // Step 4: Merge application config + tenant overrides into field DTOs
    List<FormFieldDto> fields =
        appConfigs.stream()
            .map(appConfig -> buildMergedField(appConfig, tenantOverrideMap))
            .filter(Objects::nonNull)
            .collect(Collectors.toCollection(ArrayList::new));

    // Step 5: Append tenant custom fields
    if (tenantId != null && !tenantId.isBlank()) {
      tenantCustomFieldRepository
          .findByTenantIdAndApplicationAndIsActive(tenantId, app, true)
          .stream()
          .map(this::buildCustomField)
          .forEach(fields::add);
    }

    // Step 6: Group by section (preserving insertion order) and sort within each section
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

    // Tenant can hide a field explicitly
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
