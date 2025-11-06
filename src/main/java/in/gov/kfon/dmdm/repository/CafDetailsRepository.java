package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CafDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CafDetailsRepository extends JpaRepository<CafDetails, UUID> {
}
