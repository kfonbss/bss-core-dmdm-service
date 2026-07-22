package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.ApplicationFieldConfigRequest;
import in.gov.kfon.dmdm.contract.ApplicationFieldConfigResponse;
import in.gov.kfon.dmdm.model.ApplicationFieldConfig;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import in.gov.kfon.dmdm.repository.ApplicationFieldConfigRepository;
import in.gov.kfon.dmdm.repository.ClientApplicationRepository;
import in.gov.kfon.dmdm.repository.FormFieldMasterRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationFieldConfigServiceImpl implements ApplicationFieldConfigService {

  private final ApplicationFieldConfigRepository repository;
  private final ClientApplicationRepository applicationRepository;
  private final FormFieldMasterRepository fieldMasterRepository;

  @Override
  @Transactional(readOnly = true)
  public List<ApplicationFieldConfigResponse> fetchByApplication(UUID applicationId) {
    ClientApplication app =
        applicationRepository
            .findById(applicationId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Application not found with id: " + applicationId));
    return repository.findByApplication(app).stream().map(this::toResponse).toList();
  }

  @Override
  public ApplicationFieldConfigResponse upsert(
      UUID applicationId, ApplicationFieldConfigRequest request) {
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

    ApplicationFieldConfig config =
        repository
            .findByApplicationAndField(app, field)
            .orElse(
                ApplicationFieldConfig.builder().application(app).field(field).build());

    config.setIsIncluded(request.getIsIncluded());
    config.setIsRequired(request.getIsRequired());
    config.setDisplayOrder(request.getDisplayOrder());
    config.setSection(request.getSection());
    config.setCustomLabel(request.getCustomLabel());
    config.setCustomValidations(request.getCustomValidations());

    return toResponse(repository.save(config));
  }

  @Override
  public List<ApplicationFieldConfigResponse> bulkUpsert(
      UUID applicationId, List<ApplicationFieldConfigRequest> requests) {
    return requests.stream().map(req -> upsert(applicationId, req)).toList();
  }

  private ApplicationFieldConfigResponse toResponse(ApplicationFieldConfig config) {
    FormFieldMaster field = config.getField();
    return ApplicationFieldConfigResponse.builder()
        .id(config.getId())
        .fieldId(field.getId())
        .fieldKey(field.getFieldKey())
        .fieldLabel(field.getFieldLabel())
        .fieldType(field.getFieldType())
        .fieldCategory(field.getFieldCategory())
        .isIncluded(config.getIsIncluded())
        .isRequired(config.getIsRequired())
        .displayOrder(config.getDisplayOrder())
        .section(config.getSection())
        .customLabel(config.getCustomLabel())
        .customValidations(config.getCustomValidations())
        .build();
  }
}
