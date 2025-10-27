package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Packages;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackagesRepository extends JpaRepository<Packages, UUID> {}
