package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceDetailsRepository extends JpaRepository<InvDeviceDetails, UUID> {}
