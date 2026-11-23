package in.gov.kfon.dmdm.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Change to a route's consumed strand count (df_masterdata.noof_strands_consumed): positive when
 * strands are given to a group link, negative when a rejected / disconnected link gives them back.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DfStrandsConsumedRequest {
  private Integer delta;
}
