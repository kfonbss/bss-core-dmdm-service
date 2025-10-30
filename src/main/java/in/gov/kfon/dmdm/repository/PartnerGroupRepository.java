package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerGroup;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerGroupRepository extends JpaRepository<PartnerGroup, UUID> {}
