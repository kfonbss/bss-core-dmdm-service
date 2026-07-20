package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.RailTerritoryName;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RailTerritoryNameRepository extends JpaRepository<RailTerritoryName, UUID> {
  List<RailTerritoryName> findByStcodeAndStatus(Integer stcode, Integer status);
}