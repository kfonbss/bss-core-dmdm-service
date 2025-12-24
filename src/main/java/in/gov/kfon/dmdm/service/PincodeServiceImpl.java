package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.PincodeDetails;
import in.gov.kfon.dmdm.model.Pincodes;
import in.gov.kfon.dmdm.repository.PincodeDetailsRepository;
import in.gov.kfon.dmdm.repository.PincodesRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PincodeServiceImpl implements PincodeService {

  private final PincodesRepository pincodesRepository;
  private final PincodeDetailsRepository pincodeDetailsRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPincodes() {
    return pincodesRepository.findAll().stream()
        .map(
            pincodes -> {
              CommonLookUp response = modelMapper.map(pincodes, CommonLookUp.class);
              response.setCode(pincodes.getPincode());
              return response;
            })
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPincodeById(UUID id) {
    Pincodes p =
        pincodesRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Pincode not found with id: " + id));
    return modelMapper.map(p, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPincodeDetails() {
    return pincodeDetailsRepository.findAll().stream()
        .map(pd -> modelMapper.map(pd, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPincodeDetailsById(UUID id) {
    PincodeDetails pd =
        pincodeDetailsRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("PincodeDetails not found with id: " + id));
    return modelMapper.map(pd, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchPostOfficeByPincode(String pincode) {
    List<Pincodes> entities = pincodesRepository.findAllByPincodeAndIsActiveTrue(pincode);

    if (entities.isEmpty()) {
      throw new EntityNotFoundException("Post office not found for pincode: " + pincode);
    }

    return entities.stream()
        .map(
            entity -> {
              CommonLookUp lookup = new CommonLookUp();
              lookup.setId(entity.getId());
              lookup.setCode(entity.getPincode());
              lookup.setName(entity.getPostOfficeName());
              lookup.setNameInLocal(entity.getNameInLocal());
              lookup.setIsActive(entity.getIsActive());
              lookup.setDistrict(entity.getDistrict());
              return lookup;
            })
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPostOfficeDetailsByPincode(Integer pincode) {

    PincodeDetails entity =
        pincodeDetailsRepository
            .findFirstByPincodeAndIsActiveTrue(pincode)
            .orElseThrow(
                () -> new EntityNotFoundException("Post office not found for pincode: " + pincode));

    CommonLookUp lookup = new CommonLookUp();
    lookup.setId(entity.getId());
    lookup.setCode(String.valueOf(entity.getPincode()));
    lookup.setName(entity.getPostOfficeName());
    lookup.setNameInLocal(entity.getNameInLocal());
    lookup.setIsActive(entity.getIsActive());
    lookup.setDistrict(entity.getDistrict());

    return lookup;
  }
}
