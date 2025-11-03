package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfGroupInvoiceMaster;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfGroupInvoiceMasterRepository extends JpaRepository<DfGroupInvoiceMaster, UUID> {

  Optional<DfGroupInvoiceMaster> findByMasterId(UUID masterId);
}
