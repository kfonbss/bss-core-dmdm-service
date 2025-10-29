package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfPopList;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfPopListRepository extends JpaRepository<DfPopList, UUID> {}
