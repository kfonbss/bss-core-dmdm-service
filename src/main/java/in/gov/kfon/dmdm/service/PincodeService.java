package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.PinCodeDistrictResponse;
import java.util.List;
import java.util.UUID;

public interface PincodeService {

  List<CommonLookUp> fetchAllPincodes(String stateCode);

  CommonLookUp fetchPincodeById(UUID id);

  List<CommonLookUp> fetchAllPincodeDetails(String stateCode);

  CommonLookUp fetchPincodeDetailsById(UUID id);

  List<CommonLookUp> fetchPostOfficeByPincode(String pincode);

  List<CommonLookUp> fetchPostOfficeDetailsByPincode(Integer pincode);

  /**
   * Post offices of the pincode, only if it lies in the given circle; otherwise the pincode is
   * reported as not serviceable in that circle.
   */
  List<CommonLookUp> fetchPostOfficeDetailsByPincode(Integer pincode, String stateCode);

  PinCodeDistrictResponse getDistrictDetails(Integer pinCode);

  List<CommonLookUp> fetchPincodeDetailsByDistrictIds(List<UUID> districtIds);

  CommonLookUp fetchPincodeDetailByPincode(Integer pincode);
}
