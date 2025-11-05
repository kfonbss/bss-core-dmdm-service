package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SePurchaseOrder;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SePurchaseOrderRepository extends JpaRepository<SePurchaseOrder, UUID> {}
