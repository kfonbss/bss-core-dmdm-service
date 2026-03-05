package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.PinCodeDistrictResponse;
import java.util.List;
import java.util.UUID;

public interface PincodeService {

  List<CommonLookUp> fetchAllPincodes();

  CommonLookUp fetchPincodeById(UUID id);

  List<CommonLookUp> fetchAllPincodeDetails();

  CommonLookUp fetchPincodeDetailsById(UUID id);

  List<CommonLookUp> fetchPostOfficeByPincode(String pincode);

  List<CommonLookUp> fetchPostOfficeDetailsByPincode(Integer pincode);

  PinCodeDistrictResponse getDistrictDetails(Integer pinCode);

  List<CommonLookUp> fetchPincodeDetailsByDistrictIds(List<UUID> districtIds);
}
