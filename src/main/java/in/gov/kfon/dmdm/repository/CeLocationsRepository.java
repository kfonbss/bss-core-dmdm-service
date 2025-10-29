package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeLocations;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeLocationsRepository extends JpaRepository<CeLocations, UUID> {}
