package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.constant.LocationType;
import in.gov.kfon.dmdm.model.BlockDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlockDetailRepository extends JpaRepository<BlockDetail, UUID> {
    public List<BlockDetail> findByLocTypeAndDistrictIdAndVillageTypeIdAndIsActive(
            LocationType locationType, int districtId, int villageTypeId, boolean isActive);
}
