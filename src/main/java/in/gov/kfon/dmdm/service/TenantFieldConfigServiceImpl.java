package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.ApplicationFieldConfigResponse;
import in.gov.kfon.dmdm.contract.TenantFieldConfigRequest;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import in.gov.kfon.dmdm.model.TenantFieldConfig;
import in.gov.kfon.dmdm.repository.ClientApplicationRepository;
import in.gov.kfon.dmdm.repository.FormFieldMasterRepository;
import in.gov.kfon.dmdm.repository.TenantFieldConfigRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TenantFieldConfigServiceImpl implements TenantFieldConfigService {

  private final TenantFieldConfigRepository repository;
  private final ClientApplicationRepository applicationRepository;
  private final FormFieldMasterRepository fieldMasterRepository;

  @Override
  @Transactional(readOnly = true)
  public List<ApplicationFieldConfigResponse> fetchByTenantAndApplication(
      String tenantId, UUID applicationId) {
    ClientApplication app =
        applicationRepository
            .findById(applicationId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Application not found with id: " + applicationId));
    return repository.findByTenantIdAndApplication(tenantId, app).stream()
        .map(this::toResponse)
        .toList();
  }

  @Override
  public ApplicationFieldConfigResponse upsert(
      String tenantId, UUID applicationId, TenantFieldConfigRequest request) {
    ClientApplication app =
        applicationRepository
            .findById(applicationId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Application not found with id: " + applicationId));
    FormFieldMaster field =
        fieldMasterRepository
            .findById(request.getFieldId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Field not found with id: " + request.getFieldId()));

    TenantFieldConfig config =
        repository
            .findByTenantIdAndApplicationAndField(tenantId, app, field)
            .orElse(
                TenantFieldConfig.builder()
                    .tenantId(tenantId)
                    .application(app)
                    .field(field)
                    .build());

    config.setIsVisible(request.getIsVisible());
    config.setIsRequired(request.getIsRequired());
    config.setDisplayOrder(request.getDisplayOrder());
    config.setCustomLabel(request.getCustomLabel());
    config.setCustomValidations(request.getCustomValidations());

    return toResponse(repository.save(config));
  }

  @Override
  public List<ApplicationFieldConfigResponse> bulkUpsert(
      String tenantId, UUID applicationId, List<TenantFieldConfigRequest> requests) {
    return requests.stream().map(req -> upsert(tenantId, applicationId, req)).toList();
  }

  private ApplicationFieldConfigResponse toResponse(TenantFieldConfig config) {
    FormFieldMaster field = config.getField();
    return ApplicationFieldConfigResponse.builder()
        .id(config.getId())
        .fieldId(field.getId())
        .fieldKey(field.getFieldKey())
        .fieldLabel(
            config.getCustomLabel() != null ? config.getCustomLabel() : field.getFieldLabel())
        .fieldType(field.getFieldType())
        .fieldCategory(field.getFieldCategory())
        .isRequired(config.getIsRequired())
        .displayOrder(config.getDisplayOrder())
        .customLabel(config.getCustomLabel())
        .customValidations(config.getCustomValidations())
        .build();
  }
}
