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
public class LookupMasterResponse {

  private UUID id;
  private String lookupType;
  private String lookupCode;
  private String lookupValue;
  private String parentCode;
  private Integer displayOrder;
  private Boolean isActive;
}
