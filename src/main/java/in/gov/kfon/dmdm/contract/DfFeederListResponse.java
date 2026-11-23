package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A dark fibre feeder (df_feeder_list): its UUID key, legacy integer id (df_link_details.feeder_id
 * on the subscriber side) and the legacy id of its POP (df_pop_list.id).
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DfFeederListResponse {
  private UUID listId;
  private Integer id;
  private Integer popId;
  private String feederName;
  private Integer noOfStrandsConsumed;
  private Boolean isActive;
}
