package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PackageCategory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageCategoryRepository extends JpaRepository<PackageCategory, UUID> {}
