package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.TaxPayerType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxPayerRepository extends JpaRepository<TaxPayerType, UUID> {}
