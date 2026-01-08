package in.gov.kfon.dmdm.service;


import in.gov.kfon.dmdm.constant.LocationType;
import in.gov.kfon.dmdm.contract.CommonLookUp;

import java.util.List;

public interface VillageTypeService {

    public List<CommonLookUp> fetchByLocationType(LocationType locationType);

}
