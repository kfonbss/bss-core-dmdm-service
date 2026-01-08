package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.constant.LocationType;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.VillageType;
import in.gov.kfon.dmdm.repository.VillageTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class VillageTypeServiceImpl implements VillageTypeService {
   private final VillageTypeRepository villageTypeRepository;

    @Override
    public List<CommonLookUp> fetchByLocationType(LocationType locationType) {
        List<VillageType> villageTypes = villageTypeRepository.findByLocTypeAndIsActive(locationType, true);
        if (villageTypes != null && !villageTypes.isEmpty()) {
            return villageTypes.stream().map(v -> fromVillageType().apply(v)).toList();
        } return new ArrayList<>();
    }

    public Function<VillageType, CommonLookUp> fromVillageType () {
        return villageType -> CommonLookUp.builder()
                .id(villageType.getVillageId())
                .name(villageType.getVillageType())
                .villageTypeId(villageType.getVillageTypeId())
                .isActive(villageType.isActive()).build();
    }

}
