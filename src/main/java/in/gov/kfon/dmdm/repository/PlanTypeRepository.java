package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PlanType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanTypeRepository extends JpaRepository<PlanType, UUID> {

  List<PlanType> findAllByOrderByPlanTypeIdAsc();
}
