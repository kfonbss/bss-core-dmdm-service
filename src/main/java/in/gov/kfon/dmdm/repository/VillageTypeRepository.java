package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.constant.LocationType;
import in.gov.kfon.dmdm.model.VillageType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageTypeRepository extends JpaRepository<VillageType, UUID> {
  public List<VillageType> findByLocTypeAndIsActive(LocationType locType, boolean isActive);
}
