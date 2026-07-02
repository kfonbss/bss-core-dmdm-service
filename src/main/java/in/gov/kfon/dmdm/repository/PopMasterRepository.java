package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PopMaster;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PopMasterRepository extends JpaRepository<PopMaster, UUID> {

  @Query(
      "SELECT p FROM PopMaster p WHERE p.district IN "
          + "(SELECT d.name FROM District d WHERE d.state.code = :stateCode)")
  List<PopMaster> findByStateCode(@Param("stateCode") String stateCode);
}
