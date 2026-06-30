package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.ServiceType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, UUID> {

  java.util.Optional<ServiceType> findByTypeId(Integer typeId);
}
