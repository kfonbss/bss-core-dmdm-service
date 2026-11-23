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
public class DfPopListResponse {
  private UUID id;
  private Integer dfPopListId;
  private String name;
  private String code;
  private String nameInLocal;
  private Boolean isActive;
}
