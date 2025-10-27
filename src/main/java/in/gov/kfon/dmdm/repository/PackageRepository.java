package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Package;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, UUID> {}
