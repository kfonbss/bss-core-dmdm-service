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
public class FormDefinitionFieldRequest {

  private UUID sectionId;
  private UUID fieldId;         // null for custom fields
  private String fieldKey;      // required when fieldId is null (custom field)
  private String fieldType;     // required when fieldId is null (custom field)
  private String customLabel;
  private String placeholder;
  private String defaultValue;
  private Boolean isRequired;
  private Boolean isVisible;
  private Boolean isReadonly;
  private Integer displayOrder;
  private String customValidations;
  private String lookupType;
}
