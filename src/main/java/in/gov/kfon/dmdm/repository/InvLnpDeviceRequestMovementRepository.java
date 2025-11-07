package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvLnpDeviceRequestMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvLnpDeviceRequestMovementRepository
    extends JpaRepository<InvLnpDeviceRequestMovement, UUID> {}
