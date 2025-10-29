package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeInovoiceMaster;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeInovoiceMasterRepository extends JpaRepository<CeInovoiceMaster, UUID> {}
