package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.BankAccountType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountTypeRepository extends JpaRepository<BankAccountType, UUID> {

  List<BankAccountType> findByIsActiveTrueOrderByDisplayOrderAsc();
}
