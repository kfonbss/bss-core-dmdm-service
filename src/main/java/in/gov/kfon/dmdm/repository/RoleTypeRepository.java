package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.RoleType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleTypeRepository extends JpaRepository<RoleType, UUID> {}
