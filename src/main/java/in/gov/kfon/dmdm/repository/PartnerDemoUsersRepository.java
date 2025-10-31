package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerDemoUsers;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerDemoUsersRepository extends JpaRepository<PartnerDemoUsers, UUID> {

  Optional<PartnerDemoUsers> findByUserId(UUID userId);
}
