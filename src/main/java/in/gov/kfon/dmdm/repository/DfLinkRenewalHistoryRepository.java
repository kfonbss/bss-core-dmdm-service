package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfLinkRenewalHistory;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfLinkRenewalHistoryRepository extends JpaRepository<DfLinkRenewalHistory, UUID> {

  Optional<DfLinkRenewalHistory> findByHistoryId(UUID historyId);
}
