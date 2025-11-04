package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfWorkorder;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfWorkorderRepository extends JpaRepository<DfWorkorder, UUID> {}
