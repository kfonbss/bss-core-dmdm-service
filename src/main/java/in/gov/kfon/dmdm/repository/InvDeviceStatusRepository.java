package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceStatus;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceStatusRepository extends JpaRepository<InvDeviceStatus, UUID> {}
