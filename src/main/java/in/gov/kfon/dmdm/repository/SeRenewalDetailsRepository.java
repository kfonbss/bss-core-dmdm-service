package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeRenewalDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeRenewalDetailsRepository extends JpaRepository<SeRenewalDetails, UUID> {}
