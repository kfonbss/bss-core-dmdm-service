package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PopMaster;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopMasterRepository extends JpaRepository<PopMaster, UUID> {}
