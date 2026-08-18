package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Region;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, UUID> {
  List<Region> findByStatus(Integer status);
}
