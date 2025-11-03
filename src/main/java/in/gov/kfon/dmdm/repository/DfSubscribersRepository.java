package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfSubscribers;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfSubscribersRepository extends JpaRepository<DfSubscribers, UUID> {}
