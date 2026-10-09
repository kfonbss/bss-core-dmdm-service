package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PackageType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageTypeRepository extends JpaRepository<PackageType, UUID> {

  List<PackageType> findAllByOrderByPackageTypeIdAsc();
}
