package in.gov.kfon.dmdm.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceStateCodeResponse {
  private String stCode;
  private String stateCode;
}
