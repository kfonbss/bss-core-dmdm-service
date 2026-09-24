package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PaymentMode;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentModeRepository extends JpaRepository<PaymentMode, UUID> {
  List<PaymentMode> findByIsActiveTrueOrderByDisplayOrderAsc();

  Optional<PaymentMode> findByModeCode(String modeCode);
}