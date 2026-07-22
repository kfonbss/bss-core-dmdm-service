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
public class FormDefinitionResponse {

  private UUID id;
  private UUID applicationId;
  private String appCode;
  private String tenantId;
  private String formType;
  private String name;
  private Integer version;
  private String status;
  private String description;
}
