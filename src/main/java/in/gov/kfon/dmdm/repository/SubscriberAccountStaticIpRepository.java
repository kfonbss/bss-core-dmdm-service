package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberAccountStaticIp;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberAccountStaticIpRepository
    extends JpaRepository<SubscriberAccountStaticIp, UUID> {}
