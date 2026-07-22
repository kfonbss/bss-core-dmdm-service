package in.gov.kfon.dmdm.contract;

import in.gov.kfon.dmdm.constant.FieldCategory;
import in.gov.kfon.dmdm.constant.FieldType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationFieldConfigResponse {

  private UUID id;
  private UUID fieldId;
  private String fieldKey;
  private String fieldLabel;
  private FieldType fieldType;
  private FieldCategory fieldCategory;
  private Boolean isIncluded;
  private Boolean isRequired;
  private Integer displayOrder;
  private String section;
  private String customLabel;
  private String customValidations;
}