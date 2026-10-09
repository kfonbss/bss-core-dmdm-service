package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubPackageType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubPackageTypeRepository extends JpaRepository<SubPackageType, UUID> {

  @EntityGraph(attributePaths = "serviceTypeMaster")
  List<SubPackageType> findAllByOrderBySubPackageTypeIdAsc();

  @EntityGraph(attributePaths = "serviceTypeMaster")
  List<SubPackageType> findByServiceTypeMaster_IdOrderBySubPackageTypeIdAsc(UUID serviceTypeId);
}
