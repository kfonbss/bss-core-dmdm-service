package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeQuotationsRevision;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeQuotationsRevisionRepository extends JpaRepository<CeQuotationsRevision, UUID> {}
