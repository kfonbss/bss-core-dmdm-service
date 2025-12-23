package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.Data;

@Data
public class CommonLookUp {
  private UUID id;
  private String code;
  private String name;
  private String nameInLocal;
  private Boolean isActive;
  private String district;
}
