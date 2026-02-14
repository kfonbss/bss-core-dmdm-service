package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.TaxType;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxTypeRepository extends JpaRepository<TaxType, UUID> {
    List<TaxType> findByTaxTypeId(int taxTypeId);
}
