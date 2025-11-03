package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfPowerRating;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfPowerRatingRepository extends JpaRepository<DfPowerRating, UUID> {

  Optional<DfPowerRating> findByDfPowerRatingId(UUID powerRatingId);
}
