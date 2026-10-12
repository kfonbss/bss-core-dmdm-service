package in.gov.kfon.dmdm.packagemaster.repository;

import in.gov.kfon.dmdm.packagemaster.model.PackagePlanType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackagePlanTypeRepository extends JpaRepository<PackagePlanType, UUID> {

  @EntityGraph(attributePaths = "categoryType")
  List<PackagePlanType> findAllByOrderByPackagePlanTypeIdAsc();
}
