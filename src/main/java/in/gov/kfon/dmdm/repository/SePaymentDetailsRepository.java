package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SePaymentDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SePaymentDetailsRepository extends JpaRepository<SePaymentDetails, UUID> {}
