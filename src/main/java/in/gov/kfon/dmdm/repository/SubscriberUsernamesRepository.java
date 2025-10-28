package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberUsernames;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberUsernamesRepository extends JpaRepository<SubscriberUsernames, UUID> {}
