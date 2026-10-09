package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.ServiceType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, UUID> {

  List<ServiceType> findAllByIsActiveTrueOrderByTypeIdAsc();

  Optional<ServiceType> findByIdAndIsActiveTrue(UUID id);
}
