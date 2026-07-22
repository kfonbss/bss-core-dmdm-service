package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.TenantCustomField;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantCustomFieldRepository extends JpaRepository<TenantCustomField, UUID> {

  List<TenantCustomField> findByTenantIdAndApplicationAndIsActive(
      String tenantId, ClientApplication application, boolean isActive);

  List<TenantCustomField> findByTenantIdAndIsActive(String tenantId, boolean isActive);
}
