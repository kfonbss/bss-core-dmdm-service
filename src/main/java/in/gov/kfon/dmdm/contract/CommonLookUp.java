package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonLookUp {
  private UUID id;
  private Integer masterId;
  private String code;
  private Integer pincode;
  private String name;
  private String nameInLocal;
  private Boolean isActive;
  private String district;
  private UUID districtId;
  private Integer villageTypeId;
  private Integer districtCode;
}
