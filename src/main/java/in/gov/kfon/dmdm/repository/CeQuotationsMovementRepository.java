package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeQuotationsMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeQuotationsMovementRepository extends JpaRepository<CeQuotationsMovement, UUID> {}
