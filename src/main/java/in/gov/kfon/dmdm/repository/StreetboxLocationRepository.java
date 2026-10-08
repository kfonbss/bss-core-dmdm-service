package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.StreetboxLocation;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StreetboxLocationRepository extends JpaRepository<StreetboxLocation, UUID> {

  @Query(
      "SELECT s FROM StreetboxLocation s WHERE s.district IN "
          + "(SELECT d.name FROM District d WHERE d.state.code = :stateCode)")
  List<StreetboxLocation> findByStateCode(@Param("stateCode") String stateCode);

  /** Nearest streetbox of the state to a point (Haversine, metres). */
  @Query(
      value =
          "SELECT s.* FROM streetbox_location s"
              + " WHERE s.latitude IS NOT NULL AND s.longitude IS NOT NULL"
              + " AND s.district IN (SELECT d.name FROM district d WHERE d.state_code = :stateCode)"
              + " ORDER BY 2 * 6371000 * ASIN(SQRT(POWER(SIN(RADIANS(s.latitude - :lat) / 2), 2)"
              + " + COS(RADIANS(:lat)) * COS(RADIANS(s.latitude))"
              + " * POWER(SIN(RADIANS(s.longitude - :lon) / 2), 2))), s.snum"
              + " LIMIT 1",
      nativeQuery = true)
  Optional<StreetboxLocation> findNearestByStateCode(
      @Param("stateCode") String stateCode,
      @Param("lat") double latitude,
      @Param("lon") double longitude);
}
