package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.constant.LocationType;
import in.gov.kfon.dmdm.contract.BlockDetailResponse;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.BlockDetail;
import in.gov.kfon.dmdm.repository.BlockDetailRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlockDetailServiceImpl implements BlockDetailService {
  private final BlockDetailRepository blockDetailRepository;

  @Override
  @Cacheable(
      cacheNames = CacheNames.BLOCK_CORPORATION_BY_DISTRICT,
      key = "#districtId + ':' + #villageTypeId")
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
  @Cacheable(
      cacheNames = CacheNames.BLOCK_PANCHAYAT_BY_DISTRICT,
      key = "#districtId + ':' + #villageTypeId")
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
  @Cacheable(
      cacheNames = CacheNames.BLOCK_NAME_BY_DISTRICT,
      key = "#districtId + ':' + #villageTypeId")
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

  @Cacheable(cacheNames = CacheNames.BLOCK_BY_ID, key = "#blockId")
  public BlockDetailResponse fetchById(UUID blockId) {
    Optional<BlockDetail> blockDetail = blockDetailRepository.findById(blockId);
    if (blockDetail.isPresent()) {
      return BlockDetailResponse.builder()
          .id(blockDetail.get().getUuid())
          .villageName(blockDetail.get().getVillageName())
          .blockName(blockDetail.get().getBlockName())
          .villageType(blockDetail.get().getVillageType())
          .district(blockDetail.get().getDistrict())
          .type(blockDetail.get().getLocType())
          .districtId(blockDetail.get().getDistrictEntity().getDistrictId())
          .districtName(blockDetail.get().getDistrictEntity().getName())
          .build();
    }
    return BlockDetailResponse.builder().build();
  }
}
