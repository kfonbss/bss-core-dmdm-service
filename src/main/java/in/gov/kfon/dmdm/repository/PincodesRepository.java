package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Pincodes;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodesRepository extends JpaRepository<Pincodes, UUID> {

  Optional<Pincodes> findByPincodeAndIsActiveTrue(String pincode);
}
