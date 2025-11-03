package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfGroupDetails;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfGroupDetailsRepository extends JpaRepository<DfGroupDetails, UUID> {

  Optional<DfGroupDetails> findByDetailsId(UUID detailsId);
}
