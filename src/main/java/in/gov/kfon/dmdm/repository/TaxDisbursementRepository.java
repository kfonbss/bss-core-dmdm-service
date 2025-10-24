package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.TaxDisbursement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxDisbursementRepository extends JpaRepository<TaxDisbursement, UUID> {}
