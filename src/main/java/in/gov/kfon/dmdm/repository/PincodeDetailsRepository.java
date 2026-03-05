package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PincodeDetails;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodeDetailsRepository extends JpaRepository<PincodeDetails, UUID> {

  List<PincodeDetails> findAllByPincodeAndIsActiveTrue(Integer pincode);

  List<PincodeDetails> findAllByDistrictMasterDistrictIdIn(List<UUID> districtIds);
}
