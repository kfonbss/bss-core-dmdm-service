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
public class TenantFieldConfigRequest {

  private UUID fieldId;
  private Boolean isVisible;
  private Boolean isRequired;
  private Integer displayOrder;
  private String customLabel;
  private String customValidations;
}