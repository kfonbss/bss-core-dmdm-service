package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfPurchaseOrder;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfPurchaseOrderRepository extends JpaRepository<DfPurchaseOrder, UUID> {

  Optional<DfPurchaseOrder> findByDfPurchaseOrderId(UUID purchaseOrderId);
}
