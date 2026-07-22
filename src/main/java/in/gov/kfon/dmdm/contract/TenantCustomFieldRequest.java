package in.gov.kfon.dmdm.contract;

import in.gov.kfon.dmdm.constant.FieldType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenantCustomFieldRequest {

  private String fieldKey;
  private String fieldLabel;
  private FieldType fieldType;
  private String section;
  private Boolean isRequired;
  private Integer displayOrder;
  private String validations;
  private String metadata;
  private Boolean isActive;
}