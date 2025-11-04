package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfCustomerDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfCustomerDetailsRepository extends JpaRepository<DfCustomerDetails, UUID> {}
