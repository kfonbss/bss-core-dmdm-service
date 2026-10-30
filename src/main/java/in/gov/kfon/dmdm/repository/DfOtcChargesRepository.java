package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfOtcCharges;
import java.sql.Date;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfOtcChargesRepository extends JpaRepository<DfOtcCharges, UUID> {

  Optional<DfOtcCharges>
      findFirstByFyearSDateLessThanEqualAndFyearEDateGreaterThanEqualOrderByFyearSDateDesc(
          Date startDate, Date endDate);
}
