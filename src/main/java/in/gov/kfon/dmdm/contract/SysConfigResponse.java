package in.gov.kfon.dmdm.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysConfigResponse {
  private String tenantId;
  private String aaaIp;
}
