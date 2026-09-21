package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.NmsDetail;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NmsDetailRepository extends JpaRepository<NmsDetail, UUID> {

  Optional<NmsDetail> findByStateCodeAndIsActiveTrue(String stateCode);

  List<NmsDetail> findByIsActiveTrue();

  boolean existsByStateCode(String stateCode);
}
