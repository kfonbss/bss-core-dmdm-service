package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeSubscribers;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeSubscribersRepository extends JpaRepository<CeSubscribers, UUID> {}
