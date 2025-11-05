package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfMasterData;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfMasterDataRepository extends JpaRepository<DfMasterData, UUID> {}
