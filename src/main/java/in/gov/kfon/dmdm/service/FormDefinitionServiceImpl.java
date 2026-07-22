package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.constant.FormStatus;
import in.gov.kfon.dmdm.constant.FormType;
import in.gov.kfon.dmdm.contract.FormDefinitionRequest;
import in.gov.kfon.dmdm.contract.FormDefinitionResponse;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.OnboardingFormDefinition;
import in.gov.kfon.dmdm.repository.ClientApplicationRepository;
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
public class FormDefinitionServiceImpl implements FormDefinitionService {

  private final OnboardingFormDefinitionRepository repository;
  private final ClientApplicationRepository applicationRepository;

  @Override
  public FormDefinitionResponse create(FormDefinitionRequest request) {
    ClientApplication application =
        applicationRepository
            .findById(request.getApplicationId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Application not found: " + request.getApplicationId()));

    FormType formType = FormType.valueOf(request.getFormType().toUpperCase());

    int nextVersion = resolveNextVersion(application, request.getTenantId(), formType);

    OnboardingFormDefinition definition =
        OnboardingFormDefinition.builder()
            .application(application)
            .tenantId(request.getTenantId())
            .formType(formType)
            .name(request.getName())
            .description(request.getDescription())
            .version(nextVersion)
            .status(FormStatus.DRAFT)
            .build();

    return toResponse(repository.save(definition));
  }

  @Override
  @Transactional(readOnly = true)
  public FormDefinitionResponse fetchById(UUID id) {
    return toResponse(
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Form definition not found: " + id)));
  }

  @Override
  @Transactional(readOnly = true)
  public List<FormDefinitionResponse> fetchAll(
      UUID applicationId, String tenantId, String formType) {
    ClientApplication application =
        applicationRepository
            .findById(applicationId)
            .orElseThrow(
                () -> new EntityNotFoundException("Application not found: " + applicationId));

    if (formType != null) {
      return repository
          .findByApplicationAndFormTypeOrderByVersionDesc(
              application, FormType.valueOf(formType.toUpperCase()))
          .stream()
          .map(this::toResponse)
          .toList();
    }
    return repository.findByApplication(application).stream().map(this::toResponse).toList();
  }

  @Override
  public FormDefinitionResponse activate(UUID id) {
    OnboardingFormDefinition definition =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Form definition not found: " + id));
    definition.setStatus(FormStatus.ACTIVE);
    return toResponse(repository.save(definition));
  }

  @Override
  public FormDefinitionResponse deprecate(UUID id) {
    OnboardingFormDefinition definition =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Form definition not found: " + id));
    definition.setStatus(FormStatus.DEPRECATED);
    return toResponse(repository.save(definition));
  }

  private int resolveNextVersion(
      ClientApplication application, String tenantId, FormType formType) {
    List<OnboardingFormDefinition> existing =
        repository.findByApplicationAndFormTypeOrderByVersionDesc(application, formType);
    if (existing.isEmpty()) return 1;
    return existing.get(0).getVersion() + 1;
  }

  private FormDefinitionResponse toResponse(OnboardingFormDefinition d) {
    return FormDefinitionResponse.builder()
        .id(d.getId())
        .applicationId(d.getApplication().getId())
        .appCode(d.getApplication().getAppCode())
        .tenantId(d.getTenantId())
        .formType(d.getFormType().name())
        .name(d.getName())
        .version(d.getVersion())
        .status(d.getStatus().name())
        .description(d.getDescription())
        .build();
  }
}
