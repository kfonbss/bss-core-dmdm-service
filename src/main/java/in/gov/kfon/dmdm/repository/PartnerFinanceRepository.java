package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerFinance;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerFinanceRepository extends JpaRepository<PartnerFinance, UUID> {}
