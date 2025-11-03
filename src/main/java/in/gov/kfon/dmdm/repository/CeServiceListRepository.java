package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeServiceList;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeServiceListRepository extends JpaRepository<CeServiceList, UUID> {}
