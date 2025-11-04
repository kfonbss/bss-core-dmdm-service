package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfDemandNoteMaster;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfDemandNoteMasterRepository extends JpaRepository<DfDemandNoteMaster, UUID> {}
