package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.ApplicationFieldConfig;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationFieldConfigRepository
    extends JpaRepository<ApplicationFieldConfig, UUID> {

  List<ApplicationFieldConfig> findByApplication(ClientApplication application);

  List<ApplicationFieldConfig> findByApplicationAndIsIncluded(
      ClientApplication application, boolean isIncluded);

  Optional<ApplicationFieldConfig> findByApplicationAndField(
      ClientApplication application, FormFieldMaster field);
}
