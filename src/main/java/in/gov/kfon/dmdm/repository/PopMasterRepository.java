package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PopMaster;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PopMasterRepository extends JpaRepository<PopMaster, UUID> {

  /**
   * Matches the circle code (KL) as well as the district's numeric state code (32), mapped through
   * invoice_statecode, since districts store the numeric code that state.code uses.
   */
  @Query(
      "SELECT p FROM PopMaster p WHERE p.district IN "
          + "(SELECT d.name FROM District d WHERE (d.state.code = :stateCode OR d.state.code IN "
          + "(SELECT i.stateCode FROM InvoiceStateCode i WHERE UPPER(TRIM(i.stCode)) = UPPER(:stateCode))))")
  List<PopMaster> findByStateCode(@Param("stateCode") String stateCode);
}
