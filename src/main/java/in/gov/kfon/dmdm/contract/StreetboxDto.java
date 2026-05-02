package in.gov.kfon.dmdm.contract;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StreetboxDto {

  private String equipmentName;
  private String popName;
  private String district;
  private String popType;

  private Double latitude;
  private Double longitude;

  private String type;
  private String category;
}
