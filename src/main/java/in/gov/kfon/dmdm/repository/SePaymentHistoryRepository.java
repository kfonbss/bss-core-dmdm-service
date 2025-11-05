package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SePaymentHistory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SePaymentHistoryRepository extends JpaRepository<SePaymentHistory, UUID> {}
