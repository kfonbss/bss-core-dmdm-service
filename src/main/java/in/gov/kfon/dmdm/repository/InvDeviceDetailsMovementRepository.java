package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceDetailsMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceDetailsMovementRepository
    extends JpaRepository<InvDeviceDetailsMovement, UUID> {}
