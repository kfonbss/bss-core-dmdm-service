package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvReturnFaultyRequest;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvReturnFaultyRequestRepository
    extends JpaRepository<InvReturnFaultyRequest, UUID> {}
