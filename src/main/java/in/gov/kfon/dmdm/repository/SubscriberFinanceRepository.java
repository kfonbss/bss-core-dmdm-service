package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberFinance;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberFinanceRepository extends JpaRepository<SubscriberFinance, UUID> {}
