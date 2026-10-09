package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A plain code/name master row: package_type, plan_type or category_type. {@code intId} is that
 * table's own integer id column.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MasterTypeResponse {
  private UUID id;
  private Integer intId;
  private String code;
  private String name;
  private String nameInLocal;
  private Boolean isActive;
}
