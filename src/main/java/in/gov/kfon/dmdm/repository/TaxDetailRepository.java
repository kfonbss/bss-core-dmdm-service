package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.TaxDetail;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxDetailRepository extends JpaRepository<TaxDetail, UUID> {
  List<TaxDetail> findByIsActive(Boolean isActive);

  List<TaxDetail> findFirstByIsActive(Boolean isActive);
}
