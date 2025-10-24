package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Roles;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, UUID> {}
