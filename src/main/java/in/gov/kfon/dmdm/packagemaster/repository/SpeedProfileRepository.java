package in.gov.kfon.dmdm.packagemaster.repository;

import in.gov.kfon.dmdm.packagemaster.model.SpeedProfile;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeedProfileRepository extends JpaRepository<SpeedProfile, UUID> {

  List<SpeedProfile> findAllByOrderBySpeedMbAsc();

  List<SpeedProfile> findByIsActiveTrueOrderBySpeedMbAsc();
}
