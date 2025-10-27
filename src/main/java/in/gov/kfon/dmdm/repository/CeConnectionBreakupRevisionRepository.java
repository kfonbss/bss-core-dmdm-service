package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeConnectionBreakupMovementRevision;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeConnectionBreakupRevisionRepository
    extends JpaRepository<CeConnectionBreakupMovementRevision, UUID> {}
