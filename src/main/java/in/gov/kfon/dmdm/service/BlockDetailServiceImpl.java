package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.constant.LocationType;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.BlockDetail;
import in.gov.kfon.dmdm.repository.BlockDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlockDetailServiceImpl implements  BlockDetailService {
    private final BlockDetailRepository blockDetailRepository;

    @Override
    public List<CommonLookUp> fetchCorporationName(int districtId, int villageTypeId) {
        return blockDetailRepository.findByLocTypeAndDistrictIdAndVillageTypeIdAndIsActive(LocationType.URBAN, districtId, villageTypeId, true).stream()
                .map(blockDetail -> {
                    return CommonLookUp.builder().id(blockDetail.getUuid()).name(blockDetail.getBlockName()).build();
                }).toList();
    }

    @Override
    public List<CommonLookUp> fetchPanchayatName(int districtId, int villageTypeId) {
        return blockDetailRepository.findByLocTypeAndDistrictIdAndVillageTypeIdAndIsActive(LocationType.RURAL, districtId, villageTypeId, true).stream()
                .filter(b -> b.getBlockId() != 0).map(blockDetail -> {
                    return CommonLookUp.builder().id(blockDetail.getUuid()).name(blockDetail.getVillageName()).build();
                }).toList();
    }

    @Override
    public List<CommonLookUp> fetchBlockName(int districtId, int villageTypeId) {
        return blockDetailRepository.findByLocTypeAndDistrictIdAndVillageTypeIdAndIsActive(LocationType.RURAL, districtId, villageTypeId, true).stream()
                .filter(b -> b.getBlockId() != 0).map(blockDetail -> {
                    return CommonLookUp.builder().id(blockDetail.getUuid()).name(blockDetail.getBlockName()).build();
                }).toList();
    }
}
