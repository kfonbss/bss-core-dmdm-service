package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.FormSection;
import in.gov.kfon.dmdm.model.OnboardingFormDefinition;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormSectionRepository extends JpaRepository<FormSection, UUID> {

  List<FormSection> findByFormDefinitionOrderByDisplayOrderAsc(
      OnboardingFormDefinition formDefinition);

  Optional<FormSection> findByFormDefinitionAndSectionKey(
      OnboardingFormDefinition formDefinition, String sectionKey);

  boolean existsByFormDefinitionAndSectionKey(
      OnboardingFormDefinition formDefinition, String sectionKey);
}
