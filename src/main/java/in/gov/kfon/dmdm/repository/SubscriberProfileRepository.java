package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberProfile;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberProfileRepository extends JpaRepository<SubscriberProfile, UUID> {}
