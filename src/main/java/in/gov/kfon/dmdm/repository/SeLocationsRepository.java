package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeLocations;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeLocationsRepository extends JpaRepository<SeLocations, UUID> {}
