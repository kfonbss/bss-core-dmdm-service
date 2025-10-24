package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.RolesModules;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesModulesRepository extends JpaRepository<RolesModules, UUID> {}
