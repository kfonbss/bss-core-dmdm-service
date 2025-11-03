package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfLinkDetails;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfLinkDetailsRepository extends JpaRepository<DfLinkDetails, UUID> {

  Optional<DfLinkDetails> findByDetailsId(UUID detailsId);
}
