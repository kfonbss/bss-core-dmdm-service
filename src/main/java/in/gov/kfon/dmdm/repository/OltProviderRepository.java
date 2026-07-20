package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.OltProvider;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OltProviderRepository extends JpaRepository<OltProvider, UUID> {}
