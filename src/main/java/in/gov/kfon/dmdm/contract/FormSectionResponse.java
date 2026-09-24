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
public class FormSectionResponse {

  private UUID id;
  private UUID formDefinitionId;
  private String sectionKey;
  private String sectionLabel;
  private Integer displayOrder;
  private Boolean isVisible;
}
