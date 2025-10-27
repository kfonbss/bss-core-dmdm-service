package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PackageChangeRequests;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageChangeRequestsRepository
    extends JpaRepository<PackageChangeRequests, UUID> {}
