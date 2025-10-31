package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeRenewalDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeRenewalDetailsRepository extends JpaRepository<CeRenewalDetails, UUID> {}
