package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeConnectionBreakup;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeConnectionBreakupRepository extends JpaRepository<CeConnectionBreakup, UUID> {}
