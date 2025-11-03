package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeSubFinance;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeSubFinanceRepository extends JpaRepository<CeSubFinance, UUID> {}
