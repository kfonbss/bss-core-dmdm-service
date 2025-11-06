package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceAcknowledgement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceAcknowledgementRepository
    extends JpaRepository<InvDeviceAcknowledgement, UUID> {}
