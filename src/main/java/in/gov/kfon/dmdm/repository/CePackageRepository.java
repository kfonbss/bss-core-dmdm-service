package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CePackage;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CePackageRepository extends JpaRepository<CePackage, UUID> {}
