package in.gov.kfon.dmdm.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PinCodeDistrictResponse {
    private Integer pinCode;
    private String district;
    private UUID districtId;
}
