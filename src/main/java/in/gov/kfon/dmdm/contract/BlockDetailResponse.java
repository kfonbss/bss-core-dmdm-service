package in.gov.kfon.dmdm.contract;

import in.gov.kfon.dmdm.constant.LocationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlockDetailResponse {
    private UUID id;
    private String villageName;
    private String blockName;
    private String villageType;
    private String district;
    private LocationType type;
    private UUID districtId;
    private String districtName;
}
