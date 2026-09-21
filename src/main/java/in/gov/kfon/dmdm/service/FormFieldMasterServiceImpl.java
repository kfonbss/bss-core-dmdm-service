package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.FormFieldMasterRequest;
import in.gov.kfon.dmdm.contract.FormFieldMasterResponse;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import in.gov.kfon.dmdm.repository.FormFieldMasterRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FormFieldMasterServiceImpl implements FormFieldMasterService {

  private final FormFieldMasterRepository repository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<FormFieldMasterResponse> fetchAll() {
    return repository.findByIsActive(true).stream()
        .map(field -> modelMapper.map(field, FormFieldMasterResponse.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public FormFieldMasterResponse fetchById(UUID id) {
    FormFieldMaster field =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + id));
    return modelMapper.map(field, FormFieldMasterResponse.class);
  }

  @Override
  public FormFieldMasterResponse create(FormFieldMasterRequest request) {
    if (repository.existsByFieldKey(request.getFieldKey())) {
      throw new IllegalArgumentException(
          "Field with key '" + request.getFieldKey() + "' already exists");
    }
    FormFieldMaster field =
        FormFieldMaster.builder()
            .fieldKey(request.getFieldKey())
            .fieldLabel(request.getFieldLabel())
            .fieldType(request.getFieldType())
            .fieldCategory(request.getFieldCategory())
            .defaultValidations(request.getDefaultValidations())
            .metadata(request.getMetadata())
            .isSystem(Boolean.FALSE.equals(request.getIsSystem()) ? Boolean.FALSE : request.getIsSystem())
            .isActive(Boolean.TRUE)
            .build();
    return modelMapper.map(repository.save(field), FormFieldMasterResponse.class);
  }

  @Override
  public FormFieldMasterResponse update(UUID id, FormFieldMasterRequest request) {
    FormFieldMaster field =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + id));
    field.setFieldLabel(request.getFieldLabel());
    field.setFieldType(request.getFieldType());
    field.setFieldCategory(request.getFieldCategory());
    field.setDefaultValidations(request.getDefaultValidations());
    field.setMetadata(request.getMetadata());
    if (request.getIsActive() != null) {
      field.setIsActive(request.getIsActive());
    }
    return modelMapper.map(repository.save(field), FormFieldMasterResponse.class);
  }
}
