package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Service;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, UUID> {}
