package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PayoutCharge;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayoutChargeRepository extends JpaRepository<PayoutCharge, UUID> {
  List<PayoutCharge> findByIsActiveTrueOrderByModeAscStartRangeAsc();

  List<PayoutCharge> findByModeAndIsActiveTrueOrderByStartRangeAsc(String mode);
}
