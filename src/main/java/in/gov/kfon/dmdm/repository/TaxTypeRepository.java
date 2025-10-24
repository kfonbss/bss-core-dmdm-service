package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.TaxType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxTypeRepository extends JpaRepository<TaxType, UUID> {}
