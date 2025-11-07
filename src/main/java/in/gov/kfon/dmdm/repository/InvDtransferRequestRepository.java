package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDtransferRequest;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDtransferRequestRepository extends JpaRepository<InvDtransferRequest, UUID> {}
