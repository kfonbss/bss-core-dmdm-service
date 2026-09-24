package in.gov.kfon.dmdm.contract;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NmsDetailRequest {

  @NotBlank(message = "IP is required")
  private String ip;

  @NotBlank(message = "Token is required")
  private String token;

  @NotBlank(message = "State code is required")
  private String stateCode;

  private String description;
}
