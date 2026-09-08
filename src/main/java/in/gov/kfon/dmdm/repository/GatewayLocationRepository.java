package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.GatewayLocation;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatewayLocationRepository extends JpaRepository<GatewayLocation, UUID> {

  List<GatewayLocation> findByStateCodeIgnoreCaseAndStatus(String stateCode, Integer status);
}
