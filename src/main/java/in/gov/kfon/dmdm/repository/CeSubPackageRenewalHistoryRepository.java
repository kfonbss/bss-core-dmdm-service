package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeSubPackageRenewalHistory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeSubPackageRenewalHistoryRepository
    extends JpaRepository<CeSubPackageRenewalHistory, UUID> {}
