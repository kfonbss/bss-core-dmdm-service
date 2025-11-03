package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfRenewalDetails;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfRenewalDetailsRepository extends JpaRepository<DfRenewalDetails, UUID> {

  Optional<DfRenewalDetails> findByDfRenewalDetailsId(UUID id);
}
