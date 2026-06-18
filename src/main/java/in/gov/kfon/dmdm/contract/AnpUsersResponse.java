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
public class AnpUsersResponse {
  private UUID id;
  private String name;
  private String email;
  private String mobile;
  private String username;
  private String code;
  private Boolean isActive;
}
