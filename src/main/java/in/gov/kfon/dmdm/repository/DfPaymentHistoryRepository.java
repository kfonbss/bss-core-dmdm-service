package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfPaymentHistory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfPaymentHistoryRepository extends JpaRepository<DfPaymentHistory, UUID> {}
