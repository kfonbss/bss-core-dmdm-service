package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.Pincodes;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodesRepository extends JpaRepository<Pincodes, UUID> {

  List<Pincodes> findAllByPincodeAndIsActiveTrue(String pincode);
}
