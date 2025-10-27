package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubscriberFeedbackRepository extends JpaRepository<SubscriberFeedback, UUID> {
}
