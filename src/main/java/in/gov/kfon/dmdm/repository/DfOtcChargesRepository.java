package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfOtcCharges;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfOtcChargesRepository extends JpaRepository<DfOtcCharges, UUID> {}
