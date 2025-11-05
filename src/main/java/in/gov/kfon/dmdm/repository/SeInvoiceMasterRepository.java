package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeInvoiceMaster;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeInvoiceMasterRepository extends JpaRepository<SeInvoiceMaster, UUID> {}
