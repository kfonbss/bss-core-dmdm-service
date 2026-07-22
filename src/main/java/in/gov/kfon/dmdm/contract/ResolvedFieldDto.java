package in.gov.kfon.dmdm.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResolvedFieldDto {

  private String fieldKey;
  private String label;
  private String fieldType;
  private Boolean isRequired;
  private Boolean isVisible;
  private Boolean isReadonly;
  private Integer displayOrder;
  private String placeholder;
  private String defaultValue;
  private String validations;
  private String lookupType;
}
