package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeCustomers;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeCustomersRepository extends JpaRepository<SeCustomers, UUID> {}
