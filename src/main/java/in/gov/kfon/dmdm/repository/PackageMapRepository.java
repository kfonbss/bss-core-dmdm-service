package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PackageMap;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageMapRepository extends JpaRepository<PackageMap, UUID> {}
