package in.gov.kfon.dmdm.contract;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NmsDetailResponse {

  private UUID nmsDetailId;
  private String ip;
  private String token;
  private String stateCode;
  private String description;
  private Boolean isActive;
  private Date createdDate;
  private Date modifiedDate;
}
