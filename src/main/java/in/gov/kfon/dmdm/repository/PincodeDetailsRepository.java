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

  /**
   * Matches the circle code (KL) as well as the district's numeric state code (32), mapped through
   * invoice_statecode, since districts store the numeric code that state.code uses.
   */
  @Query(
      "SELECT p FROM PincodeDetails p WHERE p.districtMaster.state.code = :stateCode"
          + " OR p.districtMaster.state.code IN (SELECT i.stateCode FROM InvoiceStateCode i"
          + " WHERE UPPER(TRIM(i.stCode)) = UPPER(:stateCode))")
  List<PincodeDetails> findByDistrictMasterStateCode(@Param("stateCode") String stateCode);

  /**
   * Active post offices of the pincode that lie in the circle. The circle code (KL, LD) is matched
   * against the district's raw state_code either directly (LD) or through its numeric state code
   * from invoice_statecode (KL -> 32), since districts store the numeric code that state.code uses.
   * A post office with no district is kept, since its circle is unknown.
   */
  @Query(
      value =
          "SELECT p.* FROM pincode_details p"
              + " LEFT JOIN district d ON d.district_id = p.district_id"
              + " WHERE p.pincode = :pincode AND p.is_active = true"
              + " AND (d.district_id IS NULL OR UPPER(d.state_code) = UPPER(:stateCode)"
              + " OR d.state_code IN (SELECT i.state_code FROM invoice_statecode i"
              + " WHERE UPPER(TRIM(i.stcode)) = UPPER(:stateCode)))",
      nativeQuery = true)
  List<PincodeDetails> findActiveByPincodeInCircle(
      @Param("pincode") Integer pincode, @Param("stateCode") String stateCode);
}
