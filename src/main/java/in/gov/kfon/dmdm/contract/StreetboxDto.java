package in.gov.kfon.dmdm.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
