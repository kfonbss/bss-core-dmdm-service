package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Subscription;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {}
