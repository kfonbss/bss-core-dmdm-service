package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Pincodes;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PincodesRepository extends JpaRepository<Pincodes, UUID> {

  List<Pincodes> findAllByPincodeAndIsActiveTrue(String pincode);

  @Query(
      "SELECT p FROM Pincodes p WHERE p.districtId IN "
          + "(SELECT d.districtId FROM District d WHERE d.state.code = :stateCode)")
  List<Pincodes> findByStateCode(@Param("stateCode") String stateCode);
}
