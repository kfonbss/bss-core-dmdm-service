package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerRevenue;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRevenueRepository extends JpaRepository<PartnerRevenue, UUID> {}
