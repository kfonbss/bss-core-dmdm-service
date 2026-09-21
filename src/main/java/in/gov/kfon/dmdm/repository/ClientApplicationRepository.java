package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.ClientApplication;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientApplicationRepository extends JpaRepository<ClientApplication, UUID> {

  List<ClientApplication> findByIsActive(boolean isActive);

  Optional<ClientApplication> findByAppCodeAndIsActive(String appCode, boolean isActive);

  Optional<ClientApplication> findByAppCode(String appCode);
}
