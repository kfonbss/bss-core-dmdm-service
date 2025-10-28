package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberContactInformation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberContactInformationRepository
    extends JpaRepository<SubscriberContactInformation, UUID> {}
