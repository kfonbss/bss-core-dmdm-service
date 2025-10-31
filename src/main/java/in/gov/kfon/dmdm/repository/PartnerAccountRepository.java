package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerAccountRepository extends JpaRepository<PartnerAccount, UUID> {}
