package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberAccountRepository extends JpaRepository<SubscriberAccount, UUID> {}
