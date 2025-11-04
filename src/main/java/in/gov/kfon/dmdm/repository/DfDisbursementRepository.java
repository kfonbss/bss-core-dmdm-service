package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfDisbursement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfDisbursementRepository extends JpaRepository<DfDisbursement, UUID> {}
