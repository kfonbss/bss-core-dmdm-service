package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeConnectionBreakupMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeConnectionBreakupMovementRepository
    extends JpaRepository<CeConnectionBreakupMovement, UUID> {}
