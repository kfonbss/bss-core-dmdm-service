package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfTransDetailsMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfTransDetailsMovementRepository
    extends JpaRepository<DfTransDetailsMovement, UUID> {}
