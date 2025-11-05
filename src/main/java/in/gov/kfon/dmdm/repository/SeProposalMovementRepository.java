package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeProposalMovement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeProposalMovementRepository extends JpaRepository<SeProposalMovement, UUID> {}
