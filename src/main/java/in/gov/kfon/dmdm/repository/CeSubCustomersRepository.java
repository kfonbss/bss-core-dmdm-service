package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeSubCustomers;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeSubCustomersRepository extends JpaRepository<CeSubCustomers, UUID> {}
