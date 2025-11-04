package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfDemandNoteHistory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfDemandNoteHistoryRepository extends JpaRepository<DfDemandNoteHistory, UUID> {}
