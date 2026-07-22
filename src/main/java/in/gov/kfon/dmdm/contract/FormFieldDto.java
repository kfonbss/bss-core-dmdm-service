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
public class FormFieldDto {

  private String fieldKey;
  private String fieldLabel;
  private FieldType fieldType;
  private FieldCategory fieldCategory;
  private boolean required;
  private Integer displayOrder;
  private String section;
  private String validations;
  private String metadata;
  private String source; // MASTER or TENANT_CUSTOM
}