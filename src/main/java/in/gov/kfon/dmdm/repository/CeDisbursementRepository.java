package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeDisbursement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeDisbursementRepository extends JpaRepository<CeDisbursement, UUID> {}
