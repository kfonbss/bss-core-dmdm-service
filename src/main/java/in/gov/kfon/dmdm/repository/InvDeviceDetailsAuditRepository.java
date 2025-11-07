package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceDetailsAudit;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceDetailsAuditRepository
    extends JpaRepository<InvDeviceDetailsAudit, UUID> {}
