package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SysConfig;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysConfigRepository extends JpaRepository<SysConfig, UUID> {
  // state_code has no unique constraint in the legacy-migrated schema (changelog-0.0.8.sql) — using
  // findFirst rather than findBy to avoid a runtime exception if a state_code has multiple rows.
  Optional<SysConfig> findFirstByStateCodeIgnoreCase(String stateCode);
}
