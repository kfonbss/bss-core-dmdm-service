package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeWorkOrder;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeWorkOrderRepository extends JpaRepository<CeWorkOrder, UUID> {}
