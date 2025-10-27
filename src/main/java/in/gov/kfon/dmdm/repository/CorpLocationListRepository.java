package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CorpLocationList;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorpLocationListRepository extends JpaRepository<CorpLocationList, UUID> {
  Optional<CorpLocationList> findByListId(UUID id);
}
