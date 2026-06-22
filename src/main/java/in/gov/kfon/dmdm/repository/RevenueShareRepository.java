package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.RevenueShare;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevenueShareRepository extends JpaRepository<RevenueShare, UUID> {

  List<RevenueShare> findByProviderUuidAndIsActiveTrue(UUID providerUuid);

  List<RevenueShare> findBySubgroupAndProviderUuidIsNullAndIsActiveTrue(Integer subgroup);
}
