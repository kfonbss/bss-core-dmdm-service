package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.BankDetails;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepository extends JpaRepository<BankDetails, UUID> {
  Optional<Object> findByBankIfscCode(String ifsc);
}
