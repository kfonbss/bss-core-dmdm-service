package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberFeedback;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberFeedbackRepository extends JpaRepository<SubscriberFeedback, UUID> {}
