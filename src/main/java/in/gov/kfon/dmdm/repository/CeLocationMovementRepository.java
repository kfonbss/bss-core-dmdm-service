package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeLocationMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeLocationMovementRepository extends JpaRepository<CeLocationMovement, UUID> {}
