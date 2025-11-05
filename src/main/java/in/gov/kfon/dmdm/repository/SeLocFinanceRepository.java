package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeLocFinance;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeLocFinanceRepository extends JpaRepository<SeLocFinance, UUID> {}
