package in.gov.kfon.dmdm.contract;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormSchemaResponse {

  private String appCode;
  private String tenantId;
  private List<FormSectionDto> sections;
}