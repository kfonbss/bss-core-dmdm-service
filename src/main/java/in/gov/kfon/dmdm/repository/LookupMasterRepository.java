package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.LookupMaster;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LookupMasterRepository extends JpaRepository<LookupMaster, UUID> {

  // Global (no app, no tenant)
  List<LookupMaster> findByLookupTypeAndApplicationIsNullAndTenantIdIsNullAndIsActiveTrue(
      String lookupType);

  // App-level (no tenant)
  List<LookupMaster> findByLookupTypeAndApplicationAndTenantIdIsNullAndIsActiveTrue(
      String lookupType, ClientApplication application);

  // Tenant-level
  List<LookupMaster> findByLookupTypeAndApplicationAndTenantIdAndIsActiveTrue(
      String lookupType, ClientApplication application, String tenantId);

  List<LookupMaster> findByLookupTypeAndIsActiveTrue(String lookupType);
}
