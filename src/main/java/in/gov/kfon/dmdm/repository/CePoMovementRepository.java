package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CePoMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CePoMovementRepository extends JpaRepository<CePoMovement, UUID> {}
