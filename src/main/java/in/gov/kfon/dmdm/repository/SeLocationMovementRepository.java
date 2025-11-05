package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeLocationMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeLocationMovementRepository extends JpaRepository<SeLocationMovement, UUID> {}
