package in.gov.kfon.dmdm.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormSectionRequest {

  private String sectionKey;
  private String sectionLabel;
  private Integer displayOrder;
  private Boolean isVisible;
}
