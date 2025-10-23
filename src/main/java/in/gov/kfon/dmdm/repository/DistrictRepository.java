package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.District;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, UUID> {}
