package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Speed profile or fallback speed row. {@code code} is the value package.speed_profile /
 * package.fallbackspeed holds.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpeedResponse {
  private UUID id;
  private String code;
  private String name;
  private Integer speedMb;
  private Boolean isActive;
}
