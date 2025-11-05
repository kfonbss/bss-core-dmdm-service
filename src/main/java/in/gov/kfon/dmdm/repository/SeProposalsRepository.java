package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeProposals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeProposalsRepository extends JpaRepository<SeProposals, UUID> {
}
