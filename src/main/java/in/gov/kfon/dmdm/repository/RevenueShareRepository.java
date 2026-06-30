package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.RevenueShare;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RevenueShareRepository
    extends JpaRepository<RevenueShare, UUID>, JpaSpecificationExecutor<RevenueShare> {

  List<RevenueShare> findByProviderUuidAndIsActiveTrue(UUID providerUuid);

  List<RevenueShare> findBySubgroupAndProviderUuidIsNullAndIsActiveTrue(Integer subgroup);
}
