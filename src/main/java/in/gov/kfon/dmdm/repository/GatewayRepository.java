package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Gateway;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends JpaRepository<Gateway, UUID> {}
