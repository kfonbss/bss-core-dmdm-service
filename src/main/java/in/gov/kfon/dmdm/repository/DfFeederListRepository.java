package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfFeederList;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfFeederListRepository extends JpaRepository<DfFeederList, UUID> {}
