package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfSubFinance;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfSubFinanceRepository extends JpaRepository<DfSubFinance, UUID> {

  Optional<DfSubFinance> findByDfSubFinanceId(UUID id);
}
