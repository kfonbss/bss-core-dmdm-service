package in.gov.kfon.dmdm.contract;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerCategoryResponse {
  private UUID id;
  private String name;
  private String description;
  private Boolean isActive;
  private List<String> options;
}
