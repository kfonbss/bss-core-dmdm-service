package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Village;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillageRepository extends JpaRepository<Village, UUID> {
  List<Village> findBySubDistrictSubDistrictIdAndIsActiveTrueOrderByNameAsc(UUID subDistrictId);
}
