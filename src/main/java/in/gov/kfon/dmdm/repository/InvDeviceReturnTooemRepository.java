package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceReturnTooem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceReturnTooemRepository extends JpaRepository<InvDeviceReturnTooem, UUID> {}
