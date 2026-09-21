package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.FormFieldMasterResponse;
import in.gov.kfon.dmdm.contract.TenantCustomFieldRequest;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.TenantCustomField;
import in.gov.kfon.dmdm.repository.ClientApplicationRepository;
import in.gov.kfon.dmdm.repository.TenantCustomFieldRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TenantCustomFieldServiceImpl implements TenantCustomFieldService {

  private final TenantCustomFieldRepository repository;
  private final ClientApplicationRepository applicationRepository;

  @Override
  @Transactional(readOnly = true)
  public List<FormFieldMasterResponse> fetchByTenantAndApplication(
      String tenantId, UUID applicationId) {
    ClientApplication app =
        applicationRepository
            .findById(applicationId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Application not found with id: " + applicationId));
    return repository.findByTenantIdAndApplicationAndIsActive(tenantId, app, true).stream()
        .map(this::toResponse)
        .toList();
  }

  @Override
  public FormFieldMasterResponse create(
      String tenantId, UUID applicationId, TenantCustomFieldRequest request) {
    ClientApplication app =
        applicationRepository
            .findById(applicationId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Application not found with id: " + applicationId));
    TenantCustomField customField =
        TenantCustomField.builder()
            .tenantId(tenantId)
            .application(app)
            .fieldKey(request.getFieldKey())
            .fieldLabel(request.getFieldLabel())
            .fieldType(request.getFieldType())
            .section(request.getSection())
            .isRequired(request.getIsRequired())
            .displayOrder(request.getDisplayOrder())
            .validations(request.getValidations())
            .metadata(request.getMetadata())
            .isActive(Boolean.TRUE)
            .build();
    return toResponse(repository.save(customField));
  }

  @Override
  public FormFieldMasterResponse update(UUID id, TenantCustomFieldRequest request) {
    TenantCustomField customField =
        repository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Custom field not found with id: " + id));
    customField.setFieldLabel(request.getFieldLabel());
    customField.setFieldType(request.getFieldType());
    customField.setSection(request.getSection());
    customField.setIsRequired(request.getIsRequired());
    customField.setDisplayOrder(request.getDisplayOrder());
    customField.setValidations(request.getValidations());
    customField.setMetadata(request.getMetadata());
    if (request.getIsActive() != null) {
      customField.setIsActive(request.getIsActive());
    }
    return toResponse(repository.save(customField));
  }

  private FormFieldMasterResponse toResponse(TenantCustomField cf) {
    return FormFieldMasterResponse.builder()
        .id(cf.getId())
        .fieldKey(cf.getFieldKey())
        .fieldLabel(cf.getFieldLabel())
        .fieldType(cf.getFieldType())
        .metadata(cf.getMetadata())
        .isActive(cf.getIsActive())
        .build();
  }
}
