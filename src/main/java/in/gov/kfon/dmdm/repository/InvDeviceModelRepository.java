package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceModelRepository extends JpaRepository<InvDeviceModel, UUID> {}
