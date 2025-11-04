package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfTransDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfTransDetailsRepository extends JpaRepository<DfTransDetails, UUID> {}
