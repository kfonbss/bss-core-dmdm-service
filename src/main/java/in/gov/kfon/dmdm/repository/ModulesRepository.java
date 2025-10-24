package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Modules;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModulesRepository extends JpaRepository<Modules, UUID> {}
