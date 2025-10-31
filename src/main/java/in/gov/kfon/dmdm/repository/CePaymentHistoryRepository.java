package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CePaymentHistory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CePaymentHistoryRepository extends JpaRepository<CePaymentHistory, UUID> {}
