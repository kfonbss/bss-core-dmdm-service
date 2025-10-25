package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.TaxDistribution;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxDistributionRepository extends JpaRepository<TaxDistribution, UUID> {}
