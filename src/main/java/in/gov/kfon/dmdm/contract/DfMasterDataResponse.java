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
public class DfMasterDataResponse {
  private UUID dataId;
  private Integer id;
  private String district;
  private String linkType;
  private String linkTypeId;
  private String link;
  private String fiberType;
  private Double unitPrice;
  private Integer noOfStrands;
  private Integer noOfStrandsConsumed;
  private String code;
  private String name;
  private String nameInLocal;
  private Boolean isActive;
  private Date createdDate;
  private Date modifiedDate;
  private UUID createdBy;
  private UUID modifiedBy;
}
