package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.constant.LocationType;
import in.gov.kfon.dmdm.model.BlockDetail;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockDetailRepository extends JpaRepository<BlockDetail, UUID> {
  List<BlockDetail> findByLocTypeAndDistrictEntityDistrictIdAndVillageTypeIdAndIsActive(
      LocationType locationType, UUID districtId, int villageTypeId, boolean isActive);
}
