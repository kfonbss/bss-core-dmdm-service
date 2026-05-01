package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.StreetboxLocation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetboxLocationRepository extends JpaRepository<StreetboxLocation, UUID> {}
