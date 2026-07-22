package in.gov.kfon.dmdm.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientApplicationRequest {

  private String appCode;
  private String appName;
  private String description;
  private Boolean isActive;
}