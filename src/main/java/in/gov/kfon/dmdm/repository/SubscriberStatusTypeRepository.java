package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberStatusType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberStatusTypeRepository extends JpaRepository<SubscriberStatusType, UUID> {}
