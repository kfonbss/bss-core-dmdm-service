package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.constant.FormStatus;
import in.gov.kfon.dmdm.constant.FormType;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.OnboardingFormDefinition;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnboardingFormDefinitionRepository
    extends JpaRepository<OnboardingFormDefinition, UUID> {

  // App-level baseline (tenant_id IS NULL)
  Optional<OnboardingFormDefinition>
      findByApplicationAndTenantIdIsNullAndFormTypeAndStatus(
          ClientApplication application, FormType formType, FormStatus status);

  // Tenant-level override
  Optional<OnboardingFormDefinition>
      findByApplicationAndTenantIdAndFormTypeAndStatus(
          ClientApplication application, String tenantId, FormType formType, FormStatus status);

  // All versions for an app + formType
  List<OnboardingFormDefinition> findByApplicationAndFormTypeOrderByVersionDesc(
      ClientApplication application, FormType formType);

  // All definitions for an app
  List<OnboardingFormDefinition> findByApplication(ClientApplication application);

  boolean existsByApplicationAndTenantIdIsNullAndFormTypeAndVersion(
      ClientApplication application, FormType formType, Integer version);

  boolean existsByApplicationAndTenantIdAndFormTypeAndVersion(
      ClientApplication application, String tenantId, FormType formType, Integer version);
}
