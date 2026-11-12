package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.constant.PaymentGatewayUserType;
import in.gov.kfon.dmdm.model.PaymentGatewayAvailability;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentGatewayAvailabilityRepository
    extends JpaRepository<PaymentGatewayAvailability, UUID> {

  List<PaymentGatewayAvailability> findByStateCodeIgnoreCaseOrderByUserTypeAscDisplayOrderAsc(
      String stateCode);

  List<PaymentGatewayAvailability>
      findByStateCodeIgnoreCaseAndUserTypeAndIsActiveTrueOrderByDisplayOrderAsc(
          String stateCode, PaymentGatewayUserType userType);

  boolean existsByStateCodeIgnoreCaseAndGateway_GatewayIdAndUserType(
      String stateCode, UUID gatewayId, PaymentGatewayUserType userType);
}
