package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeOnlineApplication;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeOnlineApplicationRepository extends JpaRepository<CeOnlineApplication, UUID> {}
