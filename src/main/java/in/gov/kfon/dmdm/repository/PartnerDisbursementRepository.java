package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerDisbursement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerDisbursementRepository extends JpaRepository<PartnerDisbursement, UUID> {}
