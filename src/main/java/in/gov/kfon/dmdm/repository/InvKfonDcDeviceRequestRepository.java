package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvKfonDcDeviceRequest;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvKfonDcDeviceRequestRepository
    extends JpaRepository<InvKfonDcDeviceRequest, UUID> {}
