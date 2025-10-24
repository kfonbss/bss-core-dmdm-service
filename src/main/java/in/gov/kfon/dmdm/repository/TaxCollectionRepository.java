package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.TaxCollection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxCollectionRepository extends JpaRepository<TaxCollection, UUID> {}
