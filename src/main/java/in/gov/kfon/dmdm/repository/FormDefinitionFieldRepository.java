package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.FormDefinitionField;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import in.gov.kfon.dmdm.model.FormSection;
import in.gov.kfon.dmdm.model.OnboardingFormDefinition;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormDefinitionFieldRepository extends JpaRepository<FormDefinitionField, UUID> {

  List<FormDefinitionField> findByFormDefinitionOrderByDisplayOrderAsc(
      OnboardingFormDefinition formDefinition);

  List<FormDefinitionField> findBySectionOrderByDisplayOrderAsc(FormSection section);

  Optional<FormDefinitionField> findByFormDefinitionAndField(
      OnboardingFormDefinition formDefinition, FormFieldMaster field);

  Optional<FormDefinitionField> findByFormDefinitionAndFieldKey(
      OnboardingFormDefinition formDefinition, String fieldKey);

  boolean existsByFormDefinitionAndField(
      OnboardingFormDefinition formDefinition, FormFieldMaster field);
}
