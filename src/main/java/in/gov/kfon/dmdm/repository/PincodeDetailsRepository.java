package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PincodeDetails;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PincodeDetailsRepository extends JpaRepository<PincodeDetails, UUID> {

  List<PincodeDetails> findAllByPincodeAndIsActiveTrue(Integer pincode);

  List<PincodeDetails> findAllByDistrictMasterDistrictIdIn(List<UUID> districtIds);

  List<PincodeDetails> findByDistrictMasterStateCode(String stateCode);

  /**
   * Active post offices of the pincode that lie in the circle. Compares the district's raw
   * state_code: the state table does not always carry the circle code (LD's has numeric codes), so
   * the District-to-State join cannot be relied on. A post office with no district is kept, since
   * its circle is unknown.
   */
  @Query(
      value =
          "SELECT p.* FROM pincode_details p"
              + " LEFT JOIN district d ON d.district_id = p.district_id"
              + " WHERE p.pincode = :pincode AND p.is_active = true"
              + " AND (d.district_id IS NULL OR UPPER(d.state_code) = UPPER(:stateCode))",
      nativeQuery = true)
  List<PincodeDetails> findActiveByPincodeInCircle(
      @Param("pincode") Integer pincode, @Param("stateCode") String stateCode);
}
