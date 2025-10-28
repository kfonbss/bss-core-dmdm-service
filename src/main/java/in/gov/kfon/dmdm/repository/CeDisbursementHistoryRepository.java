package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeDisbursementHistory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeDisbursementHistoryRepository
    extends JpaRepository<CeDisbursementHistory, UUID> {}
