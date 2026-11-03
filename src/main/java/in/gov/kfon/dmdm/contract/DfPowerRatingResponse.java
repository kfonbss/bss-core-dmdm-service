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
public class DfPowerRatingResponse {
  private UUID dfPowerRatingId;
  private Long id;
  private Integer amount;
  private String powerRating;
  private String code;
  private String name;
  private String nameInLocal;
  private Boolean isActive;
  private Date createdDate;
  private Date modifiedDate;
  private UUID createdBy;
  private UUID modifiedBy;
}
