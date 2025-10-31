package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CePaymentKycDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CePaymentKycDetailsRepository extends JpaRepository<CePaymentKycDetails, UUID> {}
