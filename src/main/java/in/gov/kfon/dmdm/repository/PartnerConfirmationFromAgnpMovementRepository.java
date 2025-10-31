package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerConfirmationFromAgnpMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerConfirmationFromAgnpMovementRepository
    extends JpaRepository<PartnerConfirmationFromAgnpMovement, UUID> {}
