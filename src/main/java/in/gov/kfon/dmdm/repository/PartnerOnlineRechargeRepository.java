package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerOnlineRecharge;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerOnlineRechargeRepository
    extends JpaRepository<PartnerOnlineRecharge, UUID> {}
