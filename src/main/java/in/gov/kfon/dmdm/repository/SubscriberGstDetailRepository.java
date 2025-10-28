package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberGstDetail;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberGstDetailRepository extends JpaRepository<SubscriberGstDetail, UUID> {}
