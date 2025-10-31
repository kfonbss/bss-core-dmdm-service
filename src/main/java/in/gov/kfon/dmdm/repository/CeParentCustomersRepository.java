package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeParentCustomers;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeParentCustomersRepository extends JpaRepository<CeParentCustomers, UUID> {}
