package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeDnoteMaster;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeDnoteMasterRepository extends JpaRepository<CeDnoteMaster, UUID> {}
