package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Partner;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, UUID> {}
