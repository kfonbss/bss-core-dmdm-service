package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SpeedProfile;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeedProfileRepository extends JpaRepository<SpeedProfile, UUID> {

  List<SpeedProfile> findAllByOrderBySpeedMbAsc();

  List<SpeedProfile> findByIsActiveTrueOrderBySpeedMbAsc();
}
