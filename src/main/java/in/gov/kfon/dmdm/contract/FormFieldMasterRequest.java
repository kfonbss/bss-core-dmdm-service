package in.gov.kfon.dmdm.contract;

import in.gov.kfon.dmdm.constant.FieldCategory;
import in.gov.kfon.dmdm.constant.FieldType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormFieldMasterRequest {

  private String fieldKey;
  private String fieldLabel;
  private FieldType fieldType;
  private FieldCategory fieldCategory;
  private String defaultValidations;
  private String metadata;
  private Boolean isSystem;
  private Boolean isActive;
}