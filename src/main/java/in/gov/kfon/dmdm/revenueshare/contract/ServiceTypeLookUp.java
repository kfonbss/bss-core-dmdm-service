package in.gov.kfon.dmdm.revenueshare.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceTypeLookUp {
  private UUID id;
  private Integer intId;
  private String code;
  private String name;
  private String nameInLocal;
}
