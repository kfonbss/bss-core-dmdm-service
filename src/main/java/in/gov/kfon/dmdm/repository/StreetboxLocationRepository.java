package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.StreetboxLocation;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StreetboxLocationRepository extends JpaRepository<StreetboxLocation, UUID> {

  @Query(
      "SELECT s FROM StreetboxLocation s WHERE s.district IN "
          + "(SELECT d.name FROM District d WHERE d.state.code = :stateCode)")
  List<StreetboxLocation> findByStateCode(@Param("stateCode") String stateCode);
}
