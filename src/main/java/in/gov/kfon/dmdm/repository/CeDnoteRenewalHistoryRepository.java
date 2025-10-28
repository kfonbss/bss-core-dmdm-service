package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeDnoteRenewalHistory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeDnoteRenewalHistoryRepository
    extends JpaRepository<CeDnoteRenewalHistory, UUID> {}
