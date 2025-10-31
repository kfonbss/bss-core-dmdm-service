package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerConfirmationFromAgnp;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerConfirmationFromAgnpRepository
    extends JpaRepository<PartnerConfirmationFromAgnp, UUID> {}
