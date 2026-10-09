package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Service type master row (service_type). */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceTypeResponse {
  private UUID id;
  private Integer typeId;
  private String code;
  private String name;
  private String nameInLocal;
  private Boolean isActive;

  /** Every service type except INTERNET needs an R-code (sub-package type) on its sub-package. */
  private Boolean requiresRCode;
}
