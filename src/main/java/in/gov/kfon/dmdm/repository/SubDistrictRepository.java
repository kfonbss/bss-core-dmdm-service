package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubDistrict;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubDistrictRepository extends JpaRepository<SubDistrict, UUID> {
  List<SubDistrict> findByDistrictDistrictIdAndIsActiveTrueOrderByNameAsc(UUID districtId);
}
