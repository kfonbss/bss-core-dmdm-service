package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeCustomer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeCustomerRepository extends JpaRepository<CeCustomer, UUID> {}
