package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Package plan type master row (package_plan_type). */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PackagePlanTypeResponse {
  private UUID id;
  private Integer intId;
  private String code;
  private String name;
  private String nameInLocal;
  private Boolean isActive;
  private UUID categoryTypeId;
  private String categoryTypeCode;
}
