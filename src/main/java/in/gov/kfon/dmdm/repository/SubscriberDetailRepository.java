package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberDetail;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberDetailRepository extends JpaRepository<SubscriberDetail, UUID> {}
