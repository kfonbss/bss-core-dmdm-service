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
public class FormDefinitionFieldResponse {

  private UUID id;
  private UUID formDefinitionId;
  private UUID sectionId;
  private UUID fieldId;
  private String fieldKey;
  private String fieldLabel;
  private String fieldType;
  private String customLabel;
  private String placeholder;
  private String defaultValue;
  private Boolean isRequired;
  private Boolean isVisible;
  private Boolean isReadonly;
  private Integer displayOrder;
  private String customValidations;
  private String metadata;
  private String lookupType;
}
