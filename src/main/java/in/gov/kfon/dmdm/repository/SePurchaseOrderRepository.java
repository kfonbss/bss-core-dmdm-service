package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SePurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SePurchaseOrderRepository extends JpaRepository<SePurchaseOrder, UUID> {
}
