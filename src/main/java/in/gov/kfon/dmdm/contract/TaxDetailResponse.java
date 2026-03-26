package in.gov.kfon.dmdm.contract;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaxDetailResponse {
  private UUID id;
  private String code;
  private String name;
  private String nameInLocal;
  private Boolean isActive;
  private Integer slNo;
  private BigDecimal lcoPanInd;
  private BigDecimal lcoPanOth;
  private BigDecimal lcoNoPan;
  private BigDecimal agpPan;
  private BigDecimal agpNoPan;
  private BigDecimal mspPan;
  private BigDecimal mspNoPan;
  private BigDecimal sgst;
  private BigDecimal cgst;
  private BigDecimal sgstTds;
  private BigDecimal cgstTds;
  private BigDecimal kfc;
  private BigDecimal transCharge;
  private String status;
  private Timestamp endDate;
  private String remarks;
}
