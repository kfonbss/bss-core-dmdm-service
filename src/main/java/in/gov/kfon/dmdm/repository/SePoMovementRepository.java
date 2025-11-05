package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SePoMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SePoMovementRepository extends JpaRepository<SePoMovement, UUID> {}
