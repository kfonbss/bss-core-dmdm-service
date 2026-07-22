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
public class FormDefinitionRequest {

  private UUID applicationId;
  private String tenantId;       // null = app-level baseline
  private String formType;       // PARTNER_ONBOARDING | SUBSCRIBER_ONBOARDING
  private String name;
  private String description;
}
