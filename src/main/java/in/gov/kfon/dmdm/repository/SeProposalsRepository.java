package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeProposals;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeProposalsRepository extends JpaRepository<SeProposals, UUID> {}
