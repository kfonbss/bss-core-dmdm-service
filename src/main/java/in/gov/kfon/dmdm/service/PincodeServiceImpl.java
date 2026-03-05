package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.PinCodeDistrictResponse;
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
    return pincodeDetailsRepository.findAll().stream().map(this::mapToCommonLookUp).toList();
  }

  private CommonLookUp mapToCommonLookUp(PincodeDetails pd) {
    return CommonLookUp.builder()
        .id(pd.getId())
        .code(pd.getCode())
        .pincode(pd.getPincode())
        .name(pd.getPostOfficeName())
        .nameInLocal(pd.getNameInLocal())
        .isActive(pd.getIsActive())
        .district(pd.getDistrict())
        .districtCode(pd.getDistrictCode())
        .districtId(pd.getDistrictMaster().getDistrictId())
        .build();
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
  public List<CommonLookUp> fetchPostOfficeDetailsByPincode(Integer pincode) {

    List<PincodeDetails> entities =
        pincodeDetailsRepository.findAllByPincodeAndIsActiveTrue(pincode);

    if (entities.isEmpty()) {
      throw new EntityNotFoundException("No post offices found for pincode: " + pincode);
    }

    return entities.stream()
        .map(
            entity -> {
              CommonLookUp lookup = new CommonLookUp();
              lookup.setId(entity.getId());
              lookup.setCode(String.valueOf(entity.getPincode()));
              lookup.setName(entity.getPostOfficeName());
              lookup.setNameInLocal(entity.getNameInLocal());
              lookup.setIsActive(entity.getIsActive());
              if (entity.getDistrictMaster() != null) {
                lookup.setDistrict(entity.getDistrictMaster().getName());
                lookup.setDistrictId(entity.getDistrictMaster().getDistrictId());
              }
              lookup.setDistrictCode(entity.getDistrictCode());
              return lookup;
            })
        .toList();
  }

  public PinCodeDistrictResponse getDistrictDetails(Integer pinCode) {
    PincodeDetails pincodeDetails =
        pincodeDetailsRepository.findAllByPincodeAndIsActiveTrue(pinCode).stream()
            .findFirst()
            .orElseThrow(() -> new EntityNotFoundException("Pincode not found: " + pinCode));

    return PinCodeDistrictResponse.builder()
        .pinCode(pinCode)
        .district(pincodeDetails.getDistrict())
        .districtId(
            pincodeDetails.getDistrictMaster() != null
                ? pincodeDetails.getDistrictMaster().getDistrictId()
                : null)
        .build();
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchPincodeDetailsByDistrictIds(List<UUID> districtIds) {
    List<PincodeDetails> entities =
        pincodeDetailsRepository.findAllByDistrictMasterDistrictIdIn(districtIds);

    if (entities.isEmpty()) {
      throw new EntityNotFoundException(
          "No pincode details found for the given district IDs");
    }

    return entities.stream().map(this::mapToCommonLookUp).toList();
  }


}
