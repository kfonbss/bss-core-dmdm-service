package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfGroupDetailsMovent;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfGroupDetailsMoventRepository extends JpaRepository<DfGroupDetailsMovent, UUID> {

  Optional<DfGroupDetailsMovent> findByMoventId(UUID movementId);
}
