package in.gov.kfon.dmdm.contract;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DfOtcChargeResponse {
  private UUID chargesId;
  private Integer id;
  private BigDecimal amount;
  private BigDecimal opgwAmount;
  private BigDecimal addsIntercityAmount;
  private BigDecimal addsIntracityAmount;
  private BigDecimal opgwCoreCost;
  private BigDecimal opgwPairCost;
  private BigDecimal adssCoreCost;
  private BigDecimal adssPairCost;
  private BigDecimal otcAmount;
  private BigDecimal rackAmount;
  private String year;
  private Date fyearSDate;
  private Date fyearEDate;
  private String code;
  private String name;
  private String nameInLocal;
  private Boolean isActive;
  private java.util.Date createdDate;
  private java.util.Date modifiedDate;
  private UUID createdBy;
  private UUID modifiedBy;
}
