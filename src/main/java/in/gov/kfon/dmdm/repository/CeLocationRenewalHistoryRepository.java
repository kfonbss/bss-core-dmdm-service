package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeLocationRenewalHistory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeLocationRenewalHistoryRepository
    extends JpaRepository<CeLocationRenewalHistory, UUID> {}
