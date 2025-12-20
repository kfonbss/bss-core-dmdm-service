package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface PincodeService {

  List<CommonLookUp> fetchAllPincodes();

  CommonLookUp fetchPincodeById(UUID id);

  List<CommonLookUp> fetchAllPincodeDetails();

  CommonLookUp fetchPincodeDetailsById(UUID id);

  CommonLookUp fetchPostOfficeByPincode(String pincode);
}
