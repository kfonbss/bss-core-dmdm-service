package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDtransferRmovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDtransferRmovementRepository
    extends JpaRepository<InvDtransferRmovement, UUID> {}
