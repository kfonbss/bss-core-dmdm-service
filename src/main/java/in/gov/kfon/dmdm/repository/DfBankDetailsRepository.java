package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfBankDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfBankDetailsRepository extends JpaRepository<DfBankDetails, UUID> {}
