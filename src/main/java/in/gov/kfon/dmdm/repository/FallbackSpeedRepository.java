package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.FallbackSpeed;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FallbackSpeedRepository extends JpaRepository<FallbackSpeed, UUID> {

  List<FallbackSpeed> findAllByOrderBySpeedMbAsc();

  List<FallbackSpeed> findByIsActiveTrueOrderBySpeedMbAsc();
}
