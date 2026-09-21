package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import in.gov.kfon.dmdm.model.TenantFieldConfig;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantFieldConfigRepository extends JpaRepository<TenantFieldConfig, UUID> {

  List<TenantFieldConfig> findByTenantIdAndApplication(
      String tenantId, ClientApplication application);

  Optional<TenantFieldConfig> findByTenantIdAndApplicationAndField(
      String tenantId, ClientApplication application, FormFieldMaster field);

  List<TenantFieldConfig> findByTenantId(String tenantId);
}
