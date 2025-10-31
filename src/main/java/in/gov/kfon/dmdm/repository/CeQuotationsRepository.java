package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeQuotations;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeQuotationsRepository extends JpaRepository<CeQuotations, UUID> {}
