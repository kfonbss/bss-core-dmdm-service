package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CafDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafDetailsRepository extends JpaRepository<CafDetails, UUID> {}
