package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.StateDistrict;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateDistrictRepository extends JpaRepository<StateDistrict, UUID> {

  Optional<StateDistrict> findFirstByStateCodeIgnoreCase(String stateCode);
}
