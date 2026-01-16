package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.constant.LocationType;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.repository.BlockDetailRepository;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlockDetailServiceImpl implements BlockDetailService {
  private final BlockDetailRepository blockDetailRepository;

  @Override
  public List<CommonLookUp> fetchCorporationName(UUID districtId, int villageTypeId) {
    return blockDetailRepository
        .findByLocTypeAndDistrictEntityDistrictIdAndVillageTypeIdAndIsActive(
            LocationType.URBAN, districtId, villageTypeId, true)
        .stream()
        .map(
            blockDetail -> {
              return CommonLookUp.builder()
                  .id(blockDetail.getUuid())
                  .name(blockDetail.getVillageName())
                  .build();
            })
        .toList();
  }

  @Override
  public List<CommonLookUp> fetchPanchayatName(UUID districtId, int villageTypeId) {
    return blockDetailRepository
        .findByLocTypeAndDistrictEntityDistrictIdAndVillageTypeIdAndIsActive(
            LocationType.RURAL, districtId, villageTypeId, true)
        .stream()
        .filter(b -> b.getBlockId() != 0)
        .map(
            blockDetail -> {
              return CommonLookUp.builder()
                  .id(blockDetail.getUuid())
                  .name(blockDetail.getVillageName())
                  .build();
            })
        .toList();
  }

  @Override
  public List<CommonLookUp> fetchBlockName(UUID districtId, int villageTypeId) {
    return blockDetailRepository
        .findByLocTypeAndDistrictEntityDistrictIdAndVillageTypeIdAndIsActive(
            LocationType.RURAL, districtId, villageTypeId, true)
        .stream()
        .filter(b -> b.getBlockId() != 0)
        .map(
            blockDetail -> {
              return CommonLookUp.builder()
                  .id(blockDetail.getUuid())
                  .name(blockDetail.getBlockName())
                  .build();
            })
        .toList();
  }
}
