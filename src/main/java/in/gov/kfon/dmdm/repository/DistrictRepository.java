package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.District;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistrictRepository extends JpaRepository<District, UUID> {
  List<District> findByStateCode(String stateCode);

  /**
   * Districts of a state given either the state code stored on the district (32, LD) or the circle
   * / tenant code (KL), which is mapped to the numeric state code through invoice_statecode.
   */
  @Query(
      value =
          "SELECT d.* FROM district d"
              + " WHERE UPPER(d.state_code) = UPPER(:stateCode)"
              + " OR d.state_code IN (SELECT i.state_code FROM invoice_statecode i"
              + " WHERE UPPER(TRIM(i.stcode)) = UPPER(:stateCode))",
      nativeQuery = true)
  List<District> findByStateOrCircleCode(@Param("stateCode") String stateCode);
}
