package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvPoDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvPoDetailsRepository extends JpaRepository<InvPoDetails, UUID> {}
