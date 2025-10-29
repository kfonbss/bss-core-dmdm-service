package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PopMasterBackup;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopMasterBackupRepository extends JpaRepository<PopMasterBackup, UUID> {}
