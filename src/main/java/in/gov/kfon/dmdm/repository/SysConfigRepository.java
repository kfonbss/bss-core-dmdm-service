package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SysConfig;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysConfigRepository extends JpaRepository<SysConfig, UUID> {
  Optional<SysConfig> findByTenantIdIgnoreCaseAndIsActiveTrue(String tenantId);
}
